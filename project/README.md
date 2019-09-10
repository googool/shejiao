# 问答系统

使用了SSM框架搭建仿知乎问答社区
## 一.项目的来源

本项目对于一个本菜鸡来说是全新的技术栈，第一遍跟着做，做完后进行总结。争取今年五六月份进行项目的二次重构，并进行功能的扩展和完善。

## 二.项目环境搭建

- **操作系统**:Windows 10
- **IDE**:IntelliJ IDEA 2018.3
- **JDK Version** : JDK1.8 建议使用JDK1.7以上版本
- **Web容器** ： SpringBoot集成的默认容器-Tomcat
- **数据库** ：Mysql-8.0.13
- **依赖管理工具** : Maven 管理jar包真的很方便
- **版本控制**: Git

## 三.项目的运行

- 下载

直接`Download Zip`或者是`git clone`

    `git clone https://github.com/Howie66/wenda.git`

- 导入到IDE

使用`IDEA`创建的项目,配置好`maven`的相关配置,以及项目`JDK`版本,直接在主界面选择`Open`,然后找到项目所在路径,点击导入就可以了

- 邮件发送配置

        mailSender.setUsername("15615833117@163.com"); //账号的名字
        mailSender.setPassword("xxxxxx");//账号生成的动态密码
        mailSender.setHost("smtp.163.com");//使用的邮件服务器
        //mailSender.setHost("smtp.qq.com");
        mailSender.setPort(465);//邮件的端口
        mailSender.setProtocol("smtps");//邮件的协议
        mailSender.setDefaultEncoding("utf8");//邮件使用的编码

- 数据库的建立

数据库文件都在resourses/sql目录下面，导入数据库之后可以自行填充数据



## 三.项目问题总结

