package com.javasm.atm.exception;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/10-17:26
 * @Since:jdk1.8
 * @Description:
 */
public class AtmException extends Exception{
    public AtmException() {
    }

    public AtmException(String message) {
        super(message);
    }

    public AtmException(String message, Throwable cause) {
        super(message, cause);
    }

    public AtmException(Throwable cause) {
        super(cause);
    }

    public AtmException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
