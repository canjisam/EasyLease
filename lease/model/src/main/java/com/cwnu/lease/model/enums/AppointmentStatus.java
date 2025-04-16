package com.cwnu.lease.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author jisam
 */

public enum AppointmentStatus implements BaseEnum {


    WAITING(1, "待看房"),

    CANCELED(2, "已取消"),

    VIEWED(3, "已看房");


    @EnumValue
    @JsonValue
    private Integer code;


    private String name;

    AppointmentStatus(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
