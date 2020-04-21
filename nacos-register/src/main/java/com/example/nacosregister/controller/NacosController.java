package com.example.nacosregister.controller;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.pojo.Instance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Date 2020/4/16 14:41
 * @name nacosController
 */

@RestController
@Slf4j
public class NacosController {



    @RequestMapping(value = "/getInstance", method= RequestMethod.GET)
    public List<Instance> getInstance(@RequestParam String serviceName) throws NacosException {

        return null;
    }

   /* @RequestMapping(value = "/queryConfig",method = RequestMethod.GET)
    public String query(){
        log.info("读取的配置中心的value:"+nacosConfigCenter.getTestValue());
        return nacosConfigCenter.getTestValue();
    }*/
}
