package io.github.karuppiah7890.springsftpintegrationdemo.builtinexistingautomated;

import com.jcraft.jsch.ChannelSftp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.file.filters.AcceptAllFileListFilter;
import org.springframework.integration.file.remote.session.CachingSessionFactory;
import org.springframework.integration.file.remote.session.SessionFactory;
import org.springframework.integration.sftp.inbound.SftpStreamingMessageSource;
import org.springframework.integration.sftp.session.DefaultSftpSessionFactory;
import org.springframework.integration.sftp.session.SftpRemoteFileTemplate;
import org.springframework.integration.transformer.StreamTransformer;
import org.springframework.messaging.MessageHandler;

import java.io.InputStream;

@Configuration
public class SftpIntegration {
  @Bean
  @InboundChannelAdapter(channel = "stream", poller = @Poller(fixedDelay = "5000"))
  public MessageSource<InputStream> ftpMessageSource() {
    SftpStreamingMessageSource messageSource = new SftpStreamingMessageSource(template());
    messageSource.setRemoteDirectory("/");
    messageSource.setFilter(new AcceptAllFileListFilter<>());
    messageSource.setMaxFetchSize(1);
    return messageSource;
  }

  @Bean
  public SftpRemoteFileTemplate template() {
    return new SftpRemoteFileTemplate(sftpSessionFactory());
  }

  @Bean
  public SessionFactory<ChannelSftp.LsEntry> sftpSessionFactory() {
    DefaultSftpSessionFactory factory = new DefaultSftpSessionFactory(true);
    factory.setHost("localhost");
    factory.setPort(2022);
    factory.setUser("admin");
    factory.setPassword("admin");
    factory.setAllowUnknownKeys(true);
    return new CachingSessionFactory<>(factory);
  }

  @Bean
  @Transformer(inputChannel = "stream", outputChannel = "data")
  public org.springframework.integration.transformer.Transformer transformer() {
    return new StreamTransformer("UTF-8");
  }

  @ServiceActivator(inputChannel = "data")
  @Bean
  public MessageHandler handle() {
    return System.out::println;
  }
}
