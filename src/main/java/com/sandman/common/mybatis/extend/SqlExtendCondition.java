/*
 * Copyright (C), 2021, com.netease
 * FileName: SqlExtendCondition
 * Author:   wb.zhangchengwei01
 * Date:     2021/7/16 15:25
 * Description: 基于注解的SQL特殊字符处理
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sandman.common.mybatis.extend;

/**
 * 基于注解的SQL特殊字符处理
 *
 * @author wb.zhangchengwei01
 * @version 1.0.0
 * @since 2021/7/16
 */
public class SqlExtendCondition {
    /**
     * greater than
     */
    public static final String GEQ = "%s&gt;#{%s}";

    /**
     * greater than and equals
     */
    public static final String GEQ_EQUAL = "%s&gt;=#{%s}";

    /**
     * less than
     */
    public static final String LESS = "%s&lt;#{%s}";

    /**
     * less than and equals
     */
    public static final String LESS_EQUAL = "%s&lt;=#{%s}";
}
