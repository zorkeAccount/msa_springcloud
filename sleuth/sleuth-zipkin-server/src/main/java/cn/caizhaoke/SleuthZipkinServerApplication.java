package cn.caizhaoke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.EnableZipkinServer;

@EnableEurekaClient //向eureka服务中心注册服务
@EnableZipkinServer //开启ZipkinServer的功能,收集调用数据并展示
@SpringBootApplication
public class SleuthZipkinServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SleuthZipkinServerApplication.class, args);
    }
}
