# eurekaclient
* Eureka&nbsp;Client是一个服务提供者，并且需要向Eureka&nbsp;Server进行注册，注册时会提供一些元数据，例如主机地址、端口、
URL、主页等；Euraka&nbsp;从每个client实例接收心跳消息，如果心跳超时，则通常将该实例从注册中心server中删除

* 通过注解@EnableEurekaClient开启向erueka&nbsp;server进行注册，同时在配置文件中配置serviceUrl服务注册中心的地址

* 启动工程可访问示例api地址：[http://localhost:8762/hi?name=zorke](http://localhost:8762/hi?name=zorke)


# 官方文档
* [service_discovery_eureka_clients](http://projects.spring.io/spring-cloud/spring-cloud.html#_service_discovery_eureka_clients)