package com.yuandw.study.utils;


import java.io.Serializable;

/**
 * @Author: yuandw
 * @Date: 2019-5-6 11:21
 * * @param <T>
 * @Description: web端返给前端的数据实体
 */
public class ResponseData<T> implements Serializable {
    /**
     * 结果code
     */
    private String code;
    /**
     * 结果msg
     */
    private String msg;
    /**
     * 数据对象
     */
    private T data;


    public ResponseData(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseData(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseData() {

    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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
        return "ResponseData{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
