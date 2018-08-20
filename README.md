# spring-boot-2-javamail
Demo project that involves Spring Boot 2, Spring Integration 5 and JavaMail.


It's purpose is to show a problem with Spring Boot 2.0.4, Spring 5.0.7 and JavaMail 1.6.2-SNAPSHOT in cooperation.

Launch the application with `SMTP_SERVER=<your server> ./gradlew bootRun` (Unix) and you will get such a stack trace:

```

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.0.4.RELEASE)

2018-08-20 10:05:49.099  INFO 11858 --- [           main] .s.SpringBoot2Integration5JavaMailMainKt : Starting SpringBoot2Integration5JavaMailMainKt on loki.fwiesner-vpn.oracle.com with PID 11858 (/Users/fwiesner/01_Development/90_Github/spring-boot-2-javamail/build/classes/kotlin/main started by fwiesner in /Users/fwiesner/01_Development/90_Github/spring-boot-2-javamail)
2018-08-20 10:05:49.106  INFO 11858 --- [           main] .s.SpringBoot2Integration5JavaMailMainKt : No active profile set, falling back to default profiles: default
2018-08-20 10:05:49.210  INFO 11858 --- [           main] onfigReactiveWebServerApplicationContext : Refreshing org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebServerApplicationContext@7ed7259e: startup date [Mon Aug 20 10:05:49 CEST 2018]; root of context hierarchy
2018-08-20 10:05:49.308  WARN 11858 --- [kground-preinit] o.s.h.c.j.Jackson2ObjectMapperBuilder    : For Jackson Kotlin classes support please add "com.fasterxml.jackson.module:jackson-module-kotlin" to the classpath
2018-08-20 10:05:50.477  INFO 11858 --- [           main] o.s.i.config.IntegrationRegistrar        : No bean named 'integrationHeaderChannelRegistry' has been explicitly defined. Therefore, a default DefaultHeaderChannelRegistry will be created.
2018-08-20 10:05:51.058  INFO 11858 --- [           main] faultConfiguringBeanFactoryPostProcessor : No bean named 'errorChannel' has been explicitly defined. Therefore, a default PublishSubscribeChannel will be created.
2018-08-20 10:05:51.072  INFO 11858 --- [           main] faultConfiguringBeanFactoryPostProcessor : No bean named 'taskScheduler' has been explicitly defined. Therefore, a default ThreadPoolTaskScheduler will be created.
2018-08-20 10:05:51.365  INFO 11858 --- [           main] trationDelegate$BeanPostProcessorChecker : Bean 'org.springframework.integration.config.IntegrationManagementConfiguration' of type [org.springframework.integration.config.IntegrationManagementConfiguration$$EnhancerBySpringCGLIB$$43ccfef0] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying)
2018-08-20 10:05:52.331  INFO 11858 --- [           main] o.s.w.r.handler.SimpleUrlHandlerMapping  : Mapped URL path [/webjars/**] onto handler of type [class org.springframework.web.reactive.resource.ResourceWebHandler]
2018-08-20 10:05:52.331  INFO 11858 --- [           main] o.s.w.r.handler.SimpleUrlHandlerMapping  : Mapped URL path [/**] onto handler of type [class org.springframework.web.reactive.resource.ResourceWebHandler]
2018-08-20 10:05:53.527  INFO 11858 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 2 endpoint(s) beneath base path '/actuator'
2018-08-20 10:05:53.575  INFO 11858 --- [           main] .b.a.e.w.r.WebFluxEndpointHandlerMapping : Mapped "{[/actuator/health],methods=[GET],produces=[application/vnd.spring-boot.actuator.v2+json || application/json]}" onto public org.reactivestreams.Publisher<org.springframework.http.ResponseEntity<java.lang.Object>> org.springframework.boot.actuate.endpoint.web.reactive.AbstractWebFluxEndpointHandlerMapping$ReadOperationHandler.handle(org.springframework.web.server.ServerWebExchange)
2018-08-20 10:05:53.578  INFO 11858 --- [           main] .b.a.e.w.r.WebFluxEndpointHandlerMapping : Mapped "{[/actuator/info],methods=[GET],produces=[application/vnd.spring-boot.actuator.v2+json || application/json]}" onto public org.reactivestreams.Publisher<org.springframework.http.ResponseEntity<java.lang.Object>> org.springframework.boot.actuate.endpoint.web.reactive.AbstractWebFluxEndpointHandlerMapping$ReadOperationHandler.handle(org.springframework.web.server.ServerWebExchange)
2018-08-20 10:05:53.580  INFO 11858 --- [           main] .b.a.e.w.r.WebFluxEndpointHandlerMapping : Mapped "{[/actuator],methods=[GET],produces=[application/vnd.spring-boot.actuator.v2+json || application/json]}" onto protected java.util.Map<java.lang.String, java.util.Map<java.lang.String, org.springframework.boot.actuate.endpoint.web.Link>> org.springframework.boot.actuate.endpoint.web.reactive.WebFluxEndpointHandlerMapping.links(org.springframework.web.server.ServerWebExchange)
2018-08-20 10:05:54.120  INFO 11858 --- [           main] o.s.w.r.r.m.a.ControllerMethodResolver   : Looking for @ControllerAdvice: org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebServerApplicationContext@7ed7259e: startup date [Mon Aug 20 10:05:49 CEST 2018]; root of context hierarchy
2018-08-20 10:05:55.846  INFO 11858 --- [           main] o.s.s.c.ThreadPoolTaskScheduler          : Initializing ExecutorService  'taskScheduler'
2018-08-20 10:05:55.971  WARN 11858 --- [           main] javax.mail                               : expected resource not found: /META-INF/javamail.default.address.map
2018-08-20 10:05:55.991  WARN 11858 --- [           main] onfigReactiveWebServerApplicationContext : Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'org.springframework.boot.autoconfigure.mail.MailSenderValidatorAutoConfiguration': Invocation of init method failed; nested exception is java.util.ServiceConfigurationError: javax.mail.Provider: Provider com.sun.mail.smtp.SMTPTransport not a subtype
2018-08-20 10:05:55.992  INFO 11858 --- [           main] o.s.s.c.ThreadPoolTaskScheduler          : Shutting down ExecutorService 'taskScheduler'
2018-08-20 10:05:55.995  INFO 11858 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Unregistering JMX-exposed beans on shutdown
2018-08-20 10:05:56.041  INFO 11858 --- [           main] ConditionEvaluationReportLoggingListener : 

Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled.
2018-08-20 10:05:56.064 ERROR 11858 --- [           main] o.s.boot.SpringApplication               : Application run failed

org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'org.springframework.boot.autoconfigure.mail.MailSenderValidatorAutoConfiguration': Invocation of init method failed; nested exception is java.util.ServiceConfigurationError: javax.mail.Provider: Provider com.sun.mail.smtp.SMTPTransport not a subtype
        at org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor.postProcessBeforeInitialization(InitDestroyAnnotationBeanPostProcessor.java:139) ~[spring-beans-5.0.8.RELEASE.jar:5.0.8.RELEASE]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization(AbstractAutowireCapableBeanFactory.java:416) ~[spring-beans-5.0.8.RELEASE.jar:5.0.8.RELEASE]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1691) ~[spring-beans-5.0.8.RELEASE.jar:5.0.8.RELEASE]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:573) ~[spring-beans-5.0.8.RELEASE.jar:5.0.8.RELEASE]
        at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:495) ~[spring-beans-5.0.8.RELEASE.jar:5.0.8.RELEASE]
        at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:317) ~[spring-beans-5.0.8.RELEASE.jar:5.0.8.RELEASE]
        at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:222) ~[spring-beans-5.0.8.RELEASE.jar:5.0.8.RELEASE]
        at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:315) ~[spring-beans-5.0.8.RELEASE.jar:5.0.8.RELEASE]
        at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:199) ~[spring-beans-5.0.8.RELEASE.jar:5.0.8.RELEASE]
        at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:759) ~[spring-beans-5.0.8.RELEASE.jar:5.0.8.RELEASE]
        at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:869) ~[spring-context-5.0.8.RELEASE.jar:5.0.8.RELEASE]
        at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:550) ~[spring-context-5.0.8.RELEASE.jar:5.0.8.RELEASE]
        at org.springframework.boot.web.reactive.context.ReactiveWebServerApplicationContext.refresh(ReactiveWebServerApplicationContext.java:61) ~[spring-boot-2.0.4.RELEASE.jar:2.0.4.RELEASE]
        at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:762) [spring-boot-2.0.4.RELEASE.jar:2.0.4.RELEASE]
        at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:398) [spring-boot-2.0.4.RELEASE.jar:2.0.4.RELEASE]
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:330) [spring-boot-2.0.4.RELEASE.jar:2.0.4.RELEASE]
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1258) [spring-boot-2.0.4.RELEASE.jar:2.0.4.RELEASE]
        at org.springframework.boot.SpringApplication.run(SpringApplication.java:1246) [spring-boot-2.0.4.RELEASE.jar:2.0.4.RELEASE]
        at info.florian_wiesner.springbootjavamail.SpringBoot2Integration5JavaMailMainKt.main(SpringBoot2Integration5JavaMailMain.kt:17) [main/:na]
Caused by: java.util.ServiceConfigurationError: javax.mail.Provider: Provider com.sun.mail.smtp.SMTPTransport not a subtype
        at java.util.ServiceLoader.fail(ServiceLoader.java:239) ~[na:1.8.0_181]
        at java.util.ServiceLoader.access$300(ServiceLoader.java:185) ~[na:1.8.0_181]
        at java.util.ServiceLoader$LazyIterator.nextService(ServiceLoader.java:376) ~[na:1.8.0_181]
        at java.util.ServiceLoader$LazyIterator.next(ServiceLoader.java:404) ~[na:1.8.0_181]
        at java.util.ServiceLoader$1.next(ServiceLoader.java:480) ~[na:1.8.0_181]
        at javax.mail.Session.getProviderByProtocol(Session.java:1017) ~[mailapi-1.6.2-SNAPSHOT.jar:1.6.2-SNAPSHOT]
        at javax.mail.Session.getProvider(Session.java:542) ~[mailapi-1.6.2-SNAPSHOT.jar:1.6.2-SNAPSHOT]
        at javax.mail.Session.getTransport(Session.java:744) ~[mailapi-1.6.2-SNAPSHOT.jar:1.6.2-SNAPSHOT]
        at javax.mail.Session.getTransport(Session.java:725) ~[mailapi-1.6.2-SNAPSHOT.jar:1.6.2-SNAPSHOT]
        at org.springframework.mail.javamail.JavaMailSenderImpl.getTransport(JavaMailSenderImpl.java:535) ~[spring-context-support-5.0.8.RELEASE.jar:5.0.8.RELEASE]
        at org.springframework.mail.javamail.JavaMailSenderImpl.connectTransport(JavaMailSenderImpl.java:514) ~[spring-context-support-5.0.8.RELEASE.jar:5.0.8.RELEASE]
        at org.springframework.mail.javamail.JavaMailSenderImpl.testConnection(JavaMailSenderImpl.java:396) ~[spring-context-support-5.0.8.RELEASE.jar:5.0.8.RELEASE]
        at org.springframework.boot.autoconfigure.mail.MailSenderValidatorAutoConfiguration.validateConnection(MailSenderValidatorAutoConfiguration.java:52) ~[spring-boot-autoconfigure-2.0.4.RELEASE.jar:2.0.4.RELEASE]
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_181]
        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:1.8.0_181]
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:1.8.0_181]
        at java.lang.reflect.Method.invoke(Method.java:498) ~[na:1.8.0_181]
        at org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor$LifecycleElement.invoke(InitDestroyAnnotationBeanPostProcessor.java:366) ~[spring-beans-5.0.8.RELEASE.jar:5.0.8.RELEASE]
        at org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor$LifecycleMetadata.invokeInitMethods(InitDestroyAnnotationBeanPostProcessor.java:309) ~[spring-beans-5.0.8.RELEASE.jar:5.0.8.RELEASE]
        at org.springframework.beans.factory.annotation.InitDestroyAnnotationBeanPostProcessor.postProcessBeforeInitialization(InitDestroyAnnotationBeanPostProcessor.java:136) ~[spring-beans-5.0.8.RELEASE.jar:5.0.8.RELEASE]
        ... 18 common frames omitted

```
