/*
 * Copyright (C), 2021, com.netease
 * FileName: SimpleConverter
 * Author:   wb.zhangchengwei01
 * Date:     2021/7/16 16:17
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.sandman.common.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * {object mapping}
 * Converter can only mapping same type and name field Objet field
 * make sure when you use, keep object have same field between source and destination
 * also have coryProperties function, but attention to keep into the reference sequence
 *
 * @author wb.zhangchengwei01
 * @version 1.0.0
 * @since 2021/7/16
 */
@Slf4j
public class SimpleConverter {

    public SimpleConverter() {
    }

    public static void copyProperties(Object src, Object dest) {
        BeanUtils.copyProperties(dest, src);
    }

    public static <T> T convert(Object src, Class<T> dest) {
        return convert(src, dest, (String[]) null);
    }

    public static <T> T convert(Object src, Class<T> dest, String... ignoreProperties) {
        if (Objects.isNull(src)) {
            return null;
        } else {
            T obj = null;

            try {
                obj = dest.newInstance();
                BeanUtils.copyProperties(src, obj, ignoreProperties);
                return obj;
            } catch (Exception var5) {
                throw new RuntimeException(MessageFormat.format("Convert error: {0} to {1}", src, obj), var5);
            }
        }
    }

    public static <F, T> List<T> convert(List<F> src, Class<T> dest) {
        if (Objects.isNull(src)) {
            return null;
        } else {
            List<T> list = new ArrayList<>();
            for (F o : src) {
                T t = convert(o, dest);
                list.add(t);
            }
            return list;
        }
    }
}
