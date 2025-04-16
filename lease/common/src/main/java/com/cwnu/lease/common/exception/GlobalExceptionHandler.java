package com.cwnu.lease.common.exception;


import com.cwnu.lease.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * 全局异常处理类，用于捕获和处理应用程序中抛出的异常。
 * 通过@ExceptionHandler注解，可以捕获特定类型的异常并返回统一的错误响应。
 */
@RestController
public class GlobalExceptionHandler {

    /**
     * 捕获并处理所有类型的异常。
     * 该方法会打印异常堆栈信息，并返回一个通用的失败结果。
     *
     * @param e 捕获到的异常对象
     * @return 返回一个通用的失败结果，通常包含错误码和错误信息
     */
    @ExceptionHandler(Exception.class)
    public Result handle(Exception e){
        // 打印异常堆栈信息，便于调试和日志记录
        e.printStackTrace();
        // 返回通用的失败结果
        return Result.fail();
    }

    /**
     * 捕获并处理自定义异常LeaseException。
     * 该方法会打印异常堆栈信息，并返回一个包含自定义错误码和错误信息的失败结果。
     *
     * @param e 捕获到的LeaseException异常对象
     * @return 返回一个包含自定义错误码和错误信息的失败结果
     */
    @ExceptionHandler(LeaseException.class)
    public Result error(LeaseException e){
        // 打印异常堆栈信息，便于调试和日志记录
        e.printStackTrace();
        // 返回包含自定义错误码和错误信息的失败结果
        return Result.fail(e.getCode(), e.getMessage());
    }
}
