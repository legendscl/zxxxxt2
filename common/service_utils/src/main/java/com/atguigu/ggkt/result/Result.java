package com.atguigu.ggkt.result;

import lombok.Data;
//12.12.bq.bq
//统一返回结果类,给前端返回统一格式的数据
@Data
public class Result<T> {

    private Integer code; //状态码

    private String message; //返回状态信息（成功 失败）

    private T data; //返回数据

    public Result() {}



    //成功的方法，有data数据
    public static<T> Result<T> ok(T data) {
        Result<T> result = new Result<>();
        if(data != null) {
            result.setData(data);
        }
        result.setCode(20000);
        result.setMessage("成功");
        return result;
    }

    //失败的方法,有data数据
    public static<T> Result<T> fail(T data) {
        Result<T> result = new Result<>();
        if(data != null) {
            result.setData(data);
        }
        result.setCode(20001);
        result.setMessage("失败");
        return result;
    }

    public Result<T> message(String msg){
        this.setMessage(msg);
        return this;
    }

    public Result<T> code(Integer code){
        this.setCode(code);
        return this;
    }
}
//12.12.bq.bq


//13.13.bq.bq
//controller里改变返回值
//13.13.bq.bq
