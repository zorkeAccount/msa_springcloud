# msa_springcloud
基于springcloud的微服务化实践，基础架构

* eureka-register<br>
&nbsp;&nbsp;eureka服务注册中心

* service-provider<br>
&nbsp;&nbsp;向eurka服务注册中心进行注册的客户端，且为service-consumer-ribbon提供服务

* service-consumer-ribbon<br>
&nbsp;&nbsp;向eurka服务注册中心进行注册的客户端，且调用service-provider中的服务，基于ribbon+restTemplate的服务调用方式

* service-consumer-feign<br>
&nbsp;&nbsp;向eurka服务注册中心进行注册的客户端，且调用service-provider中的服务，基于feign的服务调用方式

#### 注意：
1. 注册服务的注解：spring cloud中discovery service有许多种实现（eureka、consul、zookeeper等等），@EnableDiscoveryClient基于
spring-cloud-commons, @EnableEurekaClient基于spring-cloud-netflix。简单地说，就是如果选用的注册中心是eureka，
那么推荐使用@EnableEurekaClient，如果是其他的注册中心就使用@EnableDiscoveryClient

2. 启动顺序：<br>
eureka-register:[http://localhost:8761](http://localhost:8761)<br>
service-provider:[http://localhost:8762/hi?name=zorke](http://localhost:8762/hi?name=zorke)<br>
service-provider:[http://localhost:8763/hi?name=zorke](http://localhost:8763/hi?name=zorke)<br>
service-consumer-ribbon:[http://localhost:8764/hi?name=zorke](http://localhost:8764/hi?name=zorke)<br>
service-consumer-feign:[http://localhost:8765/hi?name=zorke](http://localhost:8765/hi?name=zorke)<br>
