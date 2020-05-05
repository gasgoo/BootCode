package com.api.register.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Date 2020/4/22 11:09
 * @name IndexContrller
 */

@RestController
@RefreshScope
public class IndexContrller {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    ServerProperties serverProperties;

    @Value("${user.name}")
    private String name;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return "hello ComApplication--"+name;
    }

    /**
     * @Description  ribbon使用案例
     * @Date 2020/4/27 18:24
     **/
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        log.info("port:{}",serverProperties.getPort());
       return restTemplate.getForObject("http://nacos-register/queryConfig",String.class);
    }

}
