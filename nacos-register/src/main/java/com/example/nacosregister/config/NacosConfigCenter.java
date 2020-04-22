package com.example.nacosregister.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 读取nacos配置中心的value
 * @Date 2020/4/16 15:06
 * @name NacosConfigCenter
 */

@RefreshScope
@Getter
@Component
public class NacosConfigCenter {

    @Value(value = "${nacos.test.value}")
    private String testValue;

}
