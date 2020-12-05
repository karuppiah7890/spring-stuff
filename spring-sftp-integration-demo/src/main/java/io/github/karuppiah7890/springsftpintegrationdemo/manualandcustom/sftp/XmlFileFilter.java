package io.github.karuppiah7890.springsftpintegrationdemo.manualandcustom.sftp;

public class XmlFileFilter implements FileNameFilter {
  @Override
  public boolean accept(String name) {
    return name.endsWith(".xml");
  }
}
