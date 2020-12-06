# Story

I'm trying to understand Spring Integrations. The sample application that I want to try is - integrating with an SFTP
server which has some files, for example XML files, which I need to pull and process (parse, process etc) and maybe even
map it into another object dynamically and then call another service with it or maybe just log it for now. So, with this
aim, I'm going to try out stuff!

While bootstrapping the project, I missed adding the Spring Integration dependencies 😅 I think it's these two - one for
source code and another for test code

```groovy
implementation 'org.springframework.boot:spring-boot-starter-integration'
testImplementation 'org.springframework.integration:spring-integration-test'
```

I need to add these two and then I would be good to go I think! :)

---

I'm gonna start by upgrading the Gradle version to 6.7.1

---

I wrote a manual way to integrate with an SFTP server. The gradle tests don't run in my
terminal though. Not sure why. Some interrupted exception. But in IDE it works.

https://duckduckgo.com/?t=ffab&q=java.lang.InterruptedException%3A+null&ia=web&iax=qa

https://duckduckgo.com/?t=ffab&q=Unexpected+error+occurred+in+scheduled+task&ia=web

https://www.yawintutor.com/schedule-taskutils-loggingerrorhandler-unexpected-error-occurred-in-scheduled-task/

https://duckduckgo.com/?t=ffab&q=how+to+check+the+java+version+used+by+gradle+during+compile&ia=web

https://stackoverflow.com/questions/18487406/how-do-i-tell-gradle-to-use-specific-jdk-version

https://www.howtobuildsoftware.com/index.php/how-do/bneF/gradle-how-to-check-java-version-when-running-gradle

---

I'm going to ignore this message on the command line and check it out later! :) As long as it runs the
tests in the IDE, I'm good !

---

Spring Integrations

https://docs.spring.io/spring-integration/reference/html/

https://docs.spring.io/spring-integration/reference/html/index-single.html

https://www.enterpriseintegrationpatterns.com/

---

https://duckduckgo.com/?t=ffab&q=sftp+listen+to+events&ia=web

https://www.pilotfishtechnology.com/ftp-sftp-listener-configuration/

https://www.jscape.com/blog/monitoring-a-remote-sftp-server-for-newly-added-files

https://duckduckgo.com/?q=java+listen+to+sftp+file+creation+event&t=ffab&ia=web&iax=qa

https://duckduckgo.com/?q=listen+to+sftp+remote+file+creation&t=ffab&ia=web

https://duckduckgo.com/?t=ffab&q=sftp+remote+directory+events&ia=web

https://www.tecmint.com/sftp-command-examples/

---

https://docs.spring.io/spring-integration/reference/html/index-single.html#sftp-max-fetch

https://docs.spring.io/spring-integration/reference/html/index-single.html#configuring-with-java-configuration-21

https://docs.spring.io/spring-integration/reference/html/index-single.html#configuring-with-the-java-dsl-21

https://docs.spring.io/spring-integration/reference/html/index-single.html#sftp-streaming

https://docs.spring.io/spring-integration/reference/html/index-single.html#sftp-streaming-java-config

https://www.google.com/search?q=spring+sftp+adapter+example&oq=spring

https://www.google.com/search?tbm=vid&q=spring+sftp+adapter+example

https://www.youtube.com/watch?v=MA8lW_wVSuY

https://www.youtube.com/watch?v=j0AG4KrzCgs

---

https://docs.spring.io/spring-integration/reference/html/index-single.html#sftp-server-events

https://duckduckgo.com/?t=ffab&q=apache+mina&ia=web

https://mina.apache.org/

https://mina.apache.org/ftpserver-project/index.html

https://docs.spring.io/spring-integration/reference/html/event.html#appevent-inbound

https://docs.spring.io/spring-integration/reference/html/index-single.html#xml

https://docs.spring.io/spring-integration/reference/html/index-single.html#xml-payload-converter

https://docs.spring.io/spring/docs/current/spring-framework-reference/html/oxm.html

