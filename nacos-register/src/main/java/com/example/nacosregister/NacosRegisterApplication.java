package com.example.nacosregister;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@Slf4j
@NacosPropertySource(dataId = "nacos-config",autoRefreshed = true)
public class NacosRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosRegisterApplication.class, args);
    }


}
