package com.practice.practice2.exception;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/10-22:26
 * @Since:jdk1.8
 * @Description:自定义异常
 */
public class UserException extends Exception{
    public UserException() {
    }

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserException(Throwable cause) {
        super(cause);
    }

    public UserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
