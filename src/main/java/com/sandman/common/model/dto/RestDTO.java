/*
 * Copyright (C), 2021, com.netease
 * FileName: RestDTO
 * Author:   wb.zhangchengwei01
 * Date:     2021/7/16 15:41
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sandman.common.model.dto;

import com.sandman.common.enums.CodeEnum;
import com.sandman.common.enums.ICodeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author wb.zhangchengwei01
 * @version 1.0.0
 * @since 2021/7/16
 */
@Data
public class RestDTO implements Serializable {
    private static final long serialVersionUID = -3462433258560124278L;

    /**
     * return code
     */
    @ApiModelProperty(
            value = "响应代码",
            example = "100",
            required = true
    )
    private String code;

    /**
     * return is success
     */
    @ApiModelProperty(
            value = "是否成功",
            example = "true",
            required = true,
            position = 1
    )
    private Boolean success;

    /**
     * return message
     */
    @ApiModelProperty(
            value = "消息",
            example = "接口调用成功",
            required = true,
            position = 2
    )
    private String message;


    public RestDTO() {
    }

    public RestDTO(String msg) {
        this.code = CodeEnum.UNKNOWN_ERROR.code();
        this.success = CodeEnum.UNKNOWN_ERROR.success();
        this.message = msg;
    }

    public RestDTO(ICodeEnum codeEnum) {
        this.code = codeEnum.code();
        this.success = codeEnum.success();
        this.message = codeEnum.message();
    }
}
