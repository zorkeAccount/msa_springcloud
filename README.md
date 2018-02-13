# msa_springcloud
基于springcloud的微服务化实践，基础架构

* eureka-register<br>
&nbsp;&nbsp;eureka服务注册中心

* service-provider<br>
&nbsp;&nbsp;向eurka服务注册中心进行注册的客户端，且为service-ribbon提供服务

* service-ribbon<br>
&nbsp;&nbsp;向eurka服务注册中心进行注册的客户端，且调用eureka-client中的服务

#### 注意：
1. 注册服务的注解：spring cloud中discovery service有许多种实现（eureka、consul、zookeeper等等），@EnableDiscoveryClient基于
spring-cloud-commons, @EnableEurekaClient基于spring-cloud-netflix。简单地说，就是如果选用的注册中心是eureka，
那么推荐使用@EnableEurekaClient，如果是其他的注册中心就使用@EnableDiscoveryClient