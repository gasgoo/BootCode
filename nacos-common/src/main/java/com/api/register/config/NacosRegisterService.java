package com.api.register.config;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @Date 2020/4/16 14:22
 * @name DiscoveryApp
 */


@Component
@Slf4j
public class NacosRegisterService {


    @NacosInjected
    private NamingService namingService;

    @Value("${server.port}")
    private int serverPort;

    @Value("${spring.application.name}")
    private String serverNme;

    /**
     * @Description  也可以访问这个接口地址注册 curl -X PUT 'http://127.0.0.1:8848/nacos/v1/ns/instance?serviceName=example&ip=127.0.0.1&port=8080'
     * @Date 2020/4/16 14:58
     **/
    @PostConstruct
    public void registerInstance() throws NacosException {
        log.info("nacos服务注册>>>start"+serverNme+":"+serverPort );
        namingService.registerInstance(serverNme,"127.0.0.1",serverPort);
    }

    public List<Instance> getInstance(String serviceName) throws NacosException {
        return namingService.getAllInstances(serviceName);
    }



}
