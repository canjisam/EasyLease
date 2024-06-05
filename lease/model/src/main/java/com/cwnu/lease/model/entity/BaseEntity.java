package com.cwnu.lease.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * 实体类的基类，用于定义通用的实体属性。
 * 这些属性包括实体的主键、创建时间、更新时间和逻辑删除标志。
 * @author Administrator
 */
@Data
public class BaseEntity {

    /**
     * 主键字段，自动增长。
     * 用于唯一标识每个实体实例。
     */
    @Schema(description = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间字段。
     * 记录实体的创建时间，用于审计和追踪目的。
     * 不参与JSON序列化和反序列化，以避免在接口中暴露。
     */
    @Schema(description = "创建时间")
    @JsonIgnore
    private Date createTime;

    /**
     * 更新时间字段。
     * 记录实体的最后更新时间，用于审计和追踪目的。
     * 不参与JSON序列化和反序列化，以避免在接口中暴露。
     */
    @Schema(description = "更新时间")
    @JsonIgnore
    private Date updateTime;

    /**
     * 逻辑删除字段。
     * 用于标记实体是否被逻辑删除，而不是从数据库中物理删除。
     * 不参与JSON序列化和反序列化，以避免在接口中暴露。
     */
    @Schema(description = "逻辑删除")
    @JsonIgnore
    @TableLogic
    @TableField("is_deleted")
    private Byte isDeleted;
}
