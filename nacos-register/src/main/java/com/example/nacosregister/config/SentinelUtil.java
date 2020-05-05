package com.example.nacosregister.config;

import com.alibaba.csp.sentinel.datasource.ReadableDataSource;
import com.alibaba.csp.sentinel.datasource.WritableDataSource;
import com.alibaba.csp.sentinel.datasource.nacos.NacosDataSource;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.csp.sentinel.transport.util.WritableDataSourceRegistry;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.nacos.api.exception.NacosException;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 sentinel监控规则持久化的类 配置规则保存到nacos配置中心
 */
@Component
public class SentinelUtil {

    //读取sentinel添加的配置然后写道nacos中
    @PostConstruct
    public void init() throws NacosException {
        System.out.println("-------------init-----------");
        String serverAddr = "localhost:8848";
        String dataId = "sentinelConfig";
        String group = "DEFAULT_GROUP";

        ReadableDataSource<String, List<FlowRule>> flowRuleDataSource = new NacosDataSource<>(serverAddr, group, dataId,
                source -> JSON.parseObject(source, new TypeReference<List<FlowRule>>() {
                }));
        FlowRuleManager.register2Property(flowRuleDataSource.getProperty());

        WritableDataSource writableDataSource = new WriteableNacos<List<FlowRule>>();
        WritableDataSourceRegistry.registerFlowDataSource(writableDataSource);
    }
}