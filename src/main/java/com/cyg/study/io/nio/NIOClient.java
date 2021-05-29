package com.cyg.study.io.nio;

import java.io.IOException;
import java.net.Socket;

/**
 * @author cyg
 * @date 2021/5/28 17:44
 **/
public class NIOClient {
    public static void main(String[] args) {
        //创建多个线程，模拟多个客户端连接服务端
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                try {
                    Socket socket = new Socket("127.0.0.1", 3333);
                    while (true) {
                        try {
                            socket.getOutputStream().write(("客户端线程:" + Thread.currentThread().getName() + ": 你好，树先生！").getBytes());
                            Thread.sleep(1000);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }

}

