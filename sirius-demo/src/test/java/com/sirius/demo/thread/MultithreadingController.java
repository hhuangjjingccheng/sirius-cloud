package com.sirius.demo.thread;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author huangjingcheng
 * @version 1.0.0
 * @ClassName MultithreadingController.java
 * @Description TODO
 * @createTime 2022年08月16日 17:02:00
 */
@SpringBootTest
public class MultithreadingController {

    /**
     * 发送测试  首先被打印出来
     * 原因 1.不会阻塞主线程，只会阻塞新线程
     */
    @Test
    public void demo() {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程阻塞");
        }).start();

        System.out.println("发送测试");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试调用发送被阻塞一秒
     */
    @Test
    public void demoOne() {
        long startTime = System.currentTimeMillis();
        sendMail();
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("Total Time：%d ms", endTime - startTime));
    }

    /**
     * 需要发送10次
     * 同步处理
     */
    @Test
    public void demoTwo() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            sendMail();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("Total Time：%d ms", endTime - startTime));
    }

    /**
     * 需要发送10次
     * 多线程的方式
     */
    @Test
    public void demoThree() {
        long startTime = System.currentTimeMillis();
        System.out.println(String.format("Total Time：%d ms",startTime));
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                sendMail();
            }).start();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("Total Time：%d ms",endTime));
        System.out.println(String.format("Total Time：%d ms", endTime - startTime));

        // 防止主线程推出
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 模拟发送的I/O阻塞
     */
    public static void sendMail() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发送成功");
    }
}


