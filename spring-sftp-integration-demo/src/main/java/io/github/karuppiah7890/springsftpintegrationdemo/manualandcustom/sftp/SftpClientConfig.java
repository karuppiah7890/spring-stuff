package io.github.karuppiah7890.springsftpintegrationdemo.manualandcustom.sftp;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "integrations.sftp.custom.connection")
@Configuration
@Getter
@Setter
public class SftpClientConfig {
  private String host;
  private int port;
  private String username;
  private String password;
}
