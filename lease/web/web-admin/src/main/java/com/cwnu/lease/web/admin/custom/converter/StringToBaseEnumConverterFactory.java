package com.cwnu.lease.web.admin.custom.converter;

import com.cwnu.lease.model.enums.BaseEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

/**
 * 实现了将字符串转换为基类枚举的转换器工厂。
 * 该工厂用于生产特定于枚举类型的转换器，这些转换器能够将字符串转换为相应的枚举常量。
 *
 * @author Administrator
 */
@Component
public class StringToBaseEnumConverterFactory implements ConverterFactory<String, BaseEnum> {

    /**
     * 根据目标类型创建并返回一个转换器。
     * 这个方法为每个请求的目标枚举类型创建一个新的转换器实例。
     * 转换器的作用是将字符串转换为指定枚举类型的枚举常量。
     *
     * @param targetType 转换器将要转换的目标枚举类型。
     * @return 能将字符串转换为目标枚举类型枚举常量的转换器。
     */
    @Override
    public <T extends BaseEnum> Converter<String, T> getConverter(Class<T> targetType) {
        return new Converter<String, T>() {
            /**
             * 将给定的字符串源转换为目标枚举类型的枚举常量。
             * 通过遍历枚举类型的所有常量，找到其代码与源字符串匹配的枚举常量。
             * 如果找不到匹配的枚举常量，则抛出IllegalArgumentException。
             *
             * @param source 要转换的字符串源。
             * @return 转换后的枚举常量。
             * @throws IllegalArgumentException 如果源字符串不代表任何有效的枚举常量。
             *  Class.getEnumConstants() 方法是 Java 反射 API 中的一个方法，用于获取表示枚举类型的 Class 对象中所有枚举常量的数组
             * */
            @Override
            public T convert(String source) {

                for (T enumConstant : targetType.getEnumConstants()) {
                    if (enumConstant.getCode().equals(Integer.valueOf(source))) {
                        return enumConstant;
                    }
                }
                throw new IllegalArgumentException("非法的枚举值:" + source);
            }
        };
    }
}
