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


