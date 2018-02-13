package cn.caizhaoke.hystric;

import cn.caizhaoke.interfaces.HelloService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhaoke
 *         Created on 2018/2/13.
 */
@Component
public class HelloServiceHiHystric implements HelloService {
    @Override
    public String sayHiFromClientOne(@RequestParam(value = "name") String name) {
        return "sorry " + name + " from the service-consumer-feign!";
    }
}
