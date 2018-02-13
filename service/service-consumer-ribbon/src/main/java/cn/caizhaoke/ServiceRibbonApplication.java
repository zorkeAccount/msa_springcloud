package cn.caizhaoke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableHystrix //开启断路器Hystrix
@EnableEurekaClient //向eureka服务注册中心进行注册 或@EnableDiscoveryClient（若非eureka提供注册中心则使用该注解）
@SpringBootApplication
public class ServiceRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRibbonApplication.class, args);
    }

    //向程序的ioc注入一个bean: restTemplate，并通过@LoadBalanced注解表明这个restTemplate开启负载均衡的功能
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
