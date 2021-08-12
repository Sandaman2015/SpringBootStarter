/*
 * Copyright (C), 2021, com.netease
 * FileName: ResultPageVO
 * Author:   wb.zhangchengwei01
 * Date:     2021/7/16 16:20
 * Description: 分页返回对象
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sandman.common.model.dto;

import com.sandman.common.enums.CodeEnum;
import com.sandman.common.enums.ICodeEnum;
import com.sandman.common.util.StringUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 分页返回对象
 *
 * @param <T> 泛型对象 泛型参数
 * @author wb.zhangchengwei01
 * @version 1.0.0
 * @since 2021/7/16
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class ResultPageVO<T> extends RestDTO {
    private static final long serialVersionUID = -5619223391534235352L;
    /**
     * 返回的响应数据
     */
    @ApiModelProperty(
            value = "返回的响应数据",
            required = true
    )
    T data;
    /**
     * 总记录数
     */
    @ApiModelProperty(
            value = "总记录数",
            required = true
    )
    private Long total;
    /**
     * 当前页的记录数
     */
    @ApiModelProperty(
            value = "当前页的记录数",
            required = true
    )
    private Long pageSize;
    /**
     * 当前页号
     */
    @ApiModelProperty(
            value = "当前页号",
            required = true
    )
    private Long pageIndex;

    private ResultPageVO(ICodeEnum codeEnum) {
        super(codeEnum);
    }

    /**
     * 
     * @param <T> 泛型对象
     * @return 返回
     */
    public static <T> ResultPageVO<T> ok() {
        return resultPageVO(CodeEnum.SUCCESS, null, null);
    }

    /**
     * 
     * @param data 返回数据
     * @param page 分页数据
     * @param <T> 泛型对象
     * @return 返回
     */
    public static <T> ResultPageVO<T> ok(T data, IPage page) {
        return resultPageVO(CodeEnum.SUCCESS, data, page);
    }

    /**
     * 
     * @param data 返回数据
     * @param page 分页数据
     * @param <T> 泛型对象
     * @return 返回
     */
    public static <T> ResultPageVO<List<T>> isOkDate(List<T> data, IPage page) {
        return !CollectionUtils.isEmpty(data) ? ok(data, page) : fail(CodeEnum.DATA_NOT_FOUND_TRUE);
    }

    /**
     * 
     * @param codeEnum 自定义枚举
     * @param data 返回数据
     * @param page 分页数据
     * @param <T> 泛型对象
     * @return 返回
     */
    public static <T> ResultPageVO<T> ok(ICodeEnum codeEnum, T data, IPage page) {
        return resultPageVO(codeEnum, data, page);
    }

    /**
     * 
     * @param <T> 泛型对象
     * @return 返回
     */
    public static <T> ResultPageVO<T> fail() {
        return resultPageVO(CodeEnum.FAILED, (Object) null, null);
    }

    /**
     * 
     * @param codeEnum 自定义枚举
     * @param <T> 泛型对象
     * @return 返回
     */
    public static <T> ResultPageVO<T> fail(ICodeEnum codeEnum) {
        return resultPageVO(codeEnum, (Object) null, null);
    }

    /**
     * 
     * @param data 返回数据
     * @param page 分页数据
     * @param <T> 泛型对象
     * @return 返回
     */
    public static <T> ResultPageVO<T> fail(T data, IPage page) {
        return resultPageVO(CodeEnum.FAILED, data, page);
    }

    /**
     * 
     * @param codeEnum 自定义枚举
     * @param data 返回数据
     * @param page 分页数据
     * @param <T> 泛型对象
     * @return 返回
     */
    public static <T> ResultPageVO<T> fail(ICodeEnum codeEnum, T data, IPage page) {
        return resultPageVO(codeEnum, data, page);
    }

    /**
     * 
     * @param codeEnum 自定义枚举
     * @param data 返回数据
     * @param page 分页数据
     * @param <T> 泛型对象
     * @return 返回
     */
    private static <T> ResultPageVO resultPageVO(ICodeEnum codeEnum, T data, IPage page) {
        ResultPageVO<T> resultPageVO = new ResultPageVO<>(codeEnum);
        resultPageVO.setData(data);
        resultPageVO.setPageInfo(page);
        return resultPageVO;
    }

    /**
     * @param pageInfo 分页数据
     */
    private void setPageInfo(IPage pageInfo) {
        if (StringUtils.isNotNull(pageInfo)) {
            this.setTotal(pageInfo.getTotal());
            this.setPageIndex(pageInfo.getCurrent());
            this.setPageSize(pageInfo.getSize());
        }

    }
}
