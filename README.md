# Getting Started

Run the following command in the root directory for building the image
```
$ docker build -t couchbase-demo:1.0.0 .
```
Wait until for successful build indication, this might take time. 
Do not forget to increase your Docker Engine's resources for a faster build.
```
$ docker build -t couchbase-demo:1.0.0 .                                                                                                                                                  ─╯
[+] Building 521.4s (16/16) FINISHED                                                                                                                                     docker:desktop-linux
 => [internal] load build definition from Dockerfile                                                                                                                                     0.0s
 => => transferring dockerfile: 733B                                                                                                                                                     0.0s
 => [internal] load .dockerignore                                                                                                                                                        0.0s
 => => transferring context: 2B                                                                                                                                                          0.0s
 => [internal] load metadata for docker.io/library/debian:bookworm-slim                                                                                                                  0.8s
 => [internal] load metadata for container-registry.oracle.com/graalvm/native-image:21                                                                                                   3.4s
 => [build 1/7] FROM container-registry.oracle.com/graalvm/native-image:21@sha256:efcb769abc67505ebf5627c66eeb518088b8182c0c18ad1dfb662912f586b18c                                       0.0s
 => [internal] load build context                                                                                                                                                        0.1s
 => => transferring context: 24.91kB                                                                                                                                                     0.1s
 => [stage-1 1/3] FROM docker.io/library/debian:bookworm-slim@sha256:f80c45482c8d147da87613cb6878a7238b8642bcc24fc11bad78c7bec726f340                                                    0.0s
 => CACHED [stage-1 2/3] WORKDIR /app                                                                                                                                                    0.0s
 => CACHED [build 2/7] RUN microdnf update -y && microdnf install -y maven gcc glibc-devel zlib-devel libstdc++-devel gcc-c++ && microdnf clean all                                      0.0s
 => CACHED [build 3/7] WORKDIR /usr/src/app                                                                                                                                              0.0s
 => CACHED [build 4/7] COPY pom.xml .                                                                                                                                                    0.0s
 => [build 5/7] RUN mvn dependency:go-offline                                                                                                                                          110.9s
 => [build 6/7] COPY . .                                                                                                                                                                 0.0s
 => [build 7/7] RUN mvn clean package -Pnative native:compile                                                                                                                          406.2s
 => [stage-1 3/3] COPY --from=build /usr/src/app/target/couchbase-demo /app/couchbase-demo                                                                                               0.3s
 => exporting to image                                                                                                                                                                   0.2s
 => => exporting layers                                                                                                                                                                  0.2s
 => => writing image sha256:53dcdd82b3f1d55d9d89cf7fb7ca04d7e68353874072337cf09b144f93195704                                                                                             0.0s
 => => naming to docker.io/library/couchbase-demo:1.0.0                                                                                                                                  0.0s

What's Next?
  View a summary of image vulnerabilities and recommendations → docker scout quickview
```
Run the following command for running the built artifact
```
$ docker run -it couchbase-demo:1.0.0
```
You will see the following error trace
```
 docker run -it couchbase-demo:1.0.0                                                                                                                                                     ─╯

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.2.1)

2024-01-09T05:36:04.421Z  INFO 1 --- [           main] [                                                 ] c.k.c.CouchbaseDemoApplication           : Starting AOT-processed CouchbaseDemoApplication using Java 21.0.1 with PID 1 (/app/couchbase-demo started by root in /app)
2024-01-09T05:36:04.421Z  INFO 1 --- [           main] [                                                 ] c.k.c.CouchbaseDemoApplication           : No active profile set, falling back to 1 default profile: "default"
2024-01-09T05:36:04.428Z  WARN 1 --- [           main] [                                                 ] trationDelegate$BeanPostProcessorChecker : Bean 'couchbaseConfig' of type [com.korkutkose.couchbasedemo.configuration.CouchbaseConfig$$SpringCGLIB$$0] is not eligible for getting processed by all BeanPostProcessors (for example: not eligible for auto-proxying). Is this bean getting eagerly injected into a currently created BeanPostProcessor [transactionInterceptorCustomizer]? Check the corresponding BeanPostProcessor declaration and its dependencies.
2024-01-09T05:36:04.438Z  WARN 1 --- [           main] [                                                 ] w.s.c.ServletWebServerApplicationContext : Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'transactionInterceptorCustomizer': Error creating bean with name 'org.springframework.transaction.config.internalTransactionAdvisor': Unsatisfied dependency expressed through method 'transactionAdvisor' parameter 1: Error creating bean with name 'transactionInterceptor': Error creating bean with name 'couchbaseTransactionManager': Unsatisfied dependency expressed through method 'couchbaseTransactionManager' parameter 0: Error creating bean with name 'couchbaseClientFactory': Unsatisfied dependency expressed through method 'couchbaseClientFactory' parameter 0: Error creating bean with name 'couchbaseCluster': Unsatisfied dependency expressed through method 'couchbaseCluster' parameter 0: Error creating bean with name 'couchbaseClusterEnvironment': Instantiation of supplied bean failed
2024-01-09T05:36:04.439Z ERROR 1 --- [           main] [                                                 ] o.s.boot.SpringApplication               : Application run failed

org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'transactionInterceptorCustomizer': Error creating bean with name 'org.springframework.transaction.config.internalTransactionAdvisor': Unsatisfied dependency expressed through method 'transactionAdvisor' parameter 1: Error creating bean with name 'transactionInterceptor': Error creating bean with name 'couchbaseTransactionManager': Unsatisfied dependency expressed through method 'couchbaseTransactionManager' parameter 0: Error creating bean with name 'couchbaseClientFactory': Unsatisfied dependency expressed through method 'couchbaseClientFactory' parameter 0: Error creating bean with name 'couchbaseCluster': Unsatisfied dependency expressed through method 'couchbaseCluster' parameter 0: Error creating bean with name 'couchbaseClusterEnvironment': Instantiation of supplied bean failed
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:606) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:521) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:325) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:323) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:204) ~[couchbase-demo:6.1.2]
	at org.springframework.context.support.PostProcessorRegistrationDelegate.registerBeanPostProcessors(PostProcessorRegistrationDelegate.java:277) ~[na:na]
	at org.springframework.context.support.AbstractApplicationContext.registerBeanPostProcessors(AbstractApplicationContext.java:806) ~[couchbase-demo:6.1.2]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:609) ~[couchbase-demo:6.1.2]
	at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:146) ~[couchbase-demo:3.2.1]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:762) ~[couchbase-demo:3.2.1]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:464) ~[couchbase-demo:3.2.1]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:334) ~[couchbase-demo:3.2.1]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1358) ~[couchbase-demo:3.2.1]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1347) ~[couchbase-demo:3.2.1]
	at com.korkutkose.couchbasedemo.CouchbaseDemoApplication.main(CouchbaseDemoApplication.java:14) ~[couchbase-demo:na]
	at java.base@21.0.1/java.lang.invoke.LambdaForm$DMH/sa346b79c.invokeStaticInit(LambdaForm$DMH) ~[na:na]
Caused by: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'org.springframework.transaction.config.internalTransactionAdvisor': Unsatisfied dependency expressed through method 'transactionAdvisor' parameter 1: Error creating bean with name 'transactionInterceptor': Error creating bean with name 'couchbaseTransactionManager': Unsatisfied dependency expressed through method 'couchbaseTransactionManager' parameter 0: Error creating bean with name 'couchbaseClientFactory': Unsatisfied dependency expressed through method 'couchbaseClientFactory' parameter 0: Error creating bean with name 'couchbaseCluster': Unsatisfied dependency expressed through method 'couchbaseCluster' parameter 0: Error creating bean with name 'couchbaseClusterEnvironment': Instantiation of supplied bean failed
	at org.springframework.beans.factory.aot.BeanInstanceSupplier.resolveAutowiredArgument(BeanInstanceSupplier.java:344) ~[na:na]
	at org.springframework.beans.factory.aot.BeanInstanceSupplier.resolveArguments(BeanInstanceSupplier.java:264) ~[na:na]
	at org.springframework.beans.factory.aot.BeanInstanceSupplier.get(BeanInstanceSupplier.java:204) ~[na:na]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.obtainInstanceFromSupplier(DefaultListableBeanFactory.java:949) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.obtainFromSupplier(AbstractAutowireCapableBeanFactory.java:1216) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1160) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:561) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:521) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:325) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:323) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:204) ~[couchbase-demo:6.1.2]
	at org.springframework.aop.framework.autoproxy.BeanFactoryAdvisorRetrievalHelper.findAdvisorBeans(BeanFactoryAdvisorRetrievalHelper.java:91) ~[couchbase-demo:6.1.2]
	at org.springframework.aop.framework.autoproxy.AbstractAdvisorAutoProxyCreator.findCandidateAdvisors(AbstractAdvisorAutoProxyCreator.java:111) ~[couchbase-demo:6.1.2]
	at org.springframework.aop.framework.autoproxy.AbstractAdvisorAutoProxyCreator.findEligibleAdvisors(AbstractAdvisorAutoProxyCreator.java:96) ~[couchbase-demo:6.1.2]
	at org.springframework.aop.framework.autoproxy.AbstractAdvisorAutoProxyCreator.getAdvicesAndAdvisorsForBean(AbstractAdvisorAutoProxyCreator.java:78) ~[couchbase-demo:6.1.2]
	at org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator.wrapIfNecessary(AbstractAutoProxyCreator.java:366) ~[couchbase-demo:6.1.2]
	at org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator.postProcessAfterInitialization(AbstractAutoProxyCreator.java:318) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsAfterInitialization(AbstractAutowireCapableBeanFactory.java:437) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1776) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:599) ~[couchbase-demo:6.1.2]
	... 16 common frames omitted
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'transactionInterceptor': Error creating bean with name 'couchbaseTransactionManager': Unsatisfied dependency expressed through method 'couchbaseTransactionManager' parameter 0: Error creating bean with name 'couchbaseClientFactory': Unsatisfied dependency expressed through method 'couchbaseClientFactory' parameter 0: Error creating bean with name 'couchbaseCluster': Unsatisfied dependency expressed through method 'couchbaseCluster' parameter 0: Error creating bean with name 'couchbaseClusterEnvironment': Instantiation of supplied bean failed
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:606) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:521) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:325) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:323) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:199) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.config.DependencyDescriptor.resolveCandidate(DependencyDescriptor.java:254) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1443) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1353) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.ConstructorResolver.resolveAutowiredArgument(ConstructorResolver.java:911) ~[na:na]
	at org.springframework.beans.factory.support.RegisteredBean.resolveAutowiredArgument(RegisteredBean.java:229) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.aot.BeanInstanceSupplier.resolveAutowiredArgument(BeanInstanceSupplier.java:341) ~[na:na]
	... 36 common frames omitted
Caused by: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'couchbaseTransactionManager': Unsatisfied dependency expressed through method 'couchbaseTransactionManager' parameter 0: Error creating bean with name 'couchbaseClientFactory': Unsatisfied dependency expressed through method 'couchbaseClientFactory' parameter 0: Error creating bean with name 'couchbaseCluster': Unsatisfied dependency expressed through method 'couchbaseCluster' parameter 0: Error creating bean with name 'couchbaseClusterEnvironment': Instantiation of supplied bean failed
	at org.springframework.beans.factory.aot.BeanInstanceSupplier.resolveAutowiredArgument(BeanInstanceSupplier.java:344) ~[na:na]
	at org.springframework.beans.factory.aot.BeanInstanceSupplier.resolveArguments(BeanInstanceSupplier.java:264) ~[na:na]
	at org.springframework.beans.factory.aot.BeanInstanceSupplier.get(BeanInstanceSupplier.java:204) ~[na:na]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.obtainInstanceFromSupplier(DefaultListableBeanFactory.java:949) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.obtainFromSupplier(AbstractAutowireCapableBeanFactory.java:1216) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1160) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:561) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:521) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:325) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:323) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:199) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.config.DependencyDescriptor.resolveCandidate(DependencyDescriptor.java:254) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1443) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory$DependencyObjectProvider.getObject(DefaultListableBeanFactory.java:2070) ~[na:na]
	at org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration$1.postProcessBeforeInitialization(AbstractCouchbaseConfiguration.java:393) ~[na:na]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.applyBeanPostProcessorsBeforeInitialization(AbstractAutowireCapableBeanFactory.java:421) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1765) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:599) ~[couchbase-demo:6.1.2]
	... 47 common frames omitted
Caused by: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'couchbaseClientFactory': Unsatisfied dependency expressed through method 'couchbaseClientFactory' parameter 0: Error creating bean with name 'couchbaseCluster': Unsatisfied dependency expressed through method 'couchbaseCluster' parameter 0: Error creating bean with name 'couchbaseClusterEnvironment': Instantiation of supplied bean failed
	at org.springframework.beans.factory.aot.BeanInstanceSupplier.resolveAutowiredArgument(BeanInstanceSupplier.java:344) ~[na:na]
	at org.springframework.beans.factory.aot.BeanInstanceSupplier.resolveArguments(BeanInstanceSupplier.java:264) ~[na:na]
	at org.springframework.beans.factory.aot.BeanInstanceSupplier.get(BeanInstanceSupplier.java:204) ~[na:na]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.obtainInstanceFromSupplier(DefaultListableBeanFactory.java:949) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.obtainFromSupplier(AbstractAutowireCapableBeanFactory.java:1216) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1160) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:561) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:521) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:325) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:323) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:199) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.config.DependencyDescriptor.resolveCandidate(DependencyDescriptor.java:254) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1443) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1353) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.ConstructorResolver.resolveAutowiredArgument(ConstructorResolver.java:911) ~[na:na]
	at org.springframework.beans.factory.support.RegisteredBean.resolveAutowiredArgument(RegisteredBean.java:229) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.aot.BeanInstanceSupplier.resolveAutowiredArgument(BeanInstanceSupplier.java:341) ~[na:na]
	... 65 common frames omitted
Caused by: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'couchbaseCluster': Unsatisfied dependency expressed through method 'couchbaseCluster' parameter 0: Error creating bean with name 'couchbaseClusterEnvironment': Instantiation of supplied bean failed
	at org.springframework.beans.factory.aot.BeanInstanceSupplier.resolveAutowiredArgument(BeanInstanceSupplier.java:344) ~[na:na]
	at org.springframework.beans.factory.aot.BeanInstanceSupplier.resolveArguments(BeanInstanceSupplier.java:264) ~[na:na]
	at org.springframework.beans.factory.aot.BeanInstanceSupplier.get(BeanInstanceSupplier.java:204) ~[na:na]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.obtainInstanceFromSupplier(DefaultListableBeanFactory.java:949) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.obtainFromSupplier(AbstractAutowireCapableBeanFactory.java:1216) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1160) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:561) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:521) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:325) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:323) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:199) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.config.DependencyDescriptor.resolveCandidate(DependencyDescriptor.java:254) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1443) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1353) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.ConstructorResolver.resolveAutowiredArgument(ConstructorResolver.java:911) ~[na:na]
	at org.springframework.beans.factory.support.RegisteredBean.resolveAutowiredArgument(RegisteredBean.java:229) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.aot.BeanInstanceSupplier.resolveAutowiredArgument(BeanInstanceSupplier.java:341) ~[na:na]
	... 82 common frames omitted
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'couchbaseClusterEnvironment': Instantiation of supplied bean failed
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.obtainFromSupplier(AbstractAutowireCapableBeanFactory.java:1222) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1160) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:561) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:521) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:325) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:323) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:199) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.config.DependencyDescriptor.resolveCandidate(DependencyDescriptor.java:254) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1443) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1353) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.ConstructorResolver.resolveAutowiredArgument(ConstructorResolver.java:911) ~[na:na]
	at org.springframework.beans.factory.support.RegisteredBean.resolveAutowiredArgument(RegisteredBean.java:229) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.aot.BeanInstanceSupplier.resolveAutowiredArgument(BeanInstanceSupplier.java:341) ~[na:na]
	... 99 common frames omitted
Caused by: com.couchbase.client.core.error.CouchbaseException: non-shadowed Jackson not present
	at org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration.couchbaseClusterEnvironment(AbstractCouchbaseConfiguration.java:175) ~[couchbase-demo:5.2.1]
	at com.korkutkose.couchbasedemo.configuration.CouchbaseConfig$$SpringCGLIB$$0.CGLIB$couchbaseClusterEnvironment$25(<generated>) ~[couchbase-demo:na]
	at com.korkutkose.couchbasedemo.configuration.CouchbaseConfig$$SpringCGLIB$$FastClass$$1.invoke(<generated>) ~[couchbase-demo:na]
	at org.springframework.cglib.proxy.MethodProxy.invokeSuper(MethodProxy.java:258) ~[couchbase-demo:6.1.2]
	at org.springframework.context.annotation.ConfigurationClassEnhancer$BeanMethodInterceptor.intercept(ConfigurationClassEnhancer.java:331) ~[na:na]
	at com.korkutkose.couchbasedemo.configuration.CouchbaseConfig$$SpringCGLIB$$0.couchbaseClusterEnvironment(<generated>) ~[couchbase-demo:na]
	at org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration__BeanDefinitions.lambda$getCouchbaseClusterEnvironmentInstanceSupplier$2(AbstractCouchbaseConfiguration__BeanDefinitions.java:75) ~[na:na]
	at org.springframework.util.function.ThrowingFunction.apply(ThrowingFunction.java:63) ~[couchbase-demo:6.1.2]
	at org.springframework.util.function.ThrowingFunction.apply(ThrowingFunction.java:51) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.aot.BeanInstanceSupplier.lambda$withGenerator$0(BeanInstanceSupplier.java:171) ~[na:na]
	at org.springframework.util.function.ThrowingBiFunction.apply(ThrowingBiFunction.java:68) ~[couchbase-demo:6.1.2]
	at org.springframework.util.function.ThrowingBiFunction.apply(ThrowingBiFunction.java:54) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.aot.BeanInstanceSupplier.lambda$get$2(BeanInstanceSupplier.java:206) ~[na:na]
	at org.springframework.util.function.ThrowingSupplier.get(ThrowingSupplier.java:58) ~[couchbase-demo:6.1.2]
	at org.springframework.util.function.ThrowingSupplier.get(ThrowingSupplier.java:46) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.aot.BeanInstanceSupplier.invokeBeanSupplier(BeanInstanceSupplier.java:218) ~[na:na]
	at org.springframework.beans.factory.aot.BeanInstanceSupplier.get(BeanInstanceSupplier.java:206) ~[na:na]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.obtainInstanceFromSupplier(DefaultListableBeanFactory.java:949) ~[couchbase-demo:6.1.2]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.obtainFromSupplier(AbstractAutowireCapableBeanFactory.java:1216) ~[couchbase-demo:6.1.2]
	... 112 common frames omitted
```