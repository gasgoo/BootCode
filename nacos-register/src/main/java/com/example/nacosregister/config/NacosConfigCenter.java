package com.example.nacosregister.config;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import lombok.Getter;
import org.springframework.stereotype.Component;

/**
 * 读取nacos配置中心的value
 * @Date 2020/4/16 15:06
 * @name NacosConfigCenter
 */

//@Component
@Getter
public class NacosConfigCenter {

    @NacosValue(value = "${nacos.test.value}",autoRefreshed = true)
    private String testValue;

}