**1.启动的时候报错显示无法注入（AutoWired）**

    org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'initDatabaseTests': Injection of autowired dependencies failed; nested exception is org.springframework.beans.factory.BeanCreationException: Could not autowire field: com.howie.wenda.dao.UserDAO com.howie.wenda.InitDatabaseTests.userDAO; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type [com.howie.wenda.dao.UserDAO] found for dependency: expected at least 1 bean which qualifies as autowire candidate for this dependency. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
    	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.postProcessPropertyValues(AutowiredAnnotationBeanPostProcessor.java:334) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1214) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:543) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:482) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:306) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:230) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:302) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:197) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:772) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:839) ~[spring-context-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:538) ~[spring-context-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:766) ~[spring-boot-1.3.5.RELEASE.jar:1.3.5.RELEASE]
    	at org.springframework.boot.SpringApplication.createAndRefreshContext(SpringApplication.java:361) ~[spring-boot-1.3.5.RELEASE.jar:1.3.5.RELEASE]
    	at org.springframework.boot.SpringApplication.run(SpringApplication.java:307) ~[spring-boot-1.3.5.RELEASE.jar:1.3.5.RELEASE]
    	at org.springframework.boot.test.SpringApplicationContextLoader.loadContext(SpringApplicationContextLoader.java:98) [spring-boot-1.3.5.RELEASE.jar:1.3.5.RELEASE]
    	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:98) [spring-test-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:116) [spring-test-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:83) [spring-test-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.test.context.support.DependencyInjectionTestExecutionListener.injectDependencies(DependencyInjectionTestExecutionListener.java:117) [spring-test-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.test.context.support.DependencyInjectionTestExecutionListener.prepareTestInstance(DependencyInjectionTestExecutionListener.java:83) [spring-test-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.test.context.TestContextManager.prepareTestInstance(TestContextManager.java:228) [spring-test-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.createTest(SpringJUnit4ClassRunner.java:230) [spring-test-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner$1.runReflectiveCall(SpringJUnit4ClassRunner.java:289) [spring-test-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12) [junit-4.12.jar:4.12]
    	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.methodBlock(SpringJUnit4ClassRunner.java:291) [spring-test-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.runChild(SpringJUnit4ClassRunner.java:249) [spring-test-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.runChild(SpringJUnit4ClassRunner.java:89) [spring-test-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290) [junit-4.12.jar:4.12]
    	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71) [junit-4.12.jar:4.12]
    	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288) [junit-4.12.jar:4.12]
    	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58) [junit-4.12.jar:4.12]
    	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268) [junit-4.12.jar:4.12]
    	at org.springframework.test.context.junit4.statements.RunBeforeTestClassCallbacks.evaluate(RunBeforeTestClassCallbacks.java:61) [spring-test-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.test.context.junit4.statements.RunAfterTestClassCallbacks.evaluate(RunAfterTestClassCallbacks.java:70) [spring-test-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.junit.runners.ParentRunner.run(ParentRunner.java:363) [junit-4.12.jar:4.12]
    	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.run(SpringJUnit4ClassRunner.java:193) [spring-test-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.junit.runner.JUnitCore.run(JUnitCore.java:137) [junit-4.12.jar:4.12]
    	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68) [junit-rt.jar:na]
    	at com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47) [junit-rt.jar:na]
    	at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242) [junit-rt.jar:na]
    	at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70) [junit-rt.jar:na]
    Caused by: org.springframework.beans.factory.BeanCreationException: Could not autowire field: com.howie.wenda.dao.UserDAO com.howie.wenda.InitDatabaseTests.userDAO; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type [com.howie.wenda.dao.UserDAO] found for dependency: expected at least 1 bean which qualifies as autowire candidate for this dependency. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
    	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredFieldElement.inject(AutowiredAnnotationBeanPostProcessor.java:573) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.beans.factory.annotation.InjectionMetadata.inject(InjectionMetadata.java:88) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.postProcessPropertyValues(AutowiredAnnotationBeanPostProcessor.java:331) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	... 40 common frames omitted
    Caused by: org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type [com.howie.wenda.dao.UserDAO] found for dependency: expected at least 1 bean which qualifies as autowire candidate for this dependency. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
    	at org.springframework.beans.factory.support.DefaultListableBeanFactory.raiseNoSuchBeanDefinitionException(DefaultListableBeanFactory.java:1373) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1119) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1014) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredFieldElement.inject(AutowiredAnnotationBeanPostProcessor.java:545) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	... 42 common frames omitted
    
    2019-01-06 20:09:12.377  INFO 219244 --- [           main] .b.l.ClasspathLoggingApplicationListener : Application failed to start with classpath: unknown
    2019-01-06 20:09:12.378 ERROR 219244 --- [           main] o.s.test.context.TestContextManager      : Caught exception while allowing TestExecutionListener [org.springframework.test.context.support.DependencyInjectionTestExecutionListener@815b41f] to prepare test instance [com.howie.wenda.InitDatabaseTests@37ceb1df]
    
    java.lang.IllegalStateException: Failed to load ApplicationContext
    	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124) ~[spring-test-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:83) ~[spring-test-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.test.context.support.DependencyInjectionTestExecutionListener.injectDependencies(DependencyInjectionTestExecutionListener.java:117) ~[spring-test-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.test.context.support.DependencyInjectionTestExecutionListener.prepareTestInstance(DependencyInjectionTestExecutionListener.java:83) ~[spring-test-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.test.context.TestContextManager.prepareTestInstance(TestContextManager.java:228) ~[spring-test-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.createTest(SpringJUnit4ClassRunner.java:230) [spring-test-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner$1.runReflectiveCall(SpringJUnit4ClassRunner.java:289) [spring-test-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12) [junit-4.12.jar:4.12]
    	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.methodBlock(SpringJUnit4ClassRunner.java:291) [spring-test-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.runChild(SpringJUnit4ClassRunner.java:249) [spring-test-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.runChild(SpringJUnit4ClassRunner.java:89) [spring-test-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290) [junit-4.12.jar:4.12]
    	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71) [junit-4.12.jar:4.12]
    	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288) [junit-4.12.jar:4.12]
    	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58) [junit-4.12.jar:4.12]
    	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268) [junit-4.12.jar:4.12]
    	at org.springframework.test.context.junit4.statements.RunBeforeTestClassCallbacks.evaluate(RunBeforeTestClassCallbacks.java:61) [spring-test-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.test.context.junit4.statements.RunAfterTestClassCallbacks.evaluate(RunAfterTestClassCallbacks.java:70) [spring-test-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.junit.runners.ParentRunner.run(ParentRunner.java:363) [junit-4.12.jar:4.12]
    	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.run(SpringJUnit4ClassRunner.java:193) [spring-test-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.junit.runner.JUnitCore.run(JUnitCore.java:137) [junit-4.12.jar:4.12]
    	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68) [junit-rt.jar:na]
    	at com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47) [junit-rt.jar:na]
    	at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242) [junit-rt.jar:na]
    	at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70) [junit-rt.jar:na]
    Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'initDatabaseTests': Injection of autowired dependencies failed; nested exception is org.springframework.beans.factory.BeanCreationException: Could not autowire field: com.howie.wenda.dao.UserDAO com.howie.wenda.InitDatabaseTests.userDAO; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type [com.howie.wenda.dao.UserDAO] found for dependency: expected at least 1 bean which qualifies as autowire candidate for this dependency. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
    	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.postProcessPropertyValues(AutowiredAnnotationBeanPostProcessor.java:334) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1214) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:543) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:482) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:306) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:230) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:302) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:197) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:772) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:839) ~[spring-context-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:538) ~[spring-context-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:766) ~[spring-boot-1.3.5.RELEASE.jar:1.3.5.RELEASE]
    	at org.springframework.boot.SpringApplication.createAndRefreshContext(SpringApplication.java:361) ~[spring-boot-1.3.5.RELEASE.jar:1.3.5.RELEASE]
    	at org.springframework.boot.SpringApplication.run(SpringApplication.java:307) ~[spring-boot-1.3.5.RELEASE.jar:1.3.5.RELEASE]
    	at org.springframework.boot.test.SpringApplicationContextLoader.loadContext(SpringApplicationContextLoader.java:98) ~[spring-boot-1.3.5.RELEASE.jar:1.3.5.RELEASE]
    	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:98) ~[spring-test-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:116) ~[spring-test-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	... 24 common frames omitted
    Caused by: org.springframework.beans.factory.BeanCreationException: Could not autowire field: com.howie.wenda.dao.UserDAO com.howie.wenda.InitDatabaseTests.userDAO; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type [com.howie.wenda.dao.UserDAO] found for dependency: expected at least 1 bean which qualifies as autowire candidate for this dependency. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
    	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredFieldElement.inject(AutowiredAnnotationBeanPostProcessor.java:573) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.beans.factory.annotation.InjectionMetadata.inject(InjectionMetadata.java:88) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.postProcessPropertyValues(AutowiredAnnotationBeanPostProcessor.java:331) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	... 40 common frames omitted
    Caused by: org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type [com.howie.wenda.dao.UserDAO] found for dependency: expected at least 1 bean which qualifies as autowire candidate for this dependency. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
    	at org.springframework.beans.factory.support.DefaultListableBeanFactory.raiseNoSuchBeanDefinitionException(DefaultListableBeanFactory.java:1373) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1119) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1014) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredFieldElement.inject(AutowiredAnnotationBeanPostProcessor.java:545) ~[spring-beans-4.2.6.RELEASE.jar:4.2.6.RELEASE]
    	... 42 common frames omitted
    
    
    java.lang.IllegalStateException: Failed to load ApplicationContext
    
    	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
    	at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:83)
    	at org.springframework.test.context.support.DependencyInjectionTestExecutionListener.injectDependencies(DependencyInjectionTestExecutionListener.java:117)
    	at org.springframework.test.context.support.DependencyInjectionTestExecutionListener.prepareTestInstance(DependencyInjectionTestExecutionListener.java:83)
    	at org.springframework.test.context.TestContextManager.prepareTestInstance(TestContextManager.java:228)
    	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.createTest(SpringJUnit4ClassRunner.java:230)
    	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner$1.runReflectiveCall(SpringJUnit4ClassRunner.java:289)
    	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
    	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.methodBlock(SpringJUnit4ClassRunner.java:291)
    	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.runChild(SpringJUnit4ClassRunner.java:249)
    	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.runChild(SpringJUnit4ClassRunner.java:89)
    	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
    	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
    	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
    	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
    	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
    	at org.springframework.test.context.junit4.statements.RunBeforeTestClassCallbacks.evaluate(RunBeforeTestClassCallbacks.java:61)
    	at org.springframework.test.context.junit4.statements.RunAfterTestClassCallbacks.evaluate(RunAfterTestClassCallbacks.java:70)
    	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
    	at org.springframework.test.context.junit4.SpringJUnit4ClassRunner.run(SpringJUnit4ClassRunner.java:193)
    	at org.junit.runner.JUnitCore.run(JUnitCore.java:137)
    	at com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)
    	at com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47)
    	at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242)
    	at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)
    Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'initDatabaseTests': Injection of autowired dependencies failed; nested exception is org.springframework.beans.factory.BeanCreationException: Could not autowire field: com.howie.wenda.dao.UserDAO com.howie.wenda.InitDatabaseTests.userDAO; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type [com.howie.wenda.dao.UserDAO] found for dependency: expected at least 1 bean which qualifies as autowire candidate for this dependency. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
    	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.postProcessPropertyValues(AutowiredAnnotationBeanPostProcessor.java:334)
    	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.populateBean(AbstractAutowireCapableBeanFactory.java:1214)
    	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:543)
    	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:482)
    	at org.springframework.beans.factory.support.AbstractBeanFactory$1.getObject(AbstractBeanFactory.java:306)
    	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:230)
    	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:302)
    	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:197)
    	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:772)
    	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:839)
    	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:538)
    	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:766)
    	at org.springframework.boot.SpringApplication.createAndRefreshContext(SpringApplication.java:361)
    	at org.springframework.boot.SpringApplication.run(SpringApplication.java:307)
    	at org.springframework.boot.test.SpringApplicationContextLoader.loadContext(SpringApplicationContextLoader.java:98)
    	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:98)
    	at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:116)
    	... 24 more
    Caused by: org.springframework.beans.factory.BeanCreationException: Could not autowire field: com.howie.wenda.dao.UserDAO com.howie.wenda.InitDatabaseTests.userDAO; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type [com.howie.wenda.dao.UserDAO] found for dependency: expected at least 1 bean which qualifies as autowire candidate for this dependency. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
    	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredFieldElement.inject(AutowiredAnnotationBeanPostProcessor.java:573)
    	at org.springframework.beans.factory.annotation.InjectionMetadata.inject(InjectionMetadata.java:88)
    	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor.postProcessPropertyValues(AutowiredAnnotationBeanPostProcessor.java:331)
    	... 40 more
    Caused by: org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type [com.howie.wenda.dao.UserDAO] found for dependency: expected at least 1 bean which qualifies as autowire candidate for this dependency. Dependency annotations: {@org.springframework.beans.factory.annotation.Autowired(required=true)}
    	at org.springframework.beans.factory.support.DefaultListableBeanFactory.raiseNoSuchBeanDefinitionException(DefaultListableBeanFactory.java:1373)
    	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1119)
    	at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1014)
    	at org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor$AutowiredFieldElement.inject(AutowiredAnnotationBeanPostProcessor.java:545)
    	... 42 more

