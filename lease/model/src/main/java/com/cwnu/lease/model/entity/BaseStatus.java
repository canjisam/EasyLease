package com.cwnu.lease.model.entity;


import com.baomidou.mybatisplus.annotation.EnumValue;
import com.cwnu.lease.model.enums.BaseEnum;
import com.fasterxml.jackson.annotation.JsonValue;
/**
 * 基础状态枚举，实现了BaseEnum接口。
 * 该枚举定义了系统中通用的状态码，包括启用和禁用两种状态。
 * @author Jisam
 */
public enum BaseStatus implements BaseEnum {


    /**
     * 启用状态码。
     * code值为1，代表该状态是启用状态。
     * name值为"正常"，用于直观显示状态名称。
     */
    ENABLE(1, "正常"),

    /**
     * 禁用状态码。
     * code值为0，代表该状态是禁用状态。
     * name值为"禁用"，用于直观显示状态名称。
     */
    DISABLE(0, "禁用");


    /**
     * 状态码，用于标识具体的状态。
     */
    @EnumValue
    @JsonValue
    private Integer code;

    /**
     * 状态名称，用于直观显示状态。
     */
    private String name;

    /**
     * 构造方法，初始化枚举值。
     *
     * @param code 状态码
     * @param name 状态名称
     */
    BaseStatus(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    /**
     * 获取状态码。
     *
     * @return 状态码
     */
    @Override
    public Integer getCode() {
        return this.code;
    }

    /**
     * 获取状态名称。
     *
     * @return 状态名称
     */
    @Override
    public String getName() {
        return this.name;
    }
}
