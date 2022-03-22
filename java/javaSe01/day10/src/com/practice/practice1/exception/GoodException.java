package com.practice.practice1.exception;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/10-21:20
 * @Since:jdk1.8
 * @Description:定义异常
 */
public class GoodException extends Exception{
    public GoodException() {
    }

    public GoodException(String message) {
        super(message);
    }

    public GoodException(String message, Throwable cause) {
        super(message, cause);
    }

    public GoodException(Throwable cause) {
        super(cause);
    }

    public GoodException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
