package com.zxw.common.pojo;

public class RS<T> {
    private Integer code; // 状态码
    private String msg;   // 消息

    private String status;
    private T data;       // 数据

    // 默认构造函数
    public RS() {}

    // 私有构造函数，用于构建成功的响应
    private RS(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    // 成功响应的静态工厂方法
    public static <T> RS<T> ok() {
        return new RS<>(200, "操作成功", null);
    }

    public static <T> RS<T> ok(String msg) {
        return new RS<>(200, msg, null);
    }

    public static <T> RS<T> ok(T data) {
        return new RS<>(200, "操作成功", data);
    }

    public static <T> RS<T> ok(String msg, T data) {
        return new RS<>(200, msg, data);
    }

    // 错误响应的静态工厂方法
    public static RS<?> error(String errorMsg) {
        return new RS<>(500, errorMsg, null);
    }

    public static RS<?> error(Integer code, String errorMsg) {
        return new RS<>(code, errorMsg, null);
    }

    // Getters and Setters (省略)

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RS{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public Object get(String status) {
        return this.status;
    }
}