# register-center: eureka server
* Eureka&nbsp;Server是一个服务注册中心，一个高可用的组件，没有后端缓存，每一个实例注册之后需要向注册中心发送心跳（也即可以
在内存中完成）

* 默认情况下eureka&nbsp;server也是一个eureka&nbsp;client，必须要指定一个server，通常通过配置项
eureka.client.registerWithEureka：false和fetchRegistry：false来表明自己是一个eureka&nbsp;server<

* 启动工程访问[http://localhost:8761](http://localhost:8761)，即可访问注册中心管理页面

### 工程创建过程
右键eureka工程->new model-> 选择spring initializr -> 填好基本pom信息 -> 选择Eureka Server -> Finish

### 官方文档
* [spring-cloud-eureka-server](http://projects.spring.io/spring-cloud/spring-cloud.html#spring-cloud-eureka-server)
* [high_availability_zones_and_regions](http://projects.spring.io/spring-cloud/spring-cloud.html#_high_availability_zones_and_regions)