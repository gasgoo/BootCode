package com.example.nacosregister;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;


@SpringBootApplication
@RefreshScope
public class NacosRegisterApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext applicationContext=SpringApplication.run(NacosRegisterApplication.class, args);
        while(true){
            String userName = applicationContext.getEnvironment().getProperty("nacos.test.value");
            System.err.println("user name :" +userName);
            TimeUnit.SECONDS.sleep(1);
        }

    }

}
