# zuul
* 在SpringCloud微服务系统中，一种常见的负载均衡方式是：客户端的请求首先经过负载均衡（zuul、Ngnix），再到达服务
网关（zuul集群），然后再到具体的服务；

* 服务统一注册到高可用的服务注册中心集群，服务的所有的配置文件由配置服务管理，配置服务的配置文件放在git仓库，方便开发人员随时改配置

* 浏览器中分别访问[http://localhost:8769/api-a/hi?name=zorke](http://localhost:8769/api-a/hi?name=zorke)，以及
[http://localhost:8769/api-a/hi?name=zorke&token=22](http://localhost:8769/api-a/hi?name=zorke&token=22)，（过滤功能）

* 或者（路由功能）：浏览器中分别访问[http://localhost:8769/api-b/hi?name=zorke](http://localhost:8769/api-b/hi?name=zorke)，以及
[http://localhost:8769/api-b/hi?name=zorke&token=22](http://localhost:8769/api-b/hi?name=zorke&token=22)

### 项目说明
Zuul的主要功能是路由转发和过滤器。路由功能是微服务的一部分，比如/api/user转发到到user服务，/api/shop转发
到shop服务,zuul默认和Ribbon结合实现了负载均衡的功能

### 工程创建过程
右键service工程->new model-> 选择spring initializr -> 填好基本pom信息 -> 选择Eureka Discovery 和 Zuul -> Finish

#### 官方文档
* [router_and_filter_zuul](http://projects.spring.io/spring-cloud/spring-cloud.html#_router_and_filter_zuul)



