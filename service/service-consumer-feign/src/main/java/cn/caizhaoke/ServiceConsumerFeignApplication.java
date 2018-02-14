package cn.caizhaoke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableCircuitBreaker //for 仪表盘MonitorStream报错：Unable to connect to Command Metric Stream
@EnableHystrixDashboard //开启Hystrix仪表盘
@EnableFeignClients //开启Feign功能
@EnableEurekaClient //向eureka服务注册中心进行注册 或@EnableDiscoveryClient（若非eureka提供注册中心则使用该注解）
@SpringBootApplication
public class ServiceConsumerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceConsumerFeignApplication.class, args);
    }
}
