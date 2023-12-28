# Getting Started

Run the following command in the root directory, and you should face with the following trace
```
$ ./mvnw native:compile -Pnative
```
```
./mvnw clean -Pnative native:compile -DskipTests=true                                              ─╯

[INFO] Scanning for projects...
[INFO]
[INFO] -------------------< com.korkutkose:couchbase-demo >--------------------
[INFO] Building couchbase-demo 0.0.1-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- clean:3.3.2:clean (default-clean) @ couchbase-demo ---
[INFO] Deleting /Users/mehmetkorkut/development/tav/couchbase-demo/target
[INFO]
[INFO] >>> native:0.9.28:compile (default-cli) > package @ couchbase-demo >>>
[INFO]
[INFO] --- native:0.9.28:add-reachability-metadata (add-reachability-metadata) @ couchbase-demo ---
[INFO] Downloaded GraalVM reachability metadata repository from file:/Users/mehmetkorkut/.m2/repository/org/graalvm/buildtools/graalvm-reachability-metadata/0.9.28/graalvm-reachability-metadata-0.9.28-repository.zip
[INFO] [graalvm reachability metadata repository for ch.qos.logback:logback-classic:1.4.14]: Configuration directory not found. Trying latest version.
[INFO] [graalvm reachability metadata repository for ch.qos.logback:logback-classic:1.4.14]: Configuration directory is ch.qos.logback/logback-classic/1.4.1
[INFO] [graalvm reachability metadata repository for com.fasterxml.jackson.core:jackson-databind:2.15.3]: Configuration directory not found. Trying latest version.
[INFO] [graalvm reachability metadata repository for com.fasterxml.jackson.core:jackson-databind:2.15.3]: Configuration directory is com.fasterxml.jackson.core/jackson-databind/2.15.2
[INFO] [graalvm reachability metadata repository for org.apache.tomcat.embed:tomcat-embed-core:10.1.17]: Configuration directory not found. Trying latest version.
[INFO] [graalvm reachability metadata repository for org.apache.tomcat.embed:tomcat-embed-core:10.1.17]: Configuration directory is org.apache.tomcat.embed/tomcat-embed-core/10.0.20
[INFO] [graalvm reachability metadata repository for org.hdrhistogram:HdrHistogram:2.1.12]: Configuration directory is org.hdrhistogram/HdrHistogram/2.1.12
[INFO]
[INFO] --- resources:3.3.1:resources (default-resources) @ couchbase-demo ---
[INFO] Copying 1 resource from src/main/resources to target/classes
[INFO] Copying 0 resource from src/main/resources to target/classes
[INFO]
[INFO] --- compiler:3.11.0:compile (default-compile) @ couchbase-demo ---
[INFO] Changes detected - recompiling the module! :source
[INFO] Compiling 6 source files with javac [debug release 21] to target/classes
[INFO] Annotation processing is enabled because one or more processors were found
on the class path. A future release of javac may disable annotation processing
unless at least one processor is specified by name (-processor), or a search
path is specified (--processor-path, --processor-module-path), or annotation
processing is enabled explicitly (-proc:only, -proc:full).
Use -Xlint:-options to suppress this message.
Use -proc:none to disable annotation processing.
[INFO]
[INFO] --- resources:3.3.1:testResources (default-testResources) @ couchbase-demo ---
[INFO] skip non existing resourceDirectory /Users/mehmetkorkut/development/tav/couchbase-demo/src/test/resources
[INFO]
[INFO] --- compiler:3.11.0:testCompile (default-testCompile) @ couchbase-demo ---
[INFO] Changes detected - recompiling the module! :dependency
[INFO] Compiling 1 source file with javac [debug release 21] to target/test-classes
[INFO] Annotation processing is enabled because one or more processors were found
on the class path. A future release of javac may disable annotation processing
unless at least one processor is specified by name (-processor), or a search
path is specified (--processor-path, --processor-module-path), or annotation
processing is enabled explicitly (-proc:only, -proc:full).
Use -Xlint:-options to suppress this message.
Use -proc:none to disable annotation processing.
[INFO]
[INFO] --- surefire:3.1.2:test (default-test) @ couchbase-demo ---
[WARNING]  Parameter 'systemProperties' is deprecated: Use systemPropertyVariables instead.
[INFO] Tests are skipped.
[INFO]
[INFO] --- spring-boot:3.2.1:process-aot (process-aot) @ couchbase-demo ---

.   ____          _            __ _ _
/\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
\\/  ___)| |_)| | | | | || (_| |  ) ) ) )
'  |____| .__|_| |_|_| |_\__, | / / / /
=========|_|==============|___/=/_/_/_/
:: Spring Boot ::                (v3.2.1)

2023-12-28T09:03:24.882+03:00  INFO 11204 --- [           main] [                                                 ] c.k.c.CouchbaseDemoApplication           : Starting CouchbaseDemoApplication using Java 21.0.1 with PID 11204 (/Users/mehmetkorkut/development/tav/couchbase-demo/target/classes started by mehmetkorkut in /Users/mehmetkorkut/development/tav/couchbase-demo)
2023-12-28T09:03:24.884+03:00  INFO 11204 --- [           main] [                                                 ] c.k.c.CouchbaseDemoApplication           : No active profile set, falling back to 1 default profile: "default"
2023-12-28T09:03:25.180+03:00  INFO 11204 --- [           main] [                                                 ] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data Couchbase repositories in DEFAULT mode.
2023-12-28T09:03:25.247+03:00  INFO 11204 --- [           main] [                                                 ] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 65 ms. Found 1 Couchbase repository interface.
2023-12-28T09:03:25.438+03:00  INFO 11204 --- [           main] [                                                 ] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data Couchbase repositories in DEFAULT mode.
2023-12-28T09:03:25.447+03:00  INFO 11204 --- [           main] [                                                 ] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 8 ms. Found 0 Couchbase repository interfaces.
Exception in thread "main" java.lang.IllegalStateException: No constructor or factory method candidate found for Root bean: class [org.springframework.data.couchbase.core.mapping.event.AuditingEventListener]; scope=singleton; abstract=false; lazyInit=null; autowireMode=0; dependencyCheck=0; autowireCandidate=true; primary=false; factoryBeanName=null; factoryMethodName=null; initMethodNames=null; destroyMethodNames=null and argument types [org.springframework.beans.factory.ObjectFactory<java.lang.Object>]
at org.springframework.beans.factory.support.ConstructorResolver.resolveConstructorOrFactoryMethod(ConstructorResolver.java:994)
at org.springframework.beans.factory.support.RegisteredBean.resolveConstructorOrFactoryMethod(RegisteredBean.java:212)
at org.springframework.util.function.SingletonSupplier.get(SingletonSupplier.java:106)
at org.springframework.beans.factory.aot.DefaultBeanRegistrationCodeFragments.getTarget(DefaultBeanRegistrationCodeFragments.java:85)
at org.springframework.beans.factory.aot.BeanDefinitionMethodGenerator.generateBeanDefinitionMethod(BeanDefinitionMethodGenerator.java:85)
at org.springframework.beans.factory.aot.BeanRegistrationsAotContribution.lambda$generateRegisterBeanDefinitionsMethod$2(BeanRegistrationsAotContribution.java:90)
at java.base/java.util.LinkedHashMap.forEach(LinkedHashMap.java:986)
at org.springframework.beans.factory.aot.BeanRegistrationsAotContribution.generateRegisterBeanDefinitionsMethod(BeanRegistrationsAotContribution.java:88)
at org.springframework.beans.factory.aot.BeanRegistrationsAotContribution.lambda$applyTo$1(BeanRegistrationsAotContribution.java:73)
at org.springframework.aot.generate.GeneratedMethod.<init>(GeneratedMethod.java:54)
at org.springframework.aot.generate.GeneratedMethods.add(GeneratedMethods.java:112)
at org.springframework.aot.generate.GeneratedMethods.add(GeneratedMethods.java:89)
at org.springframework.beans.factory.aot.BeanRegistrationsAotContribution.applyTo(BeanRegistrationsAotContribution.java:72)
at org.springframework.context.aot.BeanFactoryInitializationAotContributions.applyTo(BeanFactoryInitializationAotContributions.java:78)
at org.springframework.context.aot.ApplicationContextAotGenerator.lambda$processAheadOfTime$0(ApplicationContextAotGenerator.java:58)
at org.springframework.context.aot.ApplicationContextAotGenerator.withCglibClassHandler(ApplicationContextAotGenerator.java:67)
at org.springframework.context.aot.ApplicationContextAotGenerator.processAheadOfTime(ApplicationContextAotGenerator.java:53)
at org.springframework.context.aot.ContextAotProcessor.performAotProcessing(ContextAotProcessor.java:106)
at org.springframework.context.aot.ContextAotProcessor.doProcess(ContextAotProcessor.java:84)
at org.springframework.context.aot.ContextAotProcessor.doProcess(ContextAotProcessor.java:49)
at org.springframework.context.aot.AbstractAotProcessor.process(AbstractAotProcessor.java:82)
at org.springframework.boot.SpringApplicationAotProcessor.main(SpringApplicationAotProcessor.java:80)
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  8.990 s
[INFO] Finished at: 2023-12-28T09:03:31+03:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.springframework.boot:spring-boot-maven-plugin:3.2.1:process-aot (process-aot) on project couchbase-demo: Process terminated with exit code: 1 -> [Help 1]
[ERROR]
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR]
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoExecutionException
```