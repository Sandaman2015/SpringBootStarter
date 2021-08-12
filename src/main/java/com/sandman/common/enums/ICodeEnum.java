/*
 * Copyright (C), 2021, com.netease
 * FileName: ICodeEnum
 * Author:   wb.zhangchengwei01
 * Date:     2021/7/16 15:18
 * Description: enum extend interface
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sandman.common.enums;

/**
 * enum extend interface
 *
 * @author wb.zhangchengwei01
 * @version 1.0.0
 * @since 2021/7/16
 */
public interface ICodeEnum {
    /**
     * return user-defined code
     *
     * @return code
     */
    String code();

    /**
     * return user-defined message
     *
     * @return message
     */
    String message();

    /**
     * return is success request
     *
     * @return true or false
     */
    Boolean success();
}
