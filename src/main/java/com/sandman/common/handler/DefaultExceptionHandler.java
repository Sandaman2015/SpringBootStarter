/*
 * Copyright (C), 2021, com.netease
 * FileName: DefaultExceptionHandler
 * Author:   wb.zhangchengwei01
 * Date:     2021/7/16 16:37
 * Description: 通用异常处理
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sandman.common.handler;

import com.sandman.common.enums.CodeEnum;
import com.sandman.common.enums.ICodeEnum;
import com.sandman.common.exception.ServiceException;
import com.sandman.common.model.dto.RestDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.ServletException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.Set;

/**
 * 通用异常处理
 *
 * @author wb.zhangchengwei01
 * @version 1.0.0
 * @since 2021/7/16
 */
@Slf4j
@ControllerAdvice
public class DefaultExceptionHandler {
    public DefaultExceptionHandler() {
    }

    /**
     * 异常处理
     *
     * @param e 被抛出的异常
     * @return 接口对象
     */
    @ExceptionHandler({BindException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public RestDTO handle(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        StringBuilder message = new StringBuilder("参数错误：");

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            message.append(fieldError.getField()).append("字段");
            message.append(fieldError.getDefaultMessage()).append(";");
        }

        RestDTO restDTO = new RestDTO(CodeEnum.PARAMS_ERROR);
        restDTO.setMessage(message.toString());
        return restDTO;
    }


    /**
     * 异常处理
     *
     * @param e 被抛出的异常
     * @return 接口对象
     */
    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public RestDTO handle(ConstraintViolationException e) {
        Set<ConstraintViolation<?>> constraintViolationSet = e.getConstraintViolations();
        StringBuilder message = new StringBuilder("参数错误：");

        for (ConstraintViolation<?> constraintViolation : constraintViolationSet) {
            message.append(constraintViolation.getMessage()).append(";");
        }

        RestDTO restDTO = new RestDTO(CodeEnum.PARAMS_ERROR);
        restDTO.setMessage(message.toString());
        return restDTO;
    }


    /**
     * 异常处理
     *
     * @param e 被抛出的异常
     * @return 接口对象
     */
    @ExceptionHandler({MissingServletRequestParameterException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public RestDTO handle(MissingServletRequestParameterException e) {
        RestDTO restDTO = new RestDTO(CodeEnum.PARAMS_ERROR);
        restDTO.setMessage(e.getMessage());
        return restDTO;
    }


    /**
     * 异常处理
     *
     * @param e 被抛出的异常
     * @return 接口对象
     */
    @ExceptionHandler({ServletException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public RestDTO servletErrorHandler(ServletException e) {
        RestDTO restDTO = new RestDTO(CodeEnum.PARAMS_ERROR);
        restDTO.setMessage(e.getMessage());
        return restDTO;
    }


    /**
     * 异常处理
     *
     * @param e 被抛出的异常
     * @return 接口对象
     */
    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public RestDTO defaultErrorHandler(Exception e) {
        log.error(String.format("内部逻辑异常：%s", e.getMessage()));
        log.error("异常堆栈信息：%s", e);
        RestDTO restDTO = new RestDTO(CodeEnum.UNKNOWN_ERROR);
        if (e instanceof ServiceException) {
            if (((ServiceException) e).getCodeEnum() != null) {
                ICodeEnum codeEnum = ((ServiceException) e).getCodeEnum();
                restDTO = new RestDTO(codeEnum);
            } else {
                restDTO = new RestDTO(e.getMessage());
            }
        }

        if (e instanceof ValidationException || e instanceof MethodArgumentNotValidException) {
            restDTO = new RestDTO(CodeEnum.PARAMS_ERROR);
        }

        if (e instanceof HttpRequestMethodNotSupportedException || e instanceof HttpMediaTypeNotSupportedException
                || e instanceof TypeMismatchException) {
            restDTO = new RestDTO(CodeEnum.PARAMS_ERROR);
        }

        if (e instanceof ServletException) {
            restDTO = new RestDTO(CodeEnum.PARAMS_ERROR);
        }

        return restDTO;
    }
}
