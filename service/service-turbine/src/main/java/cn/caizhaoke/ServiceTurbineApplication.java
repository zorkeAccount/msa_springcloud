package cn.caizhaoke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableTurbine //开启turbine，@EnableTurbine注解包含了@EnableDiscoveryClient注解，即已开启了注册服务
@EnableEurekaClient
@SpringBootApplication
public class ServiceTurbineApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceTurbineApplication.class, args);
    }
}
