/*
 * Copyright (C), 2021, com.netease
 * FileName: PageQuery
 * Author:   wb.zhangchengwei01
 * Date:     2021/7/16 15:33
 * Description: 分页入参
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sandman.common.model.query;

import io.swagger.annotations.ApiParam;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 分页入参
 *
 * @author wb.zhangchengwei01
 * @version 1.0.0
 * @since 2021/7/16
 */
@Data
public class PageQuery implements Serializable {
    private static final long serialVersionUID = -7206856111156777693L;
    /**
     * 页数
     */
    @ApiParam(
            value = "页数",
            example = "1",
            required = true
    )
    @NotNull
    private Integer pageIndex;
    /**
     * 页码
     */
    @ApiParam(
            value = "页码",
            example = "10",
            required = true
    )
    @NotNull
    private Integer pageSize;
}
