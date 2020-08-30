# Story

When defining a `application.properites` under
`test/resources` for tests, only those properties
are available to the test code. The properties from
`main/resources` is not used as default - so, there's
NO sort of merging of test properties and main properties
for tests. Gotta see how to - take test properties as
high priority and whenever a value is not present,
look for it in the main properties.

Found this when I defined only this

`src/test/resources/application.properties`
```properties
anotherCustomConfig=anotherTestValue

```

The tests failed with

```shell script
/Library/Java/JavaVirtualMachines/openjdk.jdk/Contents/Home/bin/java -ea -Didea.test.cyclic.buffer.size=1048576 -javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=49695:/Applications/IntelliJ IDEA CE.app/Contents/bin -Dfile.encoding=UTF-8 -classpath /Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar:/Users/karuppiahn/.m2/repository/org/junit/platform/junit-platform-launcher/1.6.2/junit-platform-launcher-1.6.2.jar:/Users/karuppiahn/.m2/repository/org/apiguardian/apiguardian-api/1.1.0/apiguardian-api-1.1.0.jar:/Users/karuppiahn/.m2/repository/org/junit/platform/junit-platform-engine/1.6.2/junit-platform-engine-1.6.2.jar:/Users/karuppiahn/.m2/repository/org/opentest4j/opentest4j/1.2.0/opentest4j-1.2.0.jar:/Users/karuppiahn/.m2/repository/org/junit/platform/junit-platform-commons/1.6.2/junit-platform-commons-1.6.2.jar:/Applications/IntelliJ IDEA CE.app/Contents/plugins/junit/lib/junit5-rt.jar:/Applications/IntelliJ IDEA CE.app/Contents/plugins/junit/lib/junit-rt.jar:/Users/karuppiahn/oss/github.com/karuppiah7890/spring-stuff/playing-with-config/build/classes/java/test:/Users/karuppiahn/oss/github.com/karuppiah7890/spring-stuff/playing-with-config/build/classes/java/main:/Users/karuppiahn/oss/github.com/karuppiah7890/spring-stuff/playing-with-config/build/resources/main:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.springframework.boot/spring-boot-starter-web/2.3.3.RELEASE/d38db3c19ba4bc114aaa4febfc1d89cd8725822d/spring-boot-starter-web-2.3.3.RELEASE.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.springframework.boot/spring-boot-starter-test/2.3.3.RELEASE/8ded50d5716164f0a2b5d4a437b66a23bdc7296/spring-boot-starter-test-2.3.3.RELEASE.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.springframework.boot/spring-boot-starter-json/2.3.3.RELEASE/8c40b22a0635989ecc58f35d82fd55445be8822f/spring-boot-starter-json-2.3.3.RELEASE.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.springframework.boot/spring-boot-starter/2.3.3.RELEASE/c9bb3464e83990465b86fb94da3d20f92f036d1e/spring-boot-starter-2.3.3.RELEASE.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.springframework.boot/spring-boot-starter-tomcat/2.3.3.RELEASE/542a0aaf0f584d186d9bd052ab10a5cf357a5b39/spring-boot-starter-tomcat-2.3.3.RELEASE.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.springframework/spring-webmvc/5.2.8.RELEASE/9cccf8354a7e031e217681db33f14339200dffcf/spring-webmvc-5.2.8.RELEASE.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.springframework/spring-web/5.2.8.RELEASE/4f9542d61fff7beb6050e8028dfb6b7c6844c99a/spring-web-5.2.8.RELEASE.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.springframework.boot/spring-boot-test-autoconfigure/2.3.3.RELEASE/8829f4ac0be7680154629a85a04ed85670de69ae/spring-boot-test-autoconfigure-2.3.3.RELEASE.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.springframework.boot/spring-boot-test/2.3.3.RELEASE/6730265a18695fa16ba049b3490b431e926324a9/spring-boot-test-2.3.3.RELEASE.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/com.jayway.jsonpath/json-path/2.4.0/765a4401ceb2dc8d40553c2075eb80a8fa35c2ae/json-path-2.4.0.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/jakarta.xml.bind/jakarta.xml.bind-api/2.3.3/48e3b9cfc10752fba3521d6511f4165bea951801/jakarta.xml.bind-api-2.3.3.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.assertj/assertj-core/3.16.1/6e772120aff69ca3d1583b3d1b36b7529de43ba1/assertj-core-3.16.1.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.hamcrest/hamcrest/2.2/1820c0968dba3a11a1b30669bb1f01978a91dedc/hamcrest-2.2.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.junit.jupiter/junit-jupiter/5.6.2/b5c481685b6a8ca91c0d46f28f886a444354daa5/junit-jupiter-5.6.2.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.mockito/mockito-junit-jupiter/3.3.3/1176ce43cf773e11a5a318ff04e57e55f9187347/mockito-junit-jupiter-3.3.3.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.mockito/mockito-core/3.3.3/4878395d4e63173f3825e17e5e0690e8054445f1/mockito-core-3.3.3.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.skyscreamer/jsonassert/1.5.0/6c9d5fe2f59da598d9aefc1cfc6528ff3cf32df3/jsonassert-1.5.0.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.springframework/spring-test/5.2.8.RELEASE/cae701620e4d7d6a1d0c2d10b5ca6faf21bce3e5/spring-test-5.2.8.RELEASE.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.springframework/spring-core/5.2.8.RELEASE/35a1654028254abd7cb85799a891de8a0ab9f599/spring-core-5.2.8.RELEASE.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.xmlunit/xmlunit-core/2.7.0/4d014eac96329c70175116b185749765cee0aad5/xmlunit-core-2.7.0.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/com.fasterxml.jackson.datatype/jackson-datatype-jdk8/2.11.2/d4c1933a8d62db65c3d5a5cd809511e021a189c0/jackson-datatype-jdk8-2.11.2.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/com.fasterxml.jackson.datatype/jackson-datatype-jsr310/2.11.2/e6235e5eb3cf3edd2a95cd0dc96bc48aeb309e8a/jackson-datatype-jsr310-2.11.2.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/com.fasterxml.jackson.module/jackson-module-parameter-names/2.11.2/c0dc526fcef5a3aae0273fc516ecf3505f7a5de8/jackson-module-parameter-names-2.11.2.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/com.fasterxml.jackson.core/jackson-databind/2.11.2/ee08bbd8975dde844307fe8309dfcd5ec7ee129d/jackson-databind-2.11.2.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.springframework.boot/spring-boot-autoconfigure/2.3.3.RELEASE/a1343e09cb6024bb4fbf656ce3cd3d13f12ccbdd/spring-boot-autoconfigure-2.3.3.RELEASE.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.springframework.boot/spring-boot/2.3.3.RELEASE/74f0cfae433a6ba6d936c61baa5a5316a688dc22/spring-boot-2.3.3.RELEASE.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.springframework.boot/spring-boot-starter-logging/2.3.3.RELEASE/23523992dd7378fa565b1fc70e19629e8b867ada/spring-boot-starter-logging-2.3.3.RELEASE.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/jakarta.annotation/jakarta.annotation-api/1.3.5/59eb84ee0d616332ff44aba065f3888cf002cd2d/jakarta.annotation-api-1.3.5.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.yaml/snakeyaml/1.26/a78a8747147d2c5807683e76ec2b633e95c14fe9/snakeyaml-1.26.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.apache.tomcat.embed/tomcat-embed-websocket/9.0.37/ee8b7c9081372bf40c41443c93317145a01e343a/tomcat-embed-websocket-9.0.37.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.apache.tomcat.embed/tomcat-embed-core/9.0.37/c3f788de87f17eb57a9e7083736c1820fcbc1046/tomcat-embed-core-9.0.37.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.glassfish/jakarta.el/3.0.3/dab46ee1ee23f7197c13d7c40fce14817c9017df/jakarta.el-3.0.3.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.springframework/spring-context/5.2.8.RELEASE/304d59d6c9fda8bc651fecc8c49748f8259de5ce/spring-context-5.2.8.RELEASE.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.springframework/spring-aop/5.2.8.RELEASE/e0e9b4ed80ecde4bad258aaa3f87bf16eb1feecc/spring-aop-5.2.8.RELEASE.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.springframework/spring-beans/5.2.8.RELEASE/5cfafc2b0f821bda0b537449a6fdf634b0a666ff/spring-beans-5.2.8.RELEASE.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.springframework/spring-expression/5.2.8.RELEASE/1b3b5c84e83b450357ae84135e1b47d1b4e5a217/spring-expression-5.2.8.RELEASE.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/net.minidev/json-smart/2.3/7396407491352ce4fa30de92efb158adb76b5b/json-smart-2.3.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.slf4j/slf4j-api/1.7.30/b5a4b6d16ab13e34a88fae84c35cd5d68cac922c/slf4j-api-1.7.30.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/jakarta.activation/jakarta.activation-api/1.2.2/99f53adba383cb1bf7c3862844488574b559621f/jakarta.activation-api-1.2.2.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.junit.jupiter/junit-jupiter-params/5.6.2/f2a64a42cf73077062c2386db0598062b7480d91/junit-jupiter-params-5.6.2.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.junit.jupiter/junit-jupiter-api/5.6.2/c9ba885abfe975cda123bf6f8f0a69a1b46956d0/junit-jupiter-api-5.6.2.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/net.bytebuddy/byte-buddy/1.10.14/5288bd154aa7bc8ea81a658f60a790f646025832/byte-buddy-1.10.14.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/net.bytebuddy/byte-buddy-agent/1.10.14/627b576d22189363c49eb59859664490ae230b38/byte-buddy-agent-1.10.14.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.objenesis/objenesis/2.6/639033469776fd37c08358c6b92a4761feb2af4b/objenesis-2.6.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/com.vaadin.external.google/android-json/0.0.20131108.vaadin1/fa26d351fe62a6a17f5cda1287c1c6110dec413f/android-json-0.0.20131108.vaadin1.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.springframework/spring-jcl/5.2.8.RELEASE/e18b8dea088cc58fad8fc25ee93f22987dd05d94/spring-jcl-5.2.8.RELEASE.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/com.fasterxml.jackson.core/jackson-core/2.11.2/bc022ab0f0c83c07f9c52c5ab9a6a4932b15cc35/jackson-core-2.11.2.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/com.fasterxml.jackson.core/jackson-annotations/2.11.2/e0a7f61fce3e3eac38a079c11831868269de2ea/jackson-annotations-2.11.2.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/ch.qos.logback/logback-classic/1.2.3/7c4f3c474fb2c041d8028740440937705ebb473a/logback-classic-1.2.3.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.apache.logging.log4j/log4j-to-slf4j/2.13.3/966f6fd1af4959d6b12bfa880121d4a2b164f857/log4j-to-slf4j-2.13.3.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.slf4j/jul-to-slf4j/1.7.30/d58bebff8cbf70ff52b59208586095f467656c30/jul-to-slf4j-1.7.30.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/net.minidev/accessors-smart/1.2/c592b500269bfde36096641b01238a8350f8aa31/accessors-smart-1.2.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.apiguardian/apiguardian-api/1.1.0/fc9dff4bb36d627bdc553de77e1f17efd790876c/apiguardian-api-1.1.0.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.junit.platform/junit-platform-commons/1.6.2/7644a14b329e76b5fe487628b50fb5eab6ba7d26/junit-platform-commons-1.6.2.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.opentest4j/opentest4j/1.2.0/28c11eb91f9b6d8e200631d46e20a7f407f2a046/opentest4j-1.2.0.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/ch.qos.logback/logback-core/1.2.3/864344400c3d4d92dfeb0a305dc87d953677c03c/logback-core-1.2.3.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.apache.logging.log4j/log4j-api/2.13.3/ec1508160b93d274b1add34419b897bae84c6ca9/log4j-api-2.13.3.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.ow2.asm/asm/5.0.4/da08b8cce7bbf903602a25a3a163ae252435795/asm-5.0.4.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.junit.jupiter/junit-jupiter-engine/5.6.2/c0833bd6de29dd77f8d071025b97b8b434308cd3/junit-jupiter-engine-5.6.2.jar:/Users/karuppiahn/.gradle/caches/modules-2/files-2.1/org.junit.platform/junit-platform-engine/1.6.2/1752cad2579e20c2b224602fe846fc660fb35805/junit-platform-engine-1.6.2.jar com.intellij.rt.junit.JUnitStarter -ideVersion5 -junit5 com.example.playingwithconfig.DemoApplicationTests,contextLoads
08:43:11.921 [main] DEBUG org.springframework.test.context.BootstrapUtils - Instantiating CacheAwareContextLoaderDelegate from class [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
08:43:11.931 [main] DEBUG org.springframework.test.context.BootstrapUtils - Instantiating BootstrapContext using constructor [public org.springframework.test.context.support.DefaultBootstrapContext(java.lang.Class,org.springframework.test.context.CacheAwareContextLoaderDelegate)]
08:43:11.959 [main] DEBUG org.springframework.test.context.BootstrapUtils - Instantiating TestContextBootstrapper for test class [com.example.playingwithconfig.DemoApplicationTests] from class [org.springframework.boot.test.context.SpringBootTestContextBootstrapper]
08:43:11.973 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Neither @ContextConfiguration nor @ContextHierarchy found for test class [com.example.playingwithconfig.DemoApplicationTests], using SpringBootContextLoader
08:43:11.976 [main] DEBUG org.springframework.test.context.support.AbstractContextLoader - Did not detect default resource location for test class [com.example.playingwithconfig.DemoApplicationTests]: class path resource [com/example/playingwithconfig/DemoApplicationTests-context.xml] does not exist
08:43:11.977 [main] DEBUG org.springframework.test.context.support.AbstractContextLoader - Did not detect default resource location for test class [com.example.playingwithconfig.DemoApplicationTests]: class path resource [com/example/playingwithconfig/DemoApplicationTestsContext.groovy] does not exist
08:43:11.977 [main] INFO org.springframework.test.context.support.AbstractContextLoader - Could not detect default resource locations for test class [com.example.playingwithconfig.DemoApplicationTests]: no resource found for suffixes {-context.xml, Context.groovy}.
08:43:11.978 [main] INFO org.springframework.test.context.support.AnnotationConfigContextLoaderUtils - Could not detect default configuration classes for test class [com.example.playingwithconfig.DemoApplicationTests]: DemoApplicationTests does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
08:43:12.020 [main] DEBUG org.springframework.test.context.support.ActiveProfilesUtils - Could not find an 'annotation declaring class' for annotation type [org.springframework.test.context.ActiveProfiles] and class [com.example.playingwithconfig.DemoApplicationTests]
08:43:12.096 [main] DEBUG org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider - Identified candidate component class: file [/Users/karuppiahn/oss/github.com/karuppiah7890/spring-stuff/playing-with-config/build/classes/java/main/com/example/playingwithconfig/DemoApplication.class]
08:43:12.097 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Found @SpringBootConfiguration com.example.playingwithconfig.DemoApplication for test class com.example.playingwithconfig.DemoApplicationTests
08:43:12.208 [main] DEBUG org.springframework.boot.test.context.SpringBootTestContextBootstrapper - @TestExecutionListeners is not present for class [com.example.playingwithconfig.DemoApplicationTests]: using defaults.
08:43:12.209 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Loaded default TestExecutionListener class names from location [META-INF/spring.factories]: [org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecutionListener, org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerResetTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener, org.springframework.boot.test.autoconfigure.webservices.client.MockWebServiceServerTestExecutionListener, org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener, org.springframework.test.context.web.ServletTestExecutionListener, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener, org.springframework.test.context.support.DependencyInjectionTestExecutionListener, org.springframework.test.context.support.DirtiesContextTestExecutionListener, org.springframework.test.context.transaction.TransactionalTestExecutionListener, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener, org.springframework.test.context.event.EventPublishingTestExecutionListener]
08:43:12.224 [main] DEBUG org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Skipping candidate TestExecutionListener [org.springframework.test.context.transaction.TransactionalTestExecutionListener] due to a missing dependency. Specify custom listener classes or make the default listener classes and their required dependencies available. Offending class: [org/springframework/transaction/interceptor/TransactionAttributeSource]
08:43:12.227 [main] DEBUG org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Skipping candidate TestExecutionListener [org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener] due to a missing dependency. Specify custom listener classes or make the default listener classes and their required dependencies available. Offending class: [org/springframework/transaction/interceptor/TransactionAttribute]
08:43:12.227 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Using TestExecutionListeners: [org.springframework.test.context.web.ServletTestExecutionListener@4ee203eb, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener@1a5a4e19, org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener@7068e664, org.springframework.boot.test.autoconfigure.SpringBootDependencyInjectionTestExecutionListener@60db1c0e, org.springframework.test.context.support.DirtiesContextTestExecutionListener@3e78b6a5, org.springframework.test.context.event.EventPublishingTestExecutionListener@769a1df5, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecutionListener@41f69e84, org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerResetTestExecutionListener@7975d1d8, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener@2438dcd, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener@24105dc5, org.springframework.boot.test.autoconfigure.webservices.client.MockWebServiceServerTestExecutionListener@5167f57d, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener@64b0598]
08:43:12.232 [main] DEBUG org.springframework.test.context.support.AbstractDirtiesContextTestExecutionListener - Before test class: context [DefaultTestContext@68746f22 testClass = DemoApplicationTests, testInstance = [null], testMethod = [null], testException = [null], mergedContextConfiguration = [WebMergedContextConfiguration@2f01783a testClass = DemoApplicationTests, locations = '{}', classes = '{class com.example.playingwithconfig.DemoApplication}', contextInitializerClasses = '[]', activeProfiles = '{}', propertySourceLocations = '{}', propertySourceProperties = '{org.springframework.boot.test.context.SpringBootTestContextBootstrapper=true}', contextCustomizers = set[org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizerFactory$Customizer@59474f18, org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@33d512c1, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@5fe94a96, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@0, org.springframework.boot.test.web.client.TestRestTemplateContextCustomizer@3c46e67a, org.springframework.boot.test.context.SpringBootTestArgs@1], resourceBasePath = 'src/main/webapp', contextLoader = 'org.springframework.boot.test.context.SpringBootContextLoader', parent = [null]], attributes = map['org.springframework.test.context.web.ServletTestExecutionListener.activateListener' -> true]], class annotated with @DirtiesContext [false] with mode [null].
08:43:12.273 [main] DEBUG org.springframework.test.context.support.TestPropertySourceUtils - Adding inlined properties to environment: {spring.jmx.enabled=false, org.springframework.boot.test.context.SpringBootTestContextBootstrapper=true}

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.3.3.RELEASE)

2020-08-30 08:43:12.710  INFO 37720 --- [           main] c.e.p.DemoApplicationTests               : Starting DemoApplicationTests on Karuppiah-N.local with PID 37720 (started by karuppiahn in /Users/karuppiahn/oss/github.com/karuppiah7890/spring-stuff/playing-with-config)
2020-08-30 08:43:12.711  INFO 37720 --- [           main] c.e.p.DemoApplicationTests               : No active profile set, falling back to default profiles: default
2020-08-30 08:43:13.373  WARN 37720 --- [           main] o.s.w.c.s.GenericWebApplicationContext   : Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'demoApplication': Injection of autowired dependencies failed; nested exception is java.lang.IllegalArgumentException: Could not resolve placeholder 'customConfig' in value "${customConfig}"
2020-08-30 08:43:13.381  INFO 37720 --- [           main] ConditionEvaluationReportLoggingListener : 

Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled.
2020-08-30 08:43:13.387 ERROR 37720 --- [           main] o.s.boot.SpringApplication               : Application run failed

org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'demoApplication': Injection of autowired dependencies failed; nested exception is java.lang.IllegalArgumentException: Could not resolve placeholder 'customConfig' in value "${customConfig}"
	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.postProcessProperties(AutowiredAnnotationBeanPostProcessor.java:405) ~[spring-beans-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1420) ~[spring-beans-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:593) ~[spring-beans-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:516) ~[spring-beans-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:324) ~[spring-beans-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:226) ~[spring-beans-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:322) ~[spring-beans-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202) ~[spring-beans-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:897) ~[spring-beans-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:879) ~[spring-context-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:551) ~[spring-context-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:758) ~[spring-boot-2.3.3.RELEASE.jar:2.3.3.RELEASE]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:750) ~[spring-boot-2.3.3.RELEASE.jar:2.3.3.RELEASE]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:397) ~[spring-boot-2.3.3.RELEASE.jar:2.3.3.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:315) ~[spring-boot-2.3.3.RELEASE.jar:2.3.3.RELEASE]
	at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:120) ~[spring-boot-test-2.3.3.RELEASE.jar:2.3.3.RELEASE]
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99) ~[spring-test-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124) ~[spring-test-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:123) ~[spring-test-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.test.context.web.ServletTestExecutionListener.setUpRequestContextIfNecessary(ServletTestExecutionListener.java:190) ~[spring-test-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.test.context.web.ServletTestExecutionListener.prepareTestInstance(ServletTestExecutionListener.java:132) ~[spring-test-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.test.context.TestContextManager.prepareTestInstance(TestContextManager.java:244) ~[spring-test-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.test.context.junit.jupiter.SpringExtension.postProcessTestInstance(SpringExtension.java:98) ~[spring-test-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$invokeTestInstancePostProcessors$5(ClassBasedTestDescriptor.java:341) ~[junit-jupiter-engine-5.6.2.jar:5.6.2]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.executeAndMaskThrowable(ClassBasedTestDescriptor.java:346) ~[junit-jupiter-engine-5.6.2.jar:5.6.2]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$invokeTestInstancePostProcessors$6(ClassBasedTestDescriptor.java:341) ~[junit-jupiter-engine-5.6.2.jar:5.6.2]
	at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195) ~[na:na]
	at java.base/java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:177) ~[na:na]
	at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1624) ~[na:na]
	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484) ~[na:na]
	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474) ~[na:na]
	at java.base/java.util.stream.StreamSpliterators$WrappingSpliterator.forEachRemaining(StreamSpliterators.java:312) ~[na:na]
	at java.base/java.util.stream.Streams$ConcatSpliterator.forEachRemaining(Streams.java:735) ~[na:na]
	at java.base/java.util.stream.Streams$ConcatSpliterator.forEachRemaining(Streams.java:734) ~[na:na]
	at java.base/java.util.stream.ReferencePipeline$Head.forEach(ReferencePipeline.java:658) ~[na:na]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.invokeTestInstancePostProcessors(ClassBasedTestDescriptor.java:340) ~[junit-jupiter-engine-5.6.2.jar:5.6.2]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.instantiateAndPostProcessTestInstance(ClassBasedTestDescriptor.java:263) ~[junit-jupiter-engine-5.6.2.jar:5.6.2]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$testInstancesProvider$2(ClassBasedTestDescriptor.java:256) ~[junit-jupiter-engine-5.6.2.jar:5.6.2]
	at java.base/java.util.Optional.orElseGet(Optional.java:362) ~[na:na]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$testInstancesProvider$3(ClassBasedTestDescriptor.java:255) ~[junit-jupiter-engine-5.6.2.jar:5.6.2]
	at org.junit.jupiter.engine.execution.TestInstancesProvider.getTestInstances(TestInstancesProvider.java:29) ~[junit-jupiter-engine-5.6.2.jar:5.6.2]
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.lambda$prepare$0(TestMethodTestDescriptor.java:108) ~[junit-jupiter-engine-5.6.2.jar:5.6.2]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.prepare(TestMethodTestDescriptor.java:107) ~[junit-jupiter-engine-5.6.2.jar:5.6.2]
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.prepare(TestMethodTestDescriptor.java:71) ~[junit-jupiter-engine-5.6.2.jar:5.6.2]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$prepare$1(NodeTestTask.java:107) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.prepare(NodeTestTask.java:107) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:75) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1510) ~[na:na]
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:38) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:139) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$7(NodeTestTask.java:125) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:135) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:123) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:122) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:80) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1510) ~[na:na]
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:38) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:139) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$7(NodeTestTask.java:125) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:135) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:123) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:122) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:80) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.submit(SameThreadHierarchicalTestExecutorService.java:32) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutor.execute(HierarchicalTestExecutor.java:57) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestEngine.execute(HierarchicalTestEngine.java:51) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:248) ~[junit-platform-launcher-1.6.2.jar:1.6.2]
	at org.junit.platform.launcher.core.DefaultLauncher.lambda$execute$5(DefaultLauncher.java:211) ~[junit-platform-launcher-1.6.2.jar:1.6.2]
	at org.junit.platform.launcher.core.DefaultLauncher.withInterceptedStreams(DefaultLauncher.java:226) ~[junit-platform-launcher-1.6.2.jar:1.6.2]
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:199) ~[junit-platform-launcher-1.6.2.jar:1.6.2]
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:132) ~[junit-platform-launcher-1.6.2.jar:1.6.2]
	at com.intellij.junit5.JUnit5IdeaTestRunner.startRunnerWithArgs(JUnit5IdeaTestRunner.java:71) ~[junit5-rt.jar:na]
	at com.intellij.rt.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:33) ~[junit-rt.jar:na]
	at com.intellij.rt.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:220) ~[junit-rt.jar:na]
	at com.intellij.rt.junit.JUnitStarter.main(JUnitStarter.java:53) ~[junit-rt.jar:na]
Caused by: java.lang.IllegalArgumentException: Could not resolve placeholder 'customConfig' in value "${customConfig}"
	at org.springframework.util.PropertyPlaceholderHelper.parseStringValue(PropertyPlaceholderHelper.java:178) ~[spring-core-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.util.PropertyPlaceholderHelper.replacePlaceholders(PropertyPlaceholderHelper.java:124) ~[spring-core-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.core.env.AbstractPropertyResolver.doResolvePlaceholders(AbstractPropertyResolver.java:239) ~[spring-core-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.core.env.AbstractPropertyResolver.resolveRequiredPlaceholders(AbstractPropertyResolver.java:210) ~[spring-core-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.context.support.PropertySourcesPlaceholderConfigurer.lambda$processProperties$0(PropertySourcesPlaceholderConfigurer.java:175) ~[spring-context-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.resolveEmbeddedValue(AbstractBeanFactory.java:918) ~[spring-beans-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1248) ~[spring-beans-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1227) ~[spring-beans-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredFieldElement.inject(AutowiredAnnotationBeanPostProcessor.java:640) ~[spring-beans-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.beans.factory.annotation.InjectionMetadata.inject(InjectionMetadata.java:130) ~[spring-beans-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.postProcessProperties(AutowiredAnnotationBeanPostProcessor.java:399) ~[spring-beans-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	... 80 common frames omitted

2020-08-30 08:43:13.389 ERROR 37720 --- [           main] o.s.test.context.TestContextManager      : Caught exception while allowing TestExecutionListener [org.springframework.test.context.web.ServletTestExecutionListener@4ee203eb] to prepare test instance [com.example.playingwithconfig.DemoApplicationTests@12db3386]

java.lang.IllegalStateException: Failed to load ApplicationContext
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:132) ~[spring-test-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:123) ~[spring-test-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.test.context.web.ServletTestExecutionListener.setUpRequestContextIfNecessary(ServletTestExecutionListener.java:190) ~[spring-test-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.test.context.web.ServletTestExecutionListener.prepareTestInstance(ServletTestExecutionListener.java:132) ~[spring-test-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.test.context.TestContextManager.prepareTestInstance(TestContextManager.java:244) ~[spring-test-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.test.context.junit.jupiter.SpringExtension.postProcessTestInstance(SpringExtension.java:98) ~[spring-test-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$invokeTestInstancePostProcessors$5(ClassBasedTestDescriptor.java:341) ~[junit-jupiter-engine-5.6.2.jar:5.6.2]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.executeAndMaskThrowable(ClassBasedTestDescriptor.java:346) ~[junit-jupiter-engine-5.6.2.jar:5.6.2]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$invokeTestInstancePostProcessors$6(ClassBasedTestDescriptor.java:341) ~[junit-jupiter-engine-5.6.2.jar:5.6.2]
	at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195) ~[na:na]
	at java.base/java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:177) ~[na:na]
	at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1624) ~[na:na]
	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484) ~[na:na]
	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474) ~[na:na]
	at java.base/java.util.stream.StreamSpliterators$WrappingSpliterator.forEachRemaining(StreamSpliterators.java:312) ~[na:na]
	at java.base/java.util.stream.Streams$ConcatSpliterator.forEachRemaining(Streams.java:735) ~[na:na]
	at java.base/java.util.stream.Streams$ConcatSpliterator.forEachRemaining(Streams.java:734) ~[na:na]
	at java.base/java.util.stream.ReferencePipeline$Head.forEach(ReferencePipeline.java:658) ~[na:na]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.invokeTestInstancePostProcessors(ClassBasedTestDescriptor.java:340) ~[junit-jupiter-engine-5.6.2.jar:5.6.2]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.instantiateAndPostProcessTestInstance(ClassBasedTestDescriptor.java:263) ~[junit-jupiter-engine-5.6.2.jar:5.6.2]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$testInstancesProvider$2(ClassBasedTestDescriptor.java:256) ~[junit-jupiter-engine-5.6.2.jar:5.6.2]
	at java.base/java.util.Optional.orElseGet(Optional.java:362) ~[na:na]
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$testInstancesProvider$3(ClassBasedTestDescriptor.java:255) ~[junit-jupiter-engine-5.6.2.jar:5.6.2]
	at org.junit.jupiter.engine.execution.TestInstancesProvider.getTestInstances(TestInstancesProvider.java:29) ~[junit-jupiter-engine-5.6.2.jar:5.6.2]
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.lambda$prepare$0(TestMethodTestDescriptor.java:108) ~[junit-jupiter-engine-5.6.2.jar:5.6.2]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.prepare(TestMethodTestDescriptor.java:107) ~[junit-jupiter-engine-5.6.2.jar:5.6.2]
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.prepare(TestMethodTestDescriptor.java:71) ~[junit-jupiter-engine-5.6.2.jar:5.6.2]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$prepare$1(NodeTestTask.java:107) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.prepare(NodeTestTask.java:107) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:75) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1510) ~[na:na]
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:38) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:139) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$7(NodeTestTask.java:125) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:135) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:123) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:122) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:80) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1510) ~[na:na]
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:38) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:139) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$7(NodeTestTask.java:125) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:135) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:123) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:122) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:80) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.submit(SameThreadHierarchicalTestExecutorService.java:32) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutor.execute(HierarchicalTestExecutor.java:57) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestEngine.execute(HierarchicalTestEngine.java:51) ~[junit-platform-engine-1.6.2.jar:1.6.2]
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:248) ~[junit-platform-launcher-1.6.2.jar:1.6.2]
	at org.junit.platform.launcher.core.DefaultLauncher.lambda$execute$5(DefaultLauncher.java:211) ~[junit-platform-launcher-1.6.2.jar:1.6.2]
	at org.junit.platform.launcher.core.DefaultLauncher.withInterceptedStreams(DefaultLauncher.java:226) ~[junit-platform-launcher-1.6.2.jar:1.6.2]
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:199) ~[junit-platform-launcher-1.6.2.jar:1.6.2]
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:132) ~[junit-platform-launcher-1.6.2.jar:1.6.2]
	at com.intellij.junit5.JUnit5IdeaTestRunner.startRunnerWithArgs(JUnit5IdeaTestRunner.java:71) ~[junit5-rt.jar:na]
	at com.intellij.rt.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:33) ~[junit-rt.jar:na]
	at com.intellij.rt.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:220) ~[junit-rt.jar:na]
	at com.intellij.rt.junit.JUnitStarter.main(JUnitStarter.java:53) ~[junit-rt.jar:na]
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'demoApplication': Injection of autowired dependencies failed; nested exception is java.lang.IllegalArgumentException: Could not resolve placeholder 'customConfig' in value "${customConfig}"
	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.postProcessProperties(AutowiredAnnotationBeanPostProcessor.java:405) ~[spring-beans-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1420) ~[spring-beans-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:593) ~[spring-beans-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:516) ~[spring-beans-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:324) ~[spring-beans-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:226) ~[spring-beans-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:322) ~[spring-beans-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202) ~[spring-beans-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:897) ~[spring-beans-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:879) ~[spring-context-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:551) ~[spring-context-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:758) ~[spring-boot-2.3.3.RELEASE.jar:2.3.3.RELEASE]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:750) ~[spring-boot-2.3.3.RELEASE.jar:2.3.3.RELEASE]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:397) ~[spring-boot-2.3.3.RELEASE.jar:2.3.3.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:315) ~[spring-boot-2.3.3.RELEASE.jar:2.3.3.RELEASE]
	at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:120) ~[spring-boot-test-2.3.3.RELEASE.jar:2.3.3.RELEASE]
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99) ~[spring-test-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124) ~[spring-test-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	... 63 common frames omitted
Caused by: java.lang.IllegalArgumentException: Could not resolve placeholder 'customConfig' in value "${customConfig}"
	at org.springframework.util.PropertyPlaceholderHelper.parseStringValue(PropertyPlaceholderHelper.java:178) ~[spring-core-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.util.PropertyPlaceholderHelper.replacePlaceholders(PropertyPlaceholderHelper.java:124) ~[spring-core-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.core.env.AbstractPropertyResolver.doResolvePlaceholders(AbstractPropertyResolver.java:239) ~[spring-core-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.core.env.AbstractPropertyResolver.resolveRequiredPlaceholders(AbstractPropertyResolver.java:210) ~[spring-core-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.context.support.PropertySourcesPlaceholderConfigurer.lambda$processProperties$0(PropertySourcesPlaceholderConfigurer.java:175) ~[spring-context-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.beans.factory.support.AbstractBeanFactory.resolveEmbeddedValue(AbstractBeanFactory.java:918) ~[spring-beans-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1248) ~[spring-beans-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1227) ~[spring-beans-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredFieldElement.inject(AutowiredAnnotationBeanPostProcessor.java:640) ~[spring-beans-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.beans.factory.annotation.InjectionMetadata.inject(InjectionMetadata.java:130) ~[spring-beans-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.postProcessProperties(AutowiredAnnotationBeanPostProcessor.java:399) ~[spring-beans-5.2.8.RELEASE.jar:5.2.8.RELEASE]
	... 80 common frames omitted




java.lang.IllegalStateException: Failed to load ApplicationContext

	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:132)
	at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:123)
	at org.springframework.test.context.web.ServletTestExecutionListener.setUpRequestContextIfNecessary(ServletTestExecutionListener.java:190)
	at org.springframework.test.context.web.ServletTestExecutionListener.prepareTestInstance(ServletTestExecutionListener.java:132)
	at org.springframework.test.context.TestContextManager.prepareTestInstance(TestContextManager.java:244)
	at org.springframework.test.context.junit.jupiter.SpringExtension.postProcessTestInstance(SpringExtension.java:98)
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$invokeTestInstancePostProcessors$5(ClassBasedTestDescriptor.java:341)
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.executeAndMaskThrowable(ClassBasedTestDescriptor.java:346)
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$invokeTestInstancePostProcessors$6(ClassBasedTestDescriptor.java:341)
	at java.base/java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:195)
	at java.base/java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:177)
	at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1624)
	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
	at java.base/java.util.stream.StreamSpliterators$WrappingSpliterator.forEachRemaining(StreamSpliterators.java:312)
	at java.base/java.util.stream.Streams$ConcatSpliterator.forEachRemaining(Streams.java:735)
	at java.base/java.util.stream.Streams$ConcatSpliterator.forEachRemaining(Streams.java:734)
	at java.base/java.util.stream.ReferencePipeline$Head.forEach(ReferencePipeline.java:658)
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.invokeTestInstancePostProcessors(ClassBasedTestDescriptor.java:340)
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.instantiateAndPostProcessTestInstance(ClassBasedTestDescriptor.java:263)
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$testInstancesProvider$2(ClassBasedTestDescriptor.java:256)
	at java.base/java.util.Optional.orElseGet(Optional.java:362)
	at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$testInstancesProvider$3(ClassBasedTestDescriptor.java:255)
	at org.junit.jupiter.engine.execution.TestInstancesProvider.getTestInstances(TestInstancesProvider.java:29)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.lambda$prepare$0(TestMethodTestDescriptor.java:108)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.prepare(TestMethodTestDescriptor.java:107)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.prepare(TestMethodTestDescriptor.java:71)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$prepare$1(NodeTestTask.java:107)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.prepare(NodeTestTask.java:107)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:75)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1510)
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:38)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:139)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$7(NodeTestTask.java:125)
	at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:135)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:123)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:122)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:80)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1510)
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:38)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:139)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$7(NodeTestTask.java:125)
	at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:135)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:123)
	at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:122)
	at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:80)
	at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.submit(SameThreadHierarchicalTestExecutorService.java:32)
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutor.execute(HierarchicalTestExecutor.java:57)
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestEngine.execute(HierarchicalTestEngine.java:51)
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:248)
	at org.junit.platform.launcher.core.DefaultLauncher.lambda$execute$5(DefaultLauncher.java:211)
	at org.junit.platform.launcher.core.DefaultLauncher.withInterceptedStreams(DefaultLauncher.java:226)
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:199)
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:132)
	at com.intellij.junit5.JUnit5IdeaTestRunner.startRunnerWithArgs(JUnit5IdeaTestRunner.java:71)
	at com.intellij.rt.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:33)
	at com.intellij.rt.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:220)
	at com.intellij.rt.junit.JUnitStarter.main(JUnitStarter.java:53)
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'demoApplication': Injection of autowired dependencies failed; nested exception is java.lang.IllegalArgumentException: Could not resolve placeholder 'customConfig' in value "${customConfig}"
	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.postProcessProperties(AutowiredAnnotationBeanPostProcessor.java:405)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1420)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:593)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:516)
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:324)
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:226)
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:322)
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:202)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:897)
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:879)
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:551)
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:758)
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:750)
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:397)
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:315)
	at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:120)
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
	... 63 more
Caused by: java.lang.IllegalArgumentException: Could not resolve placeholder 'customConfig' in value "${customConfig}"
	at org.springframework.util.PropertyPlaceholderHelper.parseStringValue(PropertyPlaceholderHelper.java:178)
	at org.springframework.util.PropertyPlaceholderHelper.replacePlaceholders(PropertyPlaceholderHelper.java:124)
	at org.springframework.core.env.AbstractPropertyResolver.doResolvePlaceholders(AbstractPropertyResolver.java:239)
	at org.springframework.core.env.AbstractPropertyResolver.resolveRequiredPlaceholders(AbstractPropertyResolver.java:210)
	at org.springframework.context.support.PropertySourcesPlaceholderConfigurer.lambda$processProperties$0(PropertySourcesPlaceholderConfigurer.java:175)
	at org.springframework.beans.factory.support.AbstractBeanFactory.resolveEmbeddedValue(AbstractBeanFactory.java:918)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1248)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1227)
	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredFieldElement.inject(AutowiredAnnotationBeanPostProcessor.java:640)
	at org.springframework.beans.factory.annotation.InjectionMetadata.inject(InjectionMetadata.java:130)
	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.postProcessProperties(AutowiredAnnotationBeanPostProcessor.java:399)
	... 80 more



Process finished with exit code 255
```

The line gives the error
```shell script
2020-08-30 08:43:13.373  WARN 37720 --- [           main] o.s.w.c.s.GenericWebApplicationContext   : Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'demoApplication': Injection of autowired dependencies failed; nested exception is java.lang.IllegalArgumentException: Could not resolve placeholder 'customConfig' in value "${customConfig}"
```

---

I have fixed the tests with proper assertions based
on test properties file values
