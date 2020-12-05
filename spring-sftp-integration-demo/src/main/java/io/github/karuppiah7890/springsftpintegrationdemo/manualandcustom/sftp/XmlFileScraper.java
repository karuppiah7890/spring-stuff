package io.github.karuppiah7890.springsftpintegrationdemo.manualandcustom.sftp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
@Component
@EnableScheduling
@ConditionalOnProperty({"integrations.sftp.enabled"})
public class XmlFileScraper {
  private final SftpClient sftpClient;

  public XmlFileScraper(SftpClient sftpClient) {
    this.sftpClient = sftpClient;
  }

  @Scheduled(fixedDelayString = "${integrations.sftp.poll.interval}")
  public void xmlScrapingPoll() throws IOException {
    log.info("XML Scraping poll invoked");
    // Connect to SFTP Server
    // Can we do this connection before even the task starts?
    // So that we don't connect for every time we run the task.
    // Is it okay to have long running connections? What about
    // reconnecting in case of failures? Hmm
    sftpClient.connect();
    // Use SFTP Client to get list of XML Files
    FileNameFilter xmlFileFiler = new XmlFileFilter();
    final List<String> xmlFiles = sftpClient.listFiles("/", xmlFileFiler);
    // Use SFTP Client to pull XML Files one by one in a loop
    xmlFiles
      .forEach(xmlFile -> {
        // For each XML File
        try (final InputStream fileInputStream = sftpClient.getFileInputStream(xmlFile);
             InputStreamReader inputStreamReader =
               new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
          bufferedReader.lines().forEach(log::info);
        } catch (IOException e) {
          e.printStackTrace();
        }
      });
    // Parse XML File
    // Dynamically Map XML Data to SomeDto using XPath
    // Use SomeDto to send request to some service
  }
}
