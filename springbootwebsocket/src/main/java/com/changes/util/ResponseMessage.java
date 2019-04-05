package com.changes.util;

/**
 * @ClassName ResponseMessage
 * @Description TODO
 * @Author LiuJunJie
 * @Date 2019/4/4 16:34
 * @Version 1.0
 * @Company WH_tepia
 **/
public class ResponseMessage<T> {
    private int code;
    private T result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
