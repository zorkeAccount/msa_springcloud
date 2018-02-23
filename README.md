# msa_springcloud
基于springcloud的微服务化实践，基础架构

* eureka-register<br>
&nbsp;&nbsp;eureka服务注册中心，采用配置多个实例集群方式实现高可用性，Eureka-eserver peer1 8761,Eureka-eserver peer2 8760
相互感应，当有服务注册时，两个Eureka-eserver是对等的，它们都存有相同的信息，这就是通过服务器的冗余来增加可靠性，当有一台
服务器宕机了，服务并不会终止，因为另一台服务存有相同的数据

* service-provider<br>
&nbsp;&nbsp;向eurka服务注册中心进行注册的客户端，且为service-consumer-ribbon提供服务

* config-server<br>
&nbsp;&nbsp;配置文件管理服务

* service-provider<br>
&nbsp;&nbsp;向eurka服务注册中心进行注册的客户端，提供相关的功能服务

* service-consumer-ribbon<br>
&nbsp;&nbsp;向eurka服务注册中心进行注册的客户端，且调用service-provider中的服务，基于ribbon+restTemplate的服务调用方式
* service-consumer-feign<br>
&nbsp;&nbsp;向eurka服务注册中心进行注册的客户端，且调用service-provider中的服务，基于feign的服务调用方式
* service-turbine<br>
&nbsp;&nbsp;对service-consumer-ribbon和service-consumer-feign两个的断路器监控流进行聚合到http://localhost:8901/turbine.stream中

* zuul-api<br>
&nbsp;&nbsp;网关路由和过滤器功能

* sleuth-zipkin-server<br>
&nbsp;&nbsp;服务调用链路追踪

#### 注意：
1. 注册服务的注解：spring cloud中discovery service有许多种实现（eureka、consul、zookeeper等等），@EnableDiscoveryClient基于
spring-cloud-commons, @EnableEurekaClient基于spring-cloud-netflix。简单地说，就是如果选用的注册中心是eureka，
那么推荐使用@EnableEurekaClient，如果是其他的注册中心就使用@EnableDiscoveryClient

2. 在访问zipkin管理页面的时候，在执行查找前一定要仔细看清楚结束时间，而且不要通过浏览器的刷新按钮进行刷新，这是因为浏览器中的url地址
中/?后面的参数值并未改变，导致刷新不出来最新的服务调用链路信息，应该直接重新访问http://localhost:9411/zipkin/；；此外，并不是所有的服务调用链路均会被zipkin收集到的

3. 启动顺序：<br>
eureka-register:[http://localhost:8761](http://localhost:8761)，启动方式java -jar eureka-register-1.0.0.jar --spring.profiles.active=peer1<br>
eureka-register:[http://localhost:8760](http://localhost:8760)，启动方式java -jar eureka-register-1.0.0.jar --spring.profiles.active=peer2<br>
<br>
sleuth-zipkin-server:[http://localhost:9411/zipkin/](http://localhost:9411/zipkin/) 点击“查找”可以查看服务调用链-可先访问zuul-api
再查看，实际显示的时间略微延迟滞后些<br>
<br>
config-server:[http://localhost:8888/test/dev](http://localhost:8888/test/dev)<br>
<br>
service-provider:[http://localhost:8762/hi?name=zorke](http://localhost:8762/hi?name=zorke)，启动方式java -jar service-provider-1.0.0.jar<br>
service-provider:[http://localhost:8763/hi?name=zorke](http://localhost:8763/hi?name=zorke)，启动方式java -jar service-provider-1.0.0.jar --server.port=8763<br>
<br>
service-consumer-ribbon:[http://localhost:8764/hi?name=zorke](http://localhost:8764/hi?name=zorke)<br>
service-consumer-feign:[http://localhost:8765/hi?name=zorke](http://localhost:8765/hi?name=zorke)<br>
<br>
zuul-api:[http://localhost:8769/api-a/hi?name=zorke&token=22](http://localhost:8769/api-a/hi?name=zorke&token=22)<br>
<br>