**解决方法:** 这里我是改了一下注解的方式，手动指定bean

    @Autowired(required=false)
    @Qualifier("questionService")
    @QuestionService questionService;
       
 然后在DAO层的注解中改变了如下代码：

    @Mapper
    @Component
    @Repository
    
2.Mybatis中报 `java.lang.NullPointerException`

解决方式：将数据库、表、字段的字符编码都应该统一，最好设置成utf8-general_ci

## 五.项目中的技术点讲解

- **Velocity引擎**

Velocity的出现主要是为了解决用户 界面与业务数据分离的情况，jsp在用户访问量大的时候容易出现解析时间久，用户体验性不好等等结果

- **Velocity和Jsp的区别：**

JSP文件实际上执行的是JSP对应的Java类，简单来说就是把JSP的HTML转化为out.write输出，而JSP中的Java代码直接复制到翻译后的Java类中，最终执行的是饭以后的Java类，而Velocity是按照语法规则解析成一颗语法树，然后执行这颗语法树来渲染结果。所以说：

1. 执行的方式不一样，JSP是编译执行，而Velocity是解释执行。如果JSP文件被修改了，那么对应的Java类也要重新编译，而Velocity不需要，因为只是重新的生成一颗语法树就行。
2. 执行效率不同。Jsp为方法调用直接执行，而Velovity是调用反射执行的，但是如果Jsp中有JSTL,语法标签的执行要看标签的实现复杂度。
3. 需要的编译环境不同：JSP需要Sevlet的环境而Velocity可以直接渲染