https://www.google.com/search?sxsrf=ALeKk02C_TRAqYYbOzdTIbVrgFyvm8Busg%3A1607179806610&source=hp&ei=Hp7LX_iQI5vd9QP91rGQAQ&q=spring+sftp+integration+example&oq=spring+sftp+&gs_lcp=CgZwc3ktYWIQAxgEMgQIIxAnMgoIABDJAxAUEIcCMgIIADICCAAyAggAMgIIADIHCAAQFBCHAjICCAAyAggAMgIIADoHCAAQyQMQQzoFCAAQkQI6BAgAEEM6BwgAELEDEEM6BQgAELEDOgcILhAUEIcCUJEBWPwRYP4waABwAHgAgAG8AYgBqA2SAQQwLjEymAEAoAEBqgEHZ3dzLXdpeg&sclient=psy-ab

https://dzone.com/articles/spring-integration-sftp-download-using-key-based-a

https://github.com/pajikos/java-examples/tree/master/spring-sftp-download-demo

https://stackoverflow.com/questions/41151569/spring-integration-sftp-example-with-spring-boot

---

https://docs.spring.io/spring-integration/reference/html/index-single.html#xml-unmarshalling-transformer

---

https://www.github.com/spring-projects/spring-integration/tree/master/spring-integration-sftp%2Fsrc%2Ftest%2Fjava%2Forg%2Fspringframework%2Fintegration%2Fsftp%2Finbound%2FSftpStreamingMessageSourceTests.java

https://github.com/spring-projects/spring-integration-samples

https://www.github.com/spring-projects/spring-integration/tree/master/spring-integration-sftp%2Fsrc%2Fmain%2Fjava%2Forg%2Fspringframework%2Fintegration%2Fsftp%2Fdsl%2FSftp.java

https://www.github.com/spring-projects/spring-integration/tree/master/spring-integration-sftp%2Fsrc%2Ftest%2Fjava%2Forg%2Fspringframework%2Fintegration%2Fsftp%2Finbound%2FSftpStreamingMessageSourceTests.java

https://spring.io/blog/2020/03/18/spring-tips-remote-file-system-integrations-ftp-with-spring-integration

---

https://www.baeldung.com/spring-inject-arrays-lists

https://www.baeldung.com/configuration-properties-in-spring-boot

https://stackoverflow.com/q/56435094/4772008

https://stackoverflow.com/a/56435220/4772008

https://stackoverflow.com/q/59649673/4772008

---

https://blog.jooq.org/2015/12/02/a-subtle-autocloseable-contract-change-between-java-7-and-java-8/

https://www.baeldung.com/java-try-with-resources

http://tutorials.jenkov.com/java-exception-handling/try-with-resources.html

---

https://docs.spring.io/spring-integration/reference/html/sftp.html

https://docs.spring.io/spring-integration/api/org/springframework/integration/sftp/session/DefaultSftpSessionFactory.html

https://scanningpages.wordpress.com/2016/12/30/sftp-with-spring-integration/

https://www.baeldung.com/spring-integration

---

https://www.baeldung.com/java-stax

https://www.tutorialspoint.com/java_xml/java_stax_parse_document.htm

https://docs.oracle.com/javase/tutorial/jaxp/stax/index.html

https://docs.oracle.com/cd/E13222_01/wls/docs92/xml/stax.html

https://link.medium.com/xtBLrHrVWbb

https://www.tutorialspoint.com/java_xml/java_xpath_parse_document.htm

https://www.baeldung.com/java-xpath

https://stackoverflow.com/q/7215931/4772008

https://www.codota.com/code/java/classes/javax.xml.xpath.XPath

https://www.tutorialspoint.com/java_xml/java_xpath_parse_document.htm

---

https://duckduckgo.com/?t=ffab&q=sftp+streaming+message+source&ia=web

---

https://duckduckgo.com/?t=ffab&q=spEL+%3A+expected+Expression+provided+String&ia=web

https://www.baeldung.com/spring-expression-language


