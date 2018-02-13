package cn.caizhaoke.controller;

import cn.caizhaoke.interfaces.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaoke
 *         Created on 2018/2/13.
 */
@RestController
public class HelloControler {
    @Autowired
    HelloService helloService;

    @RequestMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        return helloService.sayHiFromClientOne(name);
    }

}
