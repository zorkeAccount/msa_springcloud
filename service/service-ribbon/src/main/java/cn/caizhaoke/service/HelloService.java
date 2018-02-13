package cn.caizhaoke.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 测试类HelloService，通过之前注入ioc容器的restTemplate来消费service-hi服务的“/hi”接口
 *
 * @author zhaoke
 *         Created on 2018/2/13.
 */
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    public String hiService(String name) {
        //这里直接用程序名替代了具体的url地址,ribbon会根据服务名来选择具体的服务实例，根据服务实例在请求时用具体url替换服务名
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
        //浏览器中多次访问http://localhost:8764/hi?name=czk，会发现浏览器中显示的端口号会是8762和8763交替显示
        //=>通过调用restTemplate.getForObject(“http://SERVICE-HI/hi?name=“+name,String.class)方法时，已经做了负载均衡，访问了不同的端口的服务实例
    }
}