.

- **Spring Boot**

貌似最近Spring Boot挺火的,还跟微服务,SpringCould等高大上名词的扯上了关系.总结起来就是Spring的发展导致便携性非常高,然后各种配置文件很繁琐,于是又回到了注解的开发,大幅度减少无关于业务的代码量.这个倒确实有点体会,各种Spring的配置文件手动编写起来很是麻烦.

  - 总结出特点就是:
   - 创建独立的Spring应用程序
   - 嵌入的Tomcat，无需部署WAR文件
   - 简化Maven配置
   - 自动配置Spring
   - 提供生产就绪型功能，如指标，健康检查和外部配置
   - 绝对没有代码生成和对XML没有要求配置

[官方网站](https://start.spring.io/)（可以直接创建工程并导入）

- 登录与注册

   - 引入了ticket的概念，用户登录之后会自动的产生一个ticket，然后又放到数据库中，ticket是具有时效性的，通过保存的过期时间与当前服务器的时间进行对比，如果过期了就要重新的登录。如果没有就直接是登录的状态，这里的ticket在服务器发送给客户端之后保存在Cooike中。
   - 用户登录注册功能主要实现的是用户的添加，验证和记住密码一段时间内的免密码登陆。用户的注册时往数据库中插入用户的用户名和密码等信息，用户的验证是从数据库中取出用户的用户名和密码进行比对。明文存储密码的风险性很大，所以采用的是在密码之后加salt再经过MD5加密的形式存储，这样一方面避免了用户密码信息泄露的风险，同时也防止了暴力破解密码的可能性。

- 敏感词过滤

我们采用的是用前缀树算法来进行匹配并替换，时间复杂度和空间复杂度可以降到O(k) 

  - 前缀树
  
   - 根节点不包含字符,除根节点外每一个节点都只包含一个字符
   - 从根节点到某一节点,路径上经过的字符连接起来,为该节点对应的字符串
   - 每个节点的所有子节点包含的字符都不相同 

- 在当今互联网这种上网人群多,访问量大的情况下,异步编程提供了一个非堵塞的,基于事件驱动的编程模型.这种编程方式可以充分利用计算机的多核来同时执行并行任务,提高资源的利用效率.应用场景在我了解的也不多,可以想象应用场景是很广泛的.举个很简单的例子,我们在网站注册新的社交账号的话,严格一点的网站都是会有验证邮箱地址的邮件.这个就是一个异步的事件,你不可能说直接把邮件验证的流程嵌套在业务逻辑里面.应该是把这个事件发送给一个队列里面,然后队列专门处理这种事件.在一个网站中有各种各样的事情需要进行处理 

![](http://pl9dlnuxc.bkt.clouddn.com/anyncQueue.png)

简单设计流程:

- 首先定义一个定义一个枚举类型的EventType类,这里面列举各种各样将会出现的事件
- 再定义一个事件模型EventModel类,里面包含的是一个事件所应该具有的一些属性.例如事件类型,操作者的ID,操作的实体类型,操作的实体ID,操作的实体拥有者等等
- 再定义一个接口EventHandler,里面写上几个抽象的方法,具体的实现由继承的类进行实现
- 定义一个事件生产者EventProducer,这里就是用来生产各种各样的事件,如异常登录或者是注册邮件等等.本项目中这里就是把事件送到Redis中进行储存
- 定义一个事件消费者EventConsumer,这里就是需要继承InitializingBean跟ApplicationContextAware.继承InitializingBean是可以定义bean的初始化方式,继承InitializingBean是为了可以通过这个上下文对象得到我们想获取的bean.然后在这个类里面使用多线程一直去Redis里面读取出事件,然后进行处理
- 再继承EventHandler在方法里面写自己的实现


代码示例：

- `EventType`类

		public enum EventType {
    		LIKE(0),
    		COMMENT(1),
    		LOGIN(2),
	    	MAIL(3),
	    	FOLLOW(4),
	    	UNFOLLOW(5);
	
	    	private int value;
	
	
	    	EventType(int value) {
	       	 	this.value = value;
	    	}
	
	    	public int getValue() {
	        	return value;
	    	}
		}

- `EventModel`类

	public class EventModel {

	    private EventType type;
	    private int actorId;
	    private int entityType;
	    private int entityId;
	    private int entityOwnerId;
	
	
	    private Map<String, String> exts = new HashMap<>();
	
	    public EventModel() {
	    }
	
	
	    public EventModel setExt(String key, String value) {
	        exts.put(key, value);
	        return this;
	    }
	
	
	    public EventModel(EventType type) {
	        this.type = type;
	    }
	
	    public String getExt(String key) {
	        return exts.get(key);
	    }
	
	
	    public EventType getType() {
	        return type;
	    }
	
	
	    public EventModel setType(EventType type) {
	        this.type = type;
	        return this;
	    }
	
	
	    public int getActorId() {
	        return actorId;
	    }
	
	
	    public EventModel setActorId(int actorId) {
	        this.actorId = actorId;
	        return this;
	    }
	
	    public int getEntityType() {
	        return entityType;
	    }
	
	
	    public EventModel setEntityType(int entityType) {
	        this.entityType = entityType;
	        return this;
	    }
	
	
	    public int getEntityId() {
	        return entityId;
	    }
	
	
	    public EventModel setEntityId(int entityId) {
	        this.entityId = entityId;
	        return this;
	    }
	
	
	    public int getEntityOwnerId() {
	        return entityOwnerId;
	    }
	
	
	    public EventModel setEntityOwnerId(int entityOwnerId) {
	        this.entityOwnerId = entityOwnerId;
	        return this;
	    }
	
	    public Map<String, String> getExts() {
	        return exts;
	    }
	
	
	    public EventModel setExts(Map<String, String> exts) {
	        this.exts = exts;
	        return this;
	    }
	}

- `EventHandler`接口

		public interface EventHandler {
			void doHandle(EventModel model);
			List<EventType> getSupportEventTypes();
		}

- `EventProducer`类

		public class EventProducer {
		    private final JedisAdapter jedisAdapter;
		
		
		    @Autowired
		    public EventProducer(JedisAdapter jedisAdapter) {
		        this.jedisAdapter = jedisAdapter;
		    }
		
		
		    public boolean fireEvent(EventModel eventModel) {
		        try {
		            String json = JSONObject.toJSONString(eventModel);
		            String key = RedisKeyUtil.getEventQueueKey();
		            jedisAdapter.lpush(key, json);
		            return true;
		        } catch (Exception e) {
		            return false;
		        }
		    }
		}

- `EventConsumer`类

	public class EventConsumer implements InitializingBean, ApplicationContextAware {

	    private static Logger logger = LoggerFactory.getLogger(EventConsumer.class);
	
	    private Map<EventType, List<EventHandler>> config = new HashMap<>();
	
	    private ApplicationContext applicationContext;
	
	
	    private final JedisAdapter jedisAdapter;
	
	    @Autowired
	    public EventConsumer(JedisAdapter jedisAdapter) {
	        this.jedisAdapter = jedisAdapter;
	    }
	
	
	    @Override
	    public void afterPropertiesSet() throws Exception {
	
	        Map<String, EventHandler> beans = applicationContext.getBeansOfType(EventHandler.class);
	        if (beans != null) {
	            for (Map.Entry<String, EventHandler> entry : beans.entrySet()) {
	                List<EventType> eventTypes = entry.getValue().getSupportEventTypes();
	
	                for (EventType type : eventTypes) {
	                    if (!config.containsKey(type)) {
	                        config.put(type, new ArrayList<>());
	                    }
	                    config.get(type).add(entry.getValue());
	                }
	            }
	        }
	
	
	        Thread thread = new Thread(new Runnable() {
	            @Override
	            public void run() {
	                while (true) {
	                    String key = RedisKeyUtil.getEventQueueKey();
	                    List<String> events = jedisAdapter.brpop(0, key);
	
	                    for (String message : events) {
	                        if (message.equals(key)) {
	                            continue;
	                        }
	                        EventModel eventModel = JSON.parseObject(message, EventModel.class);
	                        if (!config.containsKey(eventModel.getType())) {
	                            logger.error("不能识别的事件");
	                            continue;
	                        }
	
	                        for (EventHandler handler : config.get(eventModel.getType())) {
	                            handler.doHandle(eventModel);
	                        }
	
	                    }
	                }
	            }
	        });
	
	        thread.start();
	
	    }
	
	
	    @Override
	    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
	        this.applicationContext = applicationContext;
	    }
	}
	
- `Handler`继承类

	public class LikeHandler implements EventHandler {

	    private final MessageService messageService;
	
	    private final UserService userService;
	
	    @Autowired
	    public LikeHandler(MessageService messageService, UserService userService) {
	        this.messageService = messageService;
	        this.userService = userService;
	    }
	
	    @Override
	    public void doHandle(EventModel model) {
	        Message message = new Message();
	        message.setFromId(WendaUtil.SYSTEM_USERID);
	        message.setToId(model.getEntityOwnerId());
	        message.setCreateDate(new Date());
	        User user = userService.getUser(model.getActorId());
	        message.setContent("用户" + user.getName() + "赞了你的评论,http://127.0.0.1:8080/question/" + model.getExt("questionId"));
	        // 这里的会话ID肯定是系统管理员跟通知用户之间的会话
	        message.setConversationId(WendaUtil.SYSTEM_USERID + "_" + model.getEntityOwnerId());
	        messageService.addMessage(message);
	    }
	
	    @Override
	    public List<EventType> getSupportEventTypes() {
	        return Arrays.asList(EventType.LIKE);
	    }
	}

- **Spring自定义bean的初始化方法**

在写事件处理的时候继承了`Spring`的`InitializingBean`接口,这个接口只有一个方法:

    public interface InitializingBean {

	/**
	 * Invoked by a BeanFactory after it has set all bean properties supplied
	 * (and satisfied BeanFactoryAware and ApplicationContextAware).
	 * <p>This method allows the bean instance to perform initialization only
	 * possible when all bean properties have been set and to throw an
	 * exception in the event of misconfiguration.
	 * @throws Exception in the event of misconfiguration (such
	 * as failure to set an essential property) or if initialization fails.
	 */
	void afterPropertiesSet() throws Exception;

	}

我们要对某个bean进行自定义的初始化的时候,我们就可以让bean继承这个接口,然后在里面写上我们的业务逻辑,在Spring初始化bean的时候就会检查bean是否继承了InitializingBean接口,然后再执行afterPropertiesSet()方法.

- **Redis事务**

在Java中使用Jedis操作事务

	try {
		Transaction tx = jedis.multi();
		tx.zadd("test", 2, "1");
		tx.zadd("demo", 3, "2");
		List<Object> objs = tx.exec();
		tx.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
	}

## 六.项目中小技术点

- 基本框架开发

  - 创建基本的Controller，service，model层。
  - controller层中使用注解进行配置，requestmapping，responsebody基本可以解决请求转发以及相应内容的渲染。responsebody自动选择viewresolver进行配置。
  - 使用pathvariable和requestparam传递参数
  - 使用velocity进行编写页面的模板，注意其中的语法使用。常用的是$!{}和${}
  - 使用http规范下的httpsevlerequest和httpsevletresponse来进行封装和相应，使用封装好的session和cookie对象
  - 使用重定向的redirectview和统一异常处理器exceptionhandler


- AOP和IOC
  - IOC解决对象实例化以及依赖传递问题，解耦
  - AOP解决纵向切面问题，主要实现日志和权限控制功能。
  - aspect实现切面，并且使用logger来记录日志，用该切面的切面方法来监听controller。

- 问题发表功能，并防止xss注入以及敏感词过滤
  - 发布问题的时候检查标题和内容，防止xss注入，并且过滤敏感词。
  - 防止xss注入直接使用HTMLutils的方法可以实现
  - 过滤敏感词首先需要简历一个字典树，并且读取一份保存敏感词的文本文件，然后初始化字典树。最后将过滤器作为一个服务，让需要过滤敏感词的服务进行调用
  
- 站内信
  - 两个用户之间发送一条消息，又一个唯一的会话id，在这个会话里面可以有多条交互信息，通过一个用户id获取该用户的会话列表，再根据会话id再获取具体的会话内的多条消息。

- 点赞和点踩的功能
  - 开发点赞和点踩的功能直接调用之前写好的jedis的增删改查，放在util包内。
  - 根据需求确定key字段，格式是like：实体类型：实体id和dislike：实体类型：实体id 这样可以将喜欢的人放在一个集合内，不喜欢的在一个集合内。
  - 点赞的操作是先修改redis的值并获取返回值，之后再异步修改mysql数据库的likecount数值。这样既可以保证点赞操作快速完成，也可以保证数据的一致性。
- 异步事件的功能
  - 在async包内开发异步工具包类，事件生产者，事件消费者，并且开发一个eventhandler接口，让各种事件的实现类来实现这个接口。
  - 事件生产者一般作为一个服务，由业务代码进行调用并产生一个事件。而事件消费者在代码中使用了单线程循环获取队列中的事件，并且寻找相应的handler进行处理。
- 邮件功能
  - 主要是引入mail依赖，并且配置好自己的邮箱信息，以及邮件模版，同时在业务代码中加入发邮件的逻辑就可以。
- 关注的功能，关注页面和粉丝页面
  - 主要是使用redis进行实现，通过crud操作可以对应的获取粉丝列表和关注列表，由于关注成功和粉丝成功时同一个事务中的两个操作，可以使用redis的事务multi来包装事务并进行操作。

## 七.项目中的重难点

## 八.项目可以完善的地方
- 用户注册，邮箱激活流程
- 首页滚动到底部自动加载更多
- 管理员后台管理(图形化的显示:进行数据分析与图形化显示)
- 运营推荐问题置顶（推荐系统）
- timeline推拉结合
- 个性化首页，timeline更多事件
- 关键词过滤的优化算法
- 搜索结果排序打分
- 爬虫覆盖用户，评论，内容去html标签
- 个性化推荐(优化后的推荐算法)
- 分布式存储，数据库的分库分表
- 小程序进行同时显示
- 模版引擎优化为freemaker或者是Thymeleaf，替代掉Velocity
- 提高系统的并发量和准确率
- Ajax进行跨域传输(进行优化)
- 密码加密加强
- 争取使用Python中的框架进行二次开发
- 自定义拦截器(针对ip进行拦截)，限制单点登录
- 异步架构中增加更多的事件处理
- 支持多种邮件的发送
- 将前端转化为Vue或者是React等框架

## 九.课下需要做的功课

