package com.javasm.demo.practiceDemo.stream;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/1/21-19:14
 * @Since:jdk1.8
 * @Description:
 */
public class SimpleObjectOutputStream extends ObjectOutputStream {
    public SimpleObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    protected SimpleObjectOutputStream() throws IOException, SecurityException {
    }
    @Override
    protected void writeStreamHeader() throws IOException{
        return;
    }
}
