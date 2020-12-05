package io.github.karuppiah7890.springsftpintegrationdemo.manualandcustom.sftp;

import net.schmizz.sshj.sftp.RemoteResourceFilter;
import net.schmizz.sshj.sftp.RemoteResourceInfo;

public class RemoteFileFilter implements RemoteResourceFilter {

  private final FileNameFilter fileNameFilter;

  public RemoteFileFilter(FileNameFilter fileNameFilter) {
    this.fileNameFilter = fileNameFilter;
  }

  @Override
  public boolean accept(RemoteResourceInfo resource) {
    if (resource.isDirectory()) {
      return false;
    }
    return fileNameFilter.accept(resource.getName());
  }
}
