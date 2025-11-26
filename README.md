# Spring Boot 4 - Demo for possible bug with multiple @EnableJpaRepositories

This project shows a possible bug with multiple @EnableJpaRepositories in Spring Boot 4.

With the Version `3.5.8` this project works as expected.
But with `4.0.0` run with AOT enabled, the application fails with an exception.

## Build and run

```
mvn package -P springAot
```

Then run with `-Dspring.aot.enabled=true`.

IntelliJ run configurations are included.

## Exception in Spring Boot 4 (AOT)

```
2025-11-26T15:45:02.927+01:00 ERROR 14459 --- [           main] o.s.boot.SpringApplication               : Application run failed

org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'secondService': Unsatisfied dependency expressed through constructor parameter 0: Error creating bean with name 'secondRepository': Not a managed type: class org.example.second.SecondEntity
	at org.springframework.beans.factory.aot.BeanInstanceSupplier.resolveAutowiredArgument(BeanInstanceSupplier.java:341) ~[spring-beans-7.0.1.jar:7.0.1]
	at org.springframework.beans.factory.aot.BeanInstanceSupplier.resolveArguments(BeanInstanceSupplier.java:262) ~[spring-beans-7.0.1.jar:7.0.1]
	at org.springframework.beans.factory.aot.BeanInstanceSupplier.get(BeanInstanceSupplier.java:198) ~[spring-beans-7.0.1.jar:7.0.1]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.obtainInstanceFromSupplier(DefaultListableBeanFactory.java:1024) ~[spring-beans-7.0.1.jar:7.0.1]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.obtainFromSupplier(AbstractAutowireCapableBeanFactory.java:1246) ~[spring-beans-7.0.1.jar:7.0.1]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1189) ~[spring-beans-7.0.1.jar:7.0.1]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:565) ~[spring-beans-7.0.1.jar:7.0.1]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:525) ~[spring-beans-7.0.1.jar:7.0.1]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:333) ~[spring-beans-7.0.1.jar:7.0.1]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:371) ~[spring-beans-7.0.1.jar:7.0.1]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:331) ~[spring-beans-7.0.1.jar:7.0.1]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:196) ~[spring-beans-7.0.1.jar:7.0.1]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.instantiateSingleton(DefaultListableBeanFactory.java:1218) ~[spring-beans-7.0.1.jar:7.0.1]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingleton(DefaultListableBeanFactory.java:1184) ~[spring-beans-7.0.1.jar:7.0.1]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:1121) ~[spring-beans-7.0.1.jar:7.0.1]
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:983) ~[spring-context-7.0.1.jar:7.0.1]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:620) ~[spring-context-7.0.1.jar:7.0.1]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:765) ~[spring-boot-4.0.0.jar:4.0.0]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:454) ~[spring-boot-4.0.0.jar:4.0.0]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:321) ~[spring-boot-4.0.0.jar:4.0.0]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1374) ~[spring-boot-4.0.0.jar:4.0.0]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1363) ~[spring-boot-4.0.0.jar:4.0.0]
	at org.example.Application.main(Application.java:10) ~[classes/:na]
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'secondRepository': Not a managed type: class org.example.second.SecondEntity
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1817) ~[spring-beans-7.0.1.jar:7.0.1]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:603) ~[spring-beans-7.0.1.jar:7.0.1]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:525) ~[spring-beans-7.0.1.jar:7.0.1]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:333) ~[spring-beans-7.0.1.jar:7.0.1]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:371) ~[spring-beans-7.0.1.jar:7.0.1]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:331) ~[spring-beans-7.0.1.jar:7.0.1]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:201) ~[spring-beans-7.0.1.jar:7.0.1]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveBean(DefaultListableBeanFactory.java:1225) ~[spring-beans-7.0.1.jar:7.0.1]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1704) ~[spring-beans-7.0.1.jar:7.0.1]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1651) ~[spring-beans-7.0.1.jar:7.0.1]
	at org.springframework.beans.factory.support.ConstructorResolver.resolveAutowiredArgument(ConstructorResolver.java:912) ~[spring-beans-7.0.1.jar:7.0.1]
	at org.springframework.beans.factory.support.RegisteredBean.resolveAutowiredArgument(RegisteredBean.java:251) ~[spring-beans-7.0.1.jar:7.0.1]
	at org.springframework.beans.factory.aot.BeanInstanceSupplier.resolveAutowiredArgument(BeanInstanceSupplier.java:338) ~[spring-beans-7.0.1.jar:7.0.1]
	... 22 common frames omitted
Caused by: java.lang.IllegalArgumentException: Not a managed type: class org.example.second.SecondEntity
	at org.hibernate.metamodel.model.domain.internal.JpaMetamodelImpl.managedType(JpaMetamodelImpl.java:247) ~[hibernate-core-7.1.8.Final.jar:7.1.8.Final]
	at org.hibernate.metamodel.model.domain.internal.MappingMetamodelImpl.managedType(MappingMetamodelImpl.java:413) ~[hibernate-core-7.1.8.Final.jar:7.1.8.Final]
	at org.hibernate.metamodel.model.domain.internal.MappingMetamodelImpl.managedType(MappingMetamodelImpl.java:88) ~[hibernate-core-7.1.8.Final.jar:7.1.8.Final]
	at org.springframework.data.jpa.repository.support.JpaEntityInformationSupport.getEntityInformation(JpaEntityInformationSupport.java:92) ~[spring-data-jpa-4.0.0.jar:na]
	at org.springframework.data.jpa.repository.support.JpaEntityInformationSupport.getEntityInformation(JpaEntityInformationSupport.java:73) ~[spring-data-jpa-4.0.0.jar:na]
	at org.springframework.data.jpa.repository.support.JpaRepositoryFactory.getEntityInformation(JpaRepositoryFactory.java:270) ~[spring-data-jpa-4.0.0.jar:na]
	at org.springframework.data.jpa.repository.support.JpaRepositoryFactory.getRepositoryFragments(JpaRepositoryFactory.java:300) ~[spring-data-jpa-4.0.0.jar:na]
	at org.springframework.data.jpa.repository.support.JpaRepositoryFactory.getRepositoryFragments(JpaRepositoryFactory.java:280) ~[spring-data-jpa-4.0.0.jar:na]
	at org.springframework.data.repository.core.support.RepositoryFactorySupport.lambda$getRepositoryStub$0(RepositoryFactorySupport.java:505) ~[spring-data-commons-4.0.0.jar:na]
	at java.base/java.util.HashMap.computeIfAbsent(HashMap.java:1229) ~[na:na]
	at org.springframework.data.repository.core.support.RepositoryFactorySupport.getRepositoryStub(RepositoryFactorySupport.java:502) ~[spring-data-commons-4.0.0.jar:na]
	at org.springframework.data.repository.core.support.RepositoryFactorySupport.getRepository(RepositoryFactorySupport.java:338) ~[spring-data-commons-4.0.0.jar:na]
	at org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport.lambda$afterPropertiesSet$1(RepositoryFactoryBeanSupport.java:351) ~[spring-data-commons-4.0.0.jar:na]
	at org.springframework.data.util.Lazy.getNullable(Lazy.java:136) ~[spring-data-commons-4.0.0.jar:4.0.0]
	at org.springframework.data.util.Lazy.get(Lazy.java:114) ~[spring-data-commons-4.0.0.jar:4.0.0]
	at org.springframework.data.repository.core.support.RepositoryFactoryBeanSupport.afterPropertiesSet(RepositoryFactoryBeanSupport.java:360) ~[spring-data-commons-4.0.0.jar:na]
	at org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean.afterPropertiesSet(JpaRepositoryFactoryBean.java:212) ~[spring-data-jpa-4.0.0.jar:na]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1864) ~[spring-beans-7.0.1.jar:7.0.1]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1813) ~[spring-beans-7.0.1.jar:7.0.1]
	... 34 common frames omitted
```