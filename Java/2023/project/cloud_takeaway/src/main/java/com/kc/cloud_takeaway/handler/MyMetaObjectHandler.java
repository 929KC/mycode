package com.kc.cloud_takeaway.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.kc.cloud_takeaway.common.BaseContextUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    /**
     * 插入操作,自动填充
     * @param metaObject 元对象
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("公共字段自动填充");
        log.info(metaObject.toString());
        metaObject.setValue("createTime", LocalDateTime.now());
        metaObject.setValue("updateTime", LocalDateTime.now());
        metaObject.setValue("createUser", LocalDateTime.now());
        metaObject.setValue("updateUser", LocalDateTime.now());
    }

    /**
     * 修改操作,自动填充
     * @param metaObject 元对象
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("公共字段自动填充");
        log.info(metaObject.toString());
        Long id = Thread.currentThread().getId();
        log.info("线程id为:{}", id);
        metaObject.setValue("updateTime", LocalDateTime.now());
        metaObject.setValue("updateUser", BaseContextUtils.getCurrentId());
    }
}
