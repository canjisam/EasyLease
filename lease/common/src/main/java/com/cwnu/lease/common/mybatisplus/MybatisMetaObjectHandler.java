package com.cwnu.lease.common.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;
/**
 * Mybatis自定义MetaObjectHandler，用于自动填充创建时间和更新时间。
 * @author Jisam
 * @Component 注解表示该类被Spring管理为一个Bean。
 */
@Component
public class MybatisMetaObjectHandler implements MetaObjectHandler {

    /**
     * 在插入数据时自动填充createTime字段。
     * 使用strictInsertFill方法确保createTime字段被准确设置为当前时间。
     * @param metaObject Mybatis的元对象，用于反射字段并操作其值。
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createTime", Date.class, new Date());
    }

    /**
     * 在更新数据时自动填充updateTime字段。
     * 使用strictUpdateFill方法确保updateTime字段被准确设置为当前时间。
     * @param metaObject Mybatis的元对象，用于反射字段并操作其值。
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "updateTime", Date.class, new Date());
    }
}
