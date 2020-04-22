package com.api.register.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 2020/4/22 11:09
 * @name IndexContrller
 */

@Slf4j
@RestController
@RefreshScope
public class IndexContrller {

    @Value("${user.name}")
    private String name;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return "hello ComApplication--"+name;
    }
}
