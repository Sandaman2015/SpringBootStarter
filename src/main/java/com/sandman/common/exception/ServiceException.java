/*
 * Copyright (C), 2021, com.netease
 * FileName: ServiceException
 * Author:   wb.zhangchengwei01
 * Date:     2021/7/16 16:40
 * Description: 通用逻辑异常
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sandman.common.exception;

import com.sandman.common.enums.ICodeEnum;
import lombok.Data;

/**
 * 通用逻辑异常
 *
 * @author wb.zhangchengwei01
 * @version 1.0.0
 * @since 2021/7/16
 */
@Data
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = 7945585257077909607L;

    /**
     * 异常自定义枚举
     */
    private ICodeEnum codeEnum;

    public ServiceException(ICodeEnum codeEnum) {
        super(codeEnum.message());
        this.codeEnum = codeEnum;
    }

    public ServiceException(String message, ICodeEnum codeEnum) {
        super(message);
        this.codeEnum = codeEnum;
    }

    public ServiceException(ICodeEnum codeEnum, String message) {
        super(message);
        this.codeEnum = codeEnum;
    }

    public ServiceException(String message, Throwable cause, ICodeEnum codeEnum) {
        super(message, cause);
        this.codeEnum = codeEnum;
    }

    public ServiceException(Throwable cause, ICodeEnum codeEnum) {
        super(cause);
        this.codeEnum = codeEnum;
    }

    public ServiceException(ICodeEnum codeEnum, Object value) {
//        super(message);
        this.codeEnum = codeEnum;
    }

    public ServiceException(
            String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace, ICodeEnum codeEnum) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.codeEnum = codeEnum;
    }

}