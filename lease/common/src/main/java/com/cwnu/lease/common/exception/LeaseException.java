package com.cwnu.lease.common.exception;


import com.cwnu.lease.common.result.ResultCodeEnum;
import lombok.Data;

/**
 * 租赁业务异常类，用于表示租赁业务中出现的特定异常情况。
 * 继承自RuntimeException，表示这是一种非检查（Unchecked）异常。
 * @author Jisam
 */
@Data
public class LeaseException extends RuntimeException{

    private Integer code;

    /**
     * 构造函数，用于创建一个带有特定状态码和错误消息的LeaseException实例。
     *
     * @param message 错误消息，描述异常的具体情况。
     * @param code 状态码，标识异常的类型。
     */
    public LeaseException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    /**
     * 构造函数，通过ResultCodeEnum枚举对象创建LeaseException实例。
     * 这样做可以方便地根据业务结果代码抛出异常。
     *
     * @param resultCodeEnum 业务结果代码枚举，包含状态码和错误消息。
     */
    public LeaseException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage()); // 通过枚举获取错误信息
        this.code = resultCodeEnum.getCode(); // 通过枚举获取状态码
    }

    /**
     * 重写toString方法，以提供包含状态码和错误消息的字符串表示形式。
     * 这样可以在日志等地方更方便地看到异常的详细信息。
     *
     * @return 字符串表示形式，包含状态码和错误消息。
     */
    @Override
    public String toString() {
        return "LeaseException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}

