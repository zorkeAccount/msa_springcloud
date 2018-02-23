# service-turbine
* 单个的HystrixDashboard的数据并没有什么多大的价值，要想看整个系统的HystrixDashboard数据就需要用到HystrixTurbine

* HystrixTurbine将每个服务HystrixDashboard的数据进行了整合，对所有服务的数据进行聚合展示

* 浏览器中打开任意一个断路器的如仪表盘[http://localhost:8764/hystrix](http://localhost:8764/hystrix)或者[http://localhost:8765/hystrix](http://localhost:8765/hystrix)，输入监控流http://localhost:8901/turbine.stream
点击MonitorStream进行监控；或者浏览器中直接访问http://localhost:8901/turbine.stream可查看到具体的数据

#### 工程创建过程
右键service工程->new model-> 选择spring initializr -> 填好基本pom信息 -> 选择turbine -> Finish

#### 官方文档
* [turbine](http://projects.spring.io/spring-cloud/spring-cloud.html#_turbine)

