/*
 * Copyright (C), 2021, com.netease
 * FileName: StringFormatter
 * Author:   wb.zhangchengwei01
 * Date:     2021/7/16 16:03
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sandman.common.util;

import com.sandman.common.constant.CommonConstants;

/**
 * @author wb.zhangchengwei01
 * @version 1.0.0
 * @since 2021/7/16
 */
public class StringFormatter {
    /**
     * 空json
     */
    public static final String EMPTY_JSON = "{}";

    /**
     * 反斜杠
     */
    public static final char C_BACKSLASH = '\\';

    /**
     * 字符串开头
     */
    public static final char C_DELIM_START = '{';

    /**
     * 字符串结尾
     */
    public static final char C_DELIM_END = '}';

    public StringFormatter() {
    }

    public static String format(String strPattern, Object... argArray) {
        if (!StringUtils.isEmpty(strPattern) && !StringUtils.isEmpty(argArray)) {
            int strPatternLength = strPattern.length();
            StringBuilder sbuf = new StringBuilder(
                    strPatternLength + (CommonConstants.FIVE_CONSTANT_INT * CommonConstants.TEN_CONSTANT_INT));
            int handledPosition = 0;
            for (int argIndex = 0; argIndex < argArray.length; ++argIndex) {
                int delimIndex = strPattern.indexOf("{}", handledPosition);
                if (CommonConstants.MINUS_ONE_CONSTANT_INT == delimIndex) {
                    if (handledPosition == 0) {
                        return strPattern;
                    }
                    sbuf.append(strPattern, handledPosition, strPatternLength);
                    return sbuf.toString();
                }
                if (delimIndex > 0 && strPattern.charAt(delimIndex - CommonConstants.ONE_CONSTANT_INT) == '\\') {
                    if (delimIndex > 1 && strPattern.charAt(delimIndex - CommonConstants.TWO_CONSTANT_INT) == '\\') {
                        sbuf.append(strPattern, handledPosition, delimIndex - 1);
                        sbuf.append(CustomObjectConvert.utf8Str(argArray[argIndex]));
                        handledPosition = delimIndex + CommonConstants.TWO_CONSTANT_INT;
                    } else {
                        --argIndex;
                        sbuf.append(strPattern, handledPosition, delimIndex - 1);
                        sbuf.append('{');
                        handledPosition = delimIndex + CommonConstants.ONE_CONSTANT_INT;
                    }
                } else {
                    sbuf.append(strPattern, handledPosition, delimIndex);
                    sbuf.append(CustomObjectConvert.utf8Str(argArray[argIndex]));
                    handledPosition = delimIndex + CommonConstants.TWO_CONSTANT_INT;
                }
            }
            sbuf.append(strPattern, handledPosition, strPattern.length());
            return sbuf.toString();
        } else {
            return strPattern;
        }
    }
}
