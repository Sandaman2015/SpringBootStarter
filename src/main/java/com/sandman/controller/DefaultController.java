/*
 * Copyright (C), 2021, com.netease
 * FileName: DefaultController
 * Author:   wb.zhangchengwei01
 * Date:     2021/8/5 18:12
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sandman.controller;

import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author wb.zhangchengwei01
 * @version 1.0.0
 * @since 2021/8/5
 */
@Api(tags = "default-controller")
public interface DefaultController {

    String INDEX = "/index";

    /**
     * 获取消息
     *
     * @return 字符串
     */
    @GetMapping(value = INDEX, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    String getMsg();
}
