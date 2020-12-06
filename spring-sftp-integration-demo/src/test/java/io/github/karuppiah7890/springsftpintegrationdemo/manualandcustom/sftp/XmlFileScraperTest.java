package io.github.karuppiah7890.springsftpintegrationdemo.manualandcustom.sftp;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.TestPropertySource;

import java.io.IOException;
import java.time.Instant;

import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.*;

@TestPropertySource(properties = {
  "integrations.sftp.custom.enabled=true",
  "integrations.sftp.custom.poll.interval=100",
})
@SpringBootTest
@Slf4j
class XmlFileScraperTest {
  @SpyBean
  XmlFileScraper xmlFileScraper;

  @MockBean
  SftpClient sftpClient;

  // This is to test the @Schedule fixedDelayString config changes
  @Test
  void checkFixedDelayConfig() throws IOException {
    reset(xmlFileScraper);
    doAnswer(invocation -> {
      Instant startTime = Instant.now();
      log.info("Invoked scheduler at {}", startTime.toString());
      await().until(() -> startTime.plusMillis(600).isBefore(Instant.now()));
      log.info("Invocation completed at {}", Instant.now().toString());
      return null;
    }).when(xmlFileScraper).xmlScrapingPoll();
    verify(xmlFileScraper, after(1000).atLeast(2)).xmlScrapingPoll();
    verify(xmlFileScraper, after(1000).atMost(3)).xmlScrapingPoll();
  }
}
