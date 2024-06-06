package com.cwnu.lease.model.entity;
/**
 * 物品类型的枚举类，用于定义不同类型的物品。
 * 枚举值包括公寓和房间，每种类型都有对应的代码和名称。
 * @author Jisam
 */
public enum ItemType {

    /**
     * 定义公寓类型，代码为1，名称为"公寓"
     * */
    APARTMENT(1, "公寓"),
    /**
     * 定义房间类型，代码为2，名称为"房间"
     * */
    ROOM(2, "房间");
    /**
     * 物品类型的代码，用于唯一标识物品类型
     * */
    private Integer code;
    /**
     * 物品类型的名称，用于显示物品类型的描述
     * */
    private String name;

    /**
     * 构造函数，用于初始化物品类型的代码和名称。
     *
     * @param code 物品类型的代码
     * @param name 物品类型的名称
     */
    ItemType(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
