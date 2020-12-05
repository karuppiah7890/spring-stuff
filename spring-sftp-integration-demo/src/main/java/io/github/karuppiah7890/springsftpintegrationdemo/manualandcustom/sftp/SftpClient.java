package io.github.karuppiah7890.springsftpintegrationdemo.manualandcustom.sftp;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.sftp.RemoteFile;
import net.schmizz.sshj.sftp.RemoteResourceInfo;
import net.schmizz.sshj.sftp.SFTPClient;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SftpClient {
  private final SftpClientConfig sftpClientConfig;
  private SSHClient sshClient;
  private SFTPClient sftpClient;


  public SftpClient(SftpClientConfig sftpClientConfig) {
    this.sftpClientConfig = sftpClientConfig;
  }

  public List<String> listFiles(String path, FileNameFilter fileNameFilter) throws IOException {
    var remoteResourceFilter = new RemoteFileFilter(fileNameFilter);
    final List<RemoteResourceInfo> remoteFiles = sftpClient.ls(path, remoteResourceFilter);
    return remoteFiles.stream()
      .map((RemoteResourceInfo::getName))
      .collect(Collectors.toList());
  }

  public InputStream getFileInputStream(String path) throws IOException {
    RemoteFile remoteFile = sftpClient.open(path);
    return remoteFile.new RemoteFileInputStream();
  }

  public void connect() throws IOException {
    SSHClient client = new SSHClient();
    client.addHostKeyVerifier(new PromiscuousVerifier());
    client.connect(sftpClientConfig.getHost(), sftpClientConfig.getPort());
    client.authPassword(sftpClientConfig.getUsername(), sftpClientConfig.getPassword());
    this.sshClient = client;
    this.sftpClient = sshClient.newSFTPClient();
  }
}
