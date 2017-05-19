# dubbo-demo
旨在自己mark和分享下，为没使用过的人做下demo
##版本
	spring-boot: 1.3.8.RELEASE
	dubbo: 2.5.3
	zookeeper: 3.4.10
	mybatis: 5.1.39
##了解
既然要用,就先去简单了解下以下工具或技术再来开始吧

1. <a href="https://zookeeper.apache.org/">zookeeper</a>
2. <a href="http://dubbo.io/">dubbo</a>
3. <a href="https://spring.io/">spring-boot</a>
##准备
	maven: 管理项目工具
	zookeeper: 注册中心
	mysql: 数据库
##模块
	<module>dubbo-persistence</module>
	<module>dubbo-common</module>
	<module>dubbo-web</module>
	<module>dubbo-provide</module>
	<module>dubbo-provide-api</module>
	<module>dubbo-boot</module>
<p>
	persistence: 实例化层-供Service调用<br>
	provide: dubbo服务提供者<br>
	provide-api: dubbo服务提供者对外api<br>
	web: 一个web程序,作为consumer调用provide<br>
	boot: spring-boot-starter组件化,封装dubbo的组件
</p>
##运行
	1. git clone https://github.com/xpoll/dubbo-demo.git
	2. cd dubbo-demo
	3. mvn install -DskipTests
	4. 创建db_test库 导入sql->/dubbo-demo/dubbo-provide/src/main/resources/init.sql
	5. 启动zookeeper(你可以顺便把dubbo-monitor-simple启动起来)
	6. java -jar dubbo-provide/target/dubbo-provide-0.0.1.jar
	7. java -jar dubbo-web/target/dubbo-web-0.0.1.jar
	8. call http://127.0.0.1:8080/hello
##配置文件
	prefix:
	  dubbo: 见dubbo-boot,封装dubbo的组件
	  logging: spring-boot-starter-logging
	  spring: spring-boot-starter
	  mybatis: mybatis-spring-boot-starter
	  server: spring-boot-starter
##问题
因水平有限，如有问题或讨论请至blmdz521@126.com并加上前缀[dubbo-demo]，谢谢

<span style="display: block;text-align: right;font-weight: bold;">
--- 千酌一梦醉独殇
</span>


