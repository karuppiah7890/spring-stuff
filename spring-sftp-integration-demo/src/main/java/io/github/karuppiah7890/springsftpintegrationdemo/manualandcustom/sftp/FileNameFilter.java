package io.github.karuppiah7890.springsftpintegrationdemo.manualandcustom.sftp;

public interface FileNameFilter {
  boolean accept(String name);
}
