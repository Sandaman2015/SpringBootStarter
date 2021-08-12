/*
 * Copyright (C), 2021, com.netease
 * FileName: DefaultController
 * Author:   wb.zhangchengwei01
 * Date:     2021/8/5 18:11
 * Description: 默认控制器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sandman.controller.impl;

import com.sandman.controller.DefaultController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

/**
 * 默认控制器
 *
 * @author wb.zhangchengwei01
 * @version 1.0.0
 * @since 2021/8/5
 */
@Slf4j
@RestController
public class DefaultControllerImpl implements DefaultController {

    @Override
    public String getMsg(){
        return "Ok";
    }
}
