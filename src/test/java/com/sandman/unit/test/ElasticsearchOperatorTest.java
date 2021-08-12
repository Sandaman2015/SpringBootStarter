/*
 * Copyright (C), 2021, com.netease
 * FileName: ElasticsearchOperatorTest
 * Author:   wb.zhangchengwei01
 * Date:     2021/8/5 17:13
 * Description: ElasticSearch操作类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sandman.unit.test;

import com.sandman.boot.SpringBootDeepInApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * ElasticSearch操作类
 *
 * @author wb.zhangchengwei01
 * @version 1.0.0
 * @since 2021/8/5
 */
@Slf4j
@ActiveProfiles(profiles ="spring.profiles.active: test" )
@TestPropertySource(properties = "spring.profiles.active: test")
@EnableAutoConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringBootDeepInApplication.class)
public class ElasticsearchOperatorTest {

    @Test
    public void testMain(){
        System.out.println("this test println!");
    }
}
