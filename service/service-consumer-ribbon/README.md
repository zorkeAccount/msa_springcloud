# service-consumer-ribbon
* service-consumer-ribbon是一个服务消费者，对eureka-client提供的服务进行消费，一种ribbon+restTemplate的服务调用方式

* 在启动service-consumer-ribbon应用之前，先启动eureka-register应用，并且分别在8762和8763两个端口上启动应用eureka-client的两个实例

* 浏览器中多次访问[http://localhost:8764/hi?name=czk](http://localhost:8764/hi?name=czk)，会发现端口号8762和8763交替显示

### 项目说明
1. 一个服务注册中心，eureka server,端口为8761
2. eureka-client工程跑了两个实例，端口分别为8762,8763，分别向服务注册中心注册,并作为服务提供者对service-consumer-ribbon提供服务
3. service-consumer-ribbon端口为8764,向服务注册中心注册，并作为服务消费者调用eureka-client中的服务
4. service-consumer-ribbon通过restTemplate调用service-consumer-ribbon的hi接口时，因为用ribbon进行了负载均衡，会轮流的调用service-consumer-ribbon：8762和8763 两个端口的hi接口

### 工程创建过程
右键service工程->new model-> 选择spring initializr -> 填好基本pom信息 -> 选择Eureka Discovery 和 Ribbon -> Finish

#### 官方文档
* [spring-cloud-ribbon](http://projects.spring.io/spring-cloud/spring-cloud.html#spring-cloud-ribbon)
* [circuit_breaker_hystrix_dashboard](http://projects.spring.io/spring-cloud/spring-cloud.html#_circuit_breaker_hystrix_dashboard)
* [circuit_breaker_hystrix_clients](http://projects.spring.io/spring-cloud/spring-cloud.html#_circuit_breaker_hystrix_clients)



