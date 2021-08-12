/*
 * Copyright (C), 2021, com.netease
 * FileName: IBaseEnum
 * Author:   wb.zhangchengwei01
 * Date:     2021/7/16 15:11
 * Description: Mybatis的通用枚举封装
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sandman.common.enums;

import com.baomidou.mybatisplus.annotation.IEnum;

import java.io.Serializable;

/**
 * Mybatis的通用枚举封装〉<br>
 *
 * @param <T> extends genericity
 * @author wb.zhangchengwei01
 * @version 1.0.0
 * @since 2021/7/16
 */
public interface IBaseEnum<T extends Serializable> extends IEnum<T> {
    /**
     * get enums description
     *
     * @return description
     */
    String getDesc();

    /**
     * get enum name
     *
     * @return name
     */
    String getName();
}
