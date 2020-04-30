package com.example.nacosregister.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.example.nacosregister.config.NacosConfigCenter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2020/4/16 14:41
 * @name nacosController
 */

@RestController
@Slf4j
public class NacosController {


    @Autowired
    private NacosConfigCenter nacosConfigCenter;

    @Autowired
    private ServerProperties serverProperties;

    @GetMapping(value = "/queryConfig")
    public String query(){
        log.info("读取的配置中心的value:"+nacosConfigCenter.getTestValue());
        System.out.println(Thread.currentThread().getName());
        return nacosConfigCenter.getTestValue()+":"+serverProperties.getPort();
    }

    @RequestMapping(value="/sentinel")
    @SentinelResource("sentinel")
    public String index(){
        return "hello sentinel";
    }
}
