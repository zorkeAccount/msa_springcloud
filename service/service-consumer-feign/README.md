# service-consumer-feign
* service-consumer-feign是一个服务消费者，对eureka-client提供的服务进行消费，一种基于Feign的服务调用方式

* Feign是一个声明式的伪Http客户端：采用的是基于接口的注解（Feign 注解和JAX-RS注解），默认集成了ribbon，并和Eureka结合，默认实现了负载均衡的效果

* 在启动service-consumer-feign应用之前，先启动eureka-register应用，并且分别在8762和8763两个端口上启动应用eureka-client的两个实例

* 浏览器中多次访问[http://localhost:8765/hi?name=czk](http://localhost:8765/hi?name=czk)，会发现端口号8762和8763交替显示

* 浏览器中访问断路器的仪表盘[http://localhost:8765/hystrix](http://localhost:8765/hystrix)，输入http://localhost:8765/hystrix.stream点击Monitor Stream进行监控；
或者浏览器中直接访问http://localhost:8764/hystrix.stream可查看到具体的数据

### 项目说明
1. 一个服务注册中心，eureka server,端口为8761
2. eureka-client工程跑了两个实例，端口分别为8762,8763，分别向服务注册中心注册,并作为服务提供者对service-consumer-feign提供服务
3. service-consumer-feign端口为8765,向服务注册中心注册，并作为服务消费者调用eureka-client中的服务
4. service-consumer-feign通过restTemplate调用service-consumer-feign的hi接口时，因为用ribbon进行了负载均衡，会轮流的调用service-consumer-feign：8762和8763 两个端口的hi接口

### 工程创建过程
右键service工程->new model-> 选择spring initializr -> 填好基本pom信息 -> 选择Eureka Discovery 和 Feign -> Finish

#### 官方文档
* [spring-cloud-feign](http://projects.spring.io/spring-cloud/spring-cloud.html#spring-cloud-feign)
* [circuit_breaker_hystrix_dashboard](http://projects.spring.io/spring-cloud/spring-cloud.html#_circuit_breaker_hystrix_dashboard)
* [circuit_breaker_hystrix_clients](http://projects.spring.io/spring-cloud/spring-cloud.html#_circuit_breaker_hystrix_clients)



