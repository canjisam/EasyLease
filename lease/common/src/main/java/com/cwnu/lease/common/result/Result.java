package com.cwnu.lease.common.result;

import lombok.Data;

/**
 * 全局统一返回结果类，用于封装接口调用的返回数据和状态码。
 *
 * @param <T> 返回数据的泛型类型。
 * @author Jisam
 */
@Data
public class Result<T> {

    /**
     *  状态码，用于标识接口调用的成功与否。
     *  返回码
     */
    private Integer code;

    /**
     *  状态码对应的描述信息。
     *  返回消息
     */
    private String message;

    /**
     *  接口调用返回的具体数据。
     *  返回数据
     */
    private T data;

    /**
     * 默认构造方法。
     */
    public Result() {
    }

    /**
     * 建立一个成功结果的对象，包含数据。
     *
     * @param data 接口调用返回的数据。
     * @return Result<T> 成功结果对象。
     */
    private static <T> Result<T> build(T data) {
        Result<T> result = new Result<>();
        if (data != null) {
            result.setData(data);
        }
        return result;
    }

    /**
     * 建立一个包含数据和状态码的结果对象。
     *
     * @param body           接口调用返回的数据。
     * @param resultCodeEnum 状态码枚举，用于设定返回码和消息。
     * @return Result<T> 包含数据和状态码的结果对象。
     */
    public static <T> Result<T> build(T body, ResultCodeEnum resultCodeEnum) {
        Result<T> result = build(body);
        result.setCode(resultCodeEnum.getCode());
        result.setMessage(resultCodeEnum.getMessage());
        return result;
    }

    /**
     * 建立一个成功的结果对象，包含数据。
     *
     * @param data 接口调用返回的数据。
     * @return Result<T> 成功结果对象。
     */
    public static <T> Result<T> ok(T data) {
        return build(data, ResultCodeEnum.SUCCESS);
    }

    /**
     * 建立一个不包含数据的成功结果对象。
     *
     * @return Result<T> 成功结果对象，不包含数据。
     */
    public static <T> Result<T> ok() {
        return Result.ok(null);
    }

    /**
     * 建立一个失败的结果对象。
     *
     * @return Result<T> 失败结果对象。
     */
    public static <T> Result<T> fail() {
        return build(null, ResultCodeEnum.FAIL);
    }
}
