/*
 * Copyright (C), 2021, com.netease
 * FileName: ResultVO
 * Author:   wb.zhangchengwei01
 * Date:     2021/7/16 15:40
 * Description: 返回ViewModel
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sandman.common.model.dto;

import com.sandman.common.enums.CodeEnum;
import com.sandman.common.enums.ICodeEnum;
import com.sandman.common.util.StringUtils;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 返回ViewModel
 *
 * @param <T> 泛型
 * @author wb.zhangchengwei01
 * @version 1.0.0
 * @since 2021/7/16
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class ResultVO<T> extends RestDTO {
    private static final long serialVersionUID = -7281269010610224891L;
    /**
     * response data
     */
    @ApiModelProperty(
            value = "返回的响应数据",
            required = true
    )
    T data;

    private ResultVO(ICodeEnum codeEnum) {
        super(codeEnum);
    }

    /**
     * ok
     *
     * @param <T> 泛型对象
     * @return 返回
     */
    public static <T> ResultVO<T> ok() {
        return restResult(CodeEnum.SUCCESS, null);
    }

    /**
     * ok
     *
     * @param data 数据对象
     * @param <T>  泛型对象
     * @return 返回
     */
    public static <T> ResultVO<T> ok(T data) {
        return restResult(CodeEnum.SUCCESS, data);
    }


    /**
     * @param data 数据对象
     * @param <T>  泛型对象
     * @return 返回
     */
    public static <T> ResultVO<T> isOkDate(T data) {
        return data != null ? ok(data) : fail((ICodeEnum) CodeEnum.DATA_NOT_FOUND_TRUE);
    }


    /**
     * @param data 数据对象
     * @param <T>  泛型对象
     * @return 返回
     */
    public static <T> ResultVO<List<T>> isOkListDate(List<T> data) {
        return !CollectionUtils.isEmpty(data) ? ok(data) : fail((ICodeEnum) CodeEnum.DATA_NOT_FOUND_TRUE);
    }

    /**
     * @param codeEnum 返回自定义枚举
     * @param <T>      泛型对象
     * @return 返回
     */
    public static <T> ResultVO<T> ok(ICodeEnum codeEnum) {
        return restResult(codeEnum, null);
    }

    /**
     * @param codeEnum 返回自定义枚举
     * @param data     数据对象
     * @param <T>      泛型对象
     * @return 返回
     */
    public static <T> ResultVO<T> ok(ICodeEnum codeEnum, T data) {
        return restResult(codeEnum, data);
    }

    /**
     * fail
     *
     * @param <T> 泛型对象
     * @return 返回
     */
    public static <T> ResultVO<T> fail() {
        return restResult(CodeEnum.FAILED, null);
    }

    /**
     * @param data 数据对象
     * @param <T>  泛型对象
     * @return 返回
     */
    public static <T> ResultVO<T> fail(T data) {
        return restResult(CodeEnum.FAILED, data);
    }

    /**
     * @param codeEnum 返回自定义枚举
     * @param <T>      泛型对象
     * @return 返回
     */
    public static <T> ResultVO<T> fail(ICodeEnum codeEnum) {
        return restResult(codeEnum, null);
    }

    /**
     * @param codeEnum 返回自定义枚举
     * @param data     数据对象
     * @param <T>      泛型对象
     * @return 返回
     */
    public static <T> ResultVO<T> fail(ICodeEnum codeEnum, T data) {
        return restResult(codeEnum, data);
    }

    /**
     * @param data     数据对象
     * @param codeEnum 返回自定义枚举
     * @param params   可变参数
     * @param <T>      泛型对象
     * @return 返回
     */
    public static <T> ResultVO<T> fail(T data, ICodeEnum codeEnum, Object... params) {
        return restResult(codeEnum, data, params);
    }

    /**
     * @param codeEnum 返回自定义枚举
     * @param data     数据对象
     * @param <T>      泛型对象
     * @return 返回
     */
    private static <T> ResultVO<T> restResult(ICodeEnum codeEnum, T data) {
        ResultVO<T> resultVO = new ResultVO<>(codeEnum);
        resultVO.setData(data);
        return resultVO;
    }

    /**
     * @param codeEnum 返回自定义枚举
     * @param data     数据对象
     * @param params   可变参数
     * @param <T>      泛型对象
     * @return 返回
     */
    private static <T> ResultVO<T> restResult(ICodeEnum codeEnum, T data, Object... params) {
        ResultVO<T> resultVO = new ResultVO<>(codeEnum);
        resultVO.setMessage(StringUtils.format(codeEnum, params));
        resultVO.setData(data);
        return resultVO;
    }
}
