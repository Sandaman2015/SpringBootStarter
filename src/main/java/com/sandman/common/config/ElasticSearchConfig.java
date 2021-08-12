/*
 * Copyright (C), 2021, com.netease
 * FileName: ElasticSearchConfig
 * Author:   wb.zhangchengwei01
 * Date:     2021/8/5 17:04
 * Description: ElasticSearch配置类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sandman.common.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ElasticSearch配置类
 *
 * @author wb.zhangchengwei01
 * @version 1.0.0
 * @since 2021/8/5
 */
@Configuration
public class ElasticSearchConfig {
    /**
     * @example 127.0.0.1:9200
     */
    @Value("${elasticsearch.hostList}")
    private String hostList;

    /**
     * // 高版本客户端
     *
     * @return RestHighLevelClient
     * @see org.elasticsearch.client
     */
    @Bean
    public RestHighLevelClient restHighLevelClient() {
        // 创建RestHighLevelClient客户端
        return new RestHighLevelClient(RestClient.builder(setClientConnections()));
    }

    /**
     * 项目主要使用 RestHighLevelClient，对于低级的客户端暂时不用
     *
     * @return RestClient
     * @see org.elasticsearch.client
     */
    @Deprecated
    @Bean
    public RestClient restClient() {
        return RestClient.builder(setClientConnections()).build();
    }

    /**
     * ElasticSearch configuration initialize
     *
     * @return HttpHost Array
     * @see org.apache.http.HttpHost
     */
    private HttpHost[] setClientConnections() {
        // 解析 hostList 配置信息。假如以后有多个，则需要用 ， 分开
        String[] split = hostList.split(",");
        // 创建 HttpHost 数组，其中存放es主机和端口的配置信息
        HttpHost[] httpHostArray = new HttpHost[split.length];
        for (int i = 0; i < split.length; i++) {
            String item = split[i];
            httpHostArray[i] = new HttpHost(item.split(":")[0],
                    Integer.parseInt(item.split(":")[1]), "http");
        }
        return httpHostArray;
    }
}
