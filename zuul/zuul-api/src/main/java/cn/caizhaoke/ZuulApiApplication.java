package cn.caizhaoke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy //开启zuul功能：路由转发&过滤器
@EnableEurekaClient //向eureka服务注册中心进行注册 或@EnableDiscoveryClient（若非eureka提供注册中心则使用该注解）
@SpringBootApplication
public class ZuulApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApiApplication.class, args);
    }
}
