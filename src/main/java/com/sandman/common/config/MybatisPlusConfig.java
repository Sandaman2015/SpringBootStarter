/*
 * Copyright (C), 2021, com.netease
 * FileName: MybatisPlusConfig
 * Author:   wb.zhangchengwei01
 * Date:     2021/7/16 14:47
 * Description: mybatis配置文件
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sandman.common.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈一句话功能简述〉<br>
 * 〈mybatis配置文件〉
 *
 * @author wb.zhangchengwei01
 * @version 1.0.0
 * @since 2021/7/16
 */
@Configuration
@MapperScan({MybatisPlusConfig.SOURCE_DAO_PACKAGE})
public class MybatisPlusConfig {

    /**
     * package scan address
     */
    public static final String SOURCE_DAO_PACKAGE = "com.sandman.mapper";


    /**
     * 分页插件
     * 新的分页插件,一缓和二缓遵循mybatis的规则,
     * 需要设置 MybatisConfiguration#useDeprecatedExecutor = false 避免缓存出现问题
     *
     * @return 分页拦截器
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //分页插件
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        //防止全表更新与删除
        interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());
        return interceptor;
    }

    /**
     * 设置useDeprecatedExecutor值,虽setUseDeprecatedExecutor
     * 会随着 #com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor 插件的移除而移除，
     * 但此处还需要进行设置
     *
     * @return ConfigurationCustomizer
     */
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> configuration.setUseDeprecatedExecutor(false);
    }
}
