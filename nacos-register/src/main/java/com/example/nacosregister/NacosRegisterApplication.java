package com.example.nacosregister;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@Slf4j
//@NacosPropertySource(dataId = "nacos-config",autoRefreshed = true)
public class NacosRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosRegisterApplication.class, args);
    }

}
