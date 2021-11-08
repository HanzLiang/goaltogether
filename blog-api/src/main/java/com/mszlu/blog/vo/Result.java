package com.mszlu.blog.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
// 构造函数 使用后添加一个构造函数，该构造函数含有所有已声明字段属性参数
public class Result {

    private boolean success;

    private int code;

    private String msg;

    private Object data;

// Object 理解成一个对象就行 成功需要返回数据 所以需要一个object的data
    public static Result success(Object data){
        return new Result(true,200,"success",data);
    }

    public static Result fail(int code, String msg){
        return new Result(false,code,msg,null);
    }
}
