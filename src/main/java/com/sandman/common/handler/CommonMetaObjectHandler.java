/*
 * Copyright (C), 2021, com.netease
 * FileName: CommonMetaObjectHandler
 * Author:   wb.zhangchengwei01
 * Date:     2021/7/16 14:54
 * Description: insert or update handler
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
*/
package com.sandman.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * when save or update operation had been trigger,
 * this handler will auto update or insert basic table field
 *
 * @author wb.zhangchengwei01
 * @version 1.0.0
 * @since 2021/7/16
 */
@Component
public class CommonMetaObjectHandler  implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createDate", Date.class, new Date());
        this.strictInsertFill(metaObject, "updateDate",  Date.class, new Date());
        this.strictInsertFill(metaObject, "display", Boolean.class, true);
        this.strictInsertFill(metaObject, "disabled", Boolean.class, false);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        metaObject.setValue("updateDate", null);
        this.strictUpdateFill(metaObject, "updateDate", Date.class, new Date());
    }
}
