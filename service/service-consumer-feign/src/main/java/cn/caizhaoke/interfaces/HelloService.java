package cn.caizhaoke.interfaces;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 定义一个feign接口，通过@ FeignClient（“服务名”），来指定调用哪个服务
 *
 * @author zhaoke
 *         Created on 2018/2/13.
 */
@FeignClient(value = "service-provider")
public interface HelloService {

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

}
