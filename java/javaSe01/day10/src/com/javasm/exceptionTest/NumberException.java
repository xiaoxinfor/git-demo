package com.javasm.exceptionTest;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/10-16:29
 * @Since:jdk1.8
 * @Description:自定义一个异常
 */
public class NumberException extends Exception{//继承可检测异常

    public NumberException() {
    }

    public NumberException(String message) {
        super(message);
    }

    public NumberException(String message, Throwable cause) {
        super(message, cause);
    }
}
