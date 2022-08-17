package com.sirius.demo.thread;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.StringJoiner;
import java.util.concurrent.CompletableFuture;

/**
 * 需要了解的知识点
 * 1、Supplier:一个函数式接口，没有入参，只有一个返回值，也就是对外提供数据的
 */
@SpringBootTest
public class MultithreadingOne {

    /**
     * 场景：厨师和小白，在小白点完餐后，厨师和小白的工作是可以同时进行的 也就是说，厨师和小白在各自的线程工作
     */
    @Test
    public void DemoOne(){
        printTimeAndThread("小白进入餐厅");
        printTimeAndThread("小白点了 番茄炒蛋 + 一碗米饭");

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->{
            printTimeAndThread("厨师炒菜");
            sleepMillis(1000);
            printTimeAndThread("厨师打饭");
            sleepMillis(1000);
            return "番茄炒蛋 + 米饭 做好了";
        });

        printTimeAndThread("小白再打王者");
        printTimeAndThread(String.format("%s,小白开吃",completableFuture.join()));
        //  join()方法的返回值类型就是CompletableFuture<>的泛型，此代码块中的返回类型就是String
    }

    /**
     * 场景：厨师和小白，在小白点完餐后，
     * 厨师做菜
     * 小白的工作（打游戏等待饭菜）
     * 服务员打饭
     * 厨师，小白，服务员在各自的线程工作
     *
     * 注意：1、thenCompose 在前一个任务有结果后才会触发
     */
    @Test
    public void DemoTwo(){
        printTimeAndThread("小白进入餐厅");
        printTimeAndThread("小白点了 番茄炒蛋 + 一碗米饭");

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->{
            printTimeAndThread("厨师炒菜");
            sleepMillis(1000);
            return "番茄炒蛋";
        }).thenCompose(dish->CompletableFuture.supplyAsync(()->{
            printTimeAndThread("服务员打饭");
            sleepMillis(1000);
            return dish+"+米饭";
        }));
        printTimeAndThread("小白再打王者");
        printTimeAndThread(String.format("%s,小白开吃",completableFuture.join()));
        //  join()方法的返回值类型就是CompletableFuture<>的泛型，此代码块中的返回类型就是String
    }

    /**
     * 当前线程睡眠一段时间（毫秒）
     * @param millis
     */
    public static void sleepMillis(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 打印当前的时间戳，线程信息，消息
     * @param tag
     */
    public static void printTimeAndThread(String tag){
        String result = new StringJoiner("\t|\t")
                .add(String.valueOf(System.currentTimeMillis()))    //  当前的时间戳
                .add(String.valueOf(Thread.currentThread().getId()))    //  当前线程ID
                .add(Thread.currentThread().getName())  //  当前线程名称
                .add(tag)   //  传入的具体参数
                .toString();
        System.out.println(result);
    }
}
