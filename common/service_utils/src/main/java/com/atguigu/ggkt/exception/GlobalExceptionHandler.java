package com.atguigu.ggkt.exception;

import com.atguigu.ggkt.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
//19.19.bq.bq//异常处理类，发生异常时，前端看到的是统一的结果。
@ControllerAdvice  //aop，在不改变代码的情况下，增强功能
public class GlobalExceptionHandler {

    //全局异常处理
    @ExceptionHandler(Exception.class)//当有异常，会执行该方法
    @ResponseBody//返回给前端jsion数据
    public Result error(Exception e) {
        System.out.println("全局.....");
        e.printStackTrace();
        return Result.fail(null).message("执行全局异常处理");
    }

    //特定异常处理ArithmeticException
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public Result error(ArithmeticException e) {
        System.out.println("特定.....");
        e.printStackTrace();
        return Result.fail(null).message("执行ArithmeticException异常处理");
    }
//    21.21.bq.bq
    //自定义异常处理GgktException
    @ExceptionHandler(GgktException.class)
    @ResponseBody
    public Result error(GgktException e) {
        e.printStackTrace();
        return Result.fail(null).code(e.getCode()).message(e.getMsg());
    }
//    21.21.bq.bq

}
//19.19.bq.bq
