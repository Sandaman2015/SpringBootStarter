/*
 * Copyright (C), 2021, com.netease
 * FileName: CodeEnum
 * Author:   wb.zhangchengwei01
 * Date:     2021/7/16 15:42
 * Description: 枚举对象
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sandman.common.enums;

/**
 * 枚举对象
 *
 * @author wb.zhangchengwei01
 * @version 1.0.0
 * @since 2021/7/16
 */
public enum CodeEnum implements ICodeEnum {
    /**
     * 操作成功
     */
    SUCCESS(true, "200", "操作成功"),
    /**
     * 操作失败
     */
    FAILED(false, "500", "操作失败"),
    /**
     * 数据不存在
     */
    DATA_NOT_FOUND(false, "1001", "数据不存在"),
    /**
     * 数据不存在
     */
    DATA_NOT_FOUND_TRUE(true, "1001", "数据不存在"),
    /**
     * 数据删除失败
     */
    DELETE_FAILED(false, "1002", "数据删除失败"),
    /**
     * 数据新增失败
     */
    INSERT_FAILED(false, "1003", "数据新增失败"),
    /**
     * 数据更新失败
     */
    UPDATE_FAILED(false, "1004", "数据更新失败"),
    /**
     * 接口访问超时
     */
    SOCKET_TIMEOUT(false, "1005", "接口访问超时"),
    /**
     * 用户对象获取失败
     */
    CACHE_GET_ERROR(false, "1103", "用户对象获取失败，请确定用户信息存在！"),
    /**
     * 参数异常
     */
    PARAMS_ERROR(false, "1999", "参数异常"),
    /**
     * 服务器返回异常
     */
    UNKNOWN_ERROR(false, "2000", "服务器返回异常，请重试或联系管理员!");

    /**
     * success
     */
    private Boolean success;
    /**
     * code
     */
    private String code;
    /**
     * message
     */
    private String message;

    /**
     * constructor
     *
     * @param success success
     * @param code    code
     * @param message message
     */
    CodeEnum(Boolean success, String code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public Boolean success() {
        return this.success;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String message() {
        return this.message;
    }
}
