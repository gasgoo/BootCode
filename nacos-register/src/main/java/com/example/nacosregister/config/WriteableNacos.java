package com.example.nacosregister.config;

import com.alibaba.csp.sentinel.datasource.WritableDataSource;
import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import lombok.extern.slf4j.Slf4j;

/**
 * 把配置写入nacos中
 */
@Slf4j
public class WriteableNacos<T> implements WritableDataSource<T> {
    @Override
    public void write(T value) throws Exception {
        System.out.println("-------------write to nacos-----------");
        String s = JSON.toJSONString(value);
        System.out.println(s);
        String serverAddr = "localhost:8848";
        String dataId = "sentinelConfig";
        String group = "DEFAULT_GROUP";
        ConfigService configService = NacosFactory.createConfigService(serverAddr);
        boolean isPublishOk = configService.publishConfig(dataId, group, s);
        log.info("add config to nacos result: " + isPublishOk);
    }

    @Override
    public void close() throws Exception {

    }
}
