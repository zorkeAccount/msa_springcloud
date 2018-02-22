# config-server
对于git仓库中配置文件*.yml若添加了注释，且项目启动后访问该文件的属性值时报异常：
Caused by: org.yaml.snakeyaml.error.YAMLException: java.nio.charset.MalformedInputException: Input length = 1
可以将文件中的注释内容删掉，再启动，这是由于YMAL的语法校验比较严格

### 项目说明
http请求地址和资源文件映射如下:
* http请求：/{application}/{profile}[/{label}]
* 资源文件：/{application}-{profile}.yml
* 资源文件：/{label}/{application}-{profile}.yml
* 资源文件：/{application}-{profile}.properties
* 资源文件：/{label}/{application}-{profile}.properties

* 在msa_springcloud_configfiles\respo下面添加test-dev.properties文件，访问[http://localhost:8888/test/dev](http://localhost:8888/test/dev)
可查看该文件中的属性！！

* 在msa_springcloud_configfiles\respo下面添加zuul-dev.yml文件，访问[http://localhost:8888/zuul/dev](http://localhost:8888/zuul/dev)
可查看该文件中的属性,也即将设置为zuul工程的配置文件放置在此

* 注意yml文件的字符格式是否是UTF-8，以及如果有注释的话可能会报异常！！！！

* rabbitmq消息总线刷新配置文件：修改msa_springcloud_configfiles\respo\test-dev.properties文件后提交，-> 访问/test/dev值并未改变（其实改变了！！）
-> http://localhost:8888/bus/refresh【?destination=configClient:2008可指定需要更新的实例】,Config-Server收到通知之后，就会广播配置文件改变的消息 -> 此时就能看得到修改后的配置文件


### 工程创建过程
右键service工程->new model-> 选择spring initializr -> 填好基本pom信息 -> 选择Eureka Discovery 和 Config Server -> Finish

#### 官方文档
* [spring_cloud_config](http://projects.spring.io/spring-cloud/spring-cloud.html#_spring_cloud_config)



