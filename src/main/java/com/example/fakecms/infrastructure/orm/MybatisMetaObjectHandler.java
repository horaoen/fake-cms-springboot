package com.example.fakecms.infrastructure.orm;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author fanghaoran
 * mybatis自动填充
 */
@Slf4j
@Component
public class MybatisMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
//      官方文档提供日期的方法结果是null
//      this.strictUpdateFill(metaObject, "updateTime", () -> LocalDateTime.now(), LocalDateTime.class);

        this.strictInsertFill(metaObject,"createTime",Date.class, new Date());
        this.strictInsertFill(metaObject,"updateTime",Date.class, new Date());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        this.strictInsertFill(metaObject,"updateTime",Date.class, new Date());
    }
}
