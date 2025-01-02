package com.ch.houseitemplace.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = (String) principal;

        // 对 createTime 和 createBy 字段进行判断
        if (this.getFieldValByName("createTime", metaObject) == null) {
            this.strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now());
        }
        if (this.getFieldValByName("createBy", metaObject) == null) {
            this.strictInsertFill(metaObject, "createBy", String.class, username); // 假设默认创建人为 admin
        }

        // 对 updateTime 和 updateBy 字段进行判断
        if (this.getFieldValByName("updateTime", metaObject) == null) {
            this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
        }
        if (this.getFieldValByName("updateBy", metaObject) == null) {
            this.strictUpdateFill(metaObject, "updateBy", String.class, username); // 假设默认更新人为 admin
        }
    }


    @Override
    public void updateFill(MetaObject metaObject) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = (String) principal;

        // 对 updateTime 和 updateBy 字段进行判断
        if (this.getFieldValByName("updateTime", metaObject) == null) {
            this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
        }
        if (this.getFieldValByName("updateBy", metaObject) == null) {
            this.strictUpdateFill(metaObject, "updateBy", String.class, username); // 假设默认更新人为 admin
        }
    }
}
