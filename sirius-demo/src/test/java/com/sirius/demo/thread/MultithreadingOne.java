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
     * 场景：厨师和小白，在小白点完餐后，
     * 厨师做菜
     * 小白的工作（打游戏等待饭菜）
     * 服务员蒸饭
     * 服务员打饭
     * 厨师，小白，服务员在各自的线程工作
     *
     * 注意：
     */
    @Test
    public void DemoThree(){
        printTimeAndThread("小白进入餐厅");
        printTimeAndThread("小白点了 番茄炒蛋 + 一碗米饭");

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->{
            printTimeAndThread("厨师炒菜");
            sleepMillis(1000);
            return "番茄炒蛋";
        });
        CompletableFuture<String> rice = CompletableFuture.supplyAsync(()->{
           printTimeAndThread("服务员蒸饭");
           sleepMillis(1000);
           return "米饭";
        });
        printTimeAndThread("小白再打王者");
        printTimeAndThread(String.format("%s + %s 好了",completableFuture.join(),rice.join()));
        printTimeAndThread("服务员打饭");
        sleepMillis(1000);
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
    public void DemoFour(){
        printTimeAndThread("小白进入餐厅");
        printTimeAndThread("小白点了 番茄炒蛋 + 一碗米饭");

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->{
            printTimeAndThread("厨师炒菜");
            sleepMillis(1000);
            return "番茄炒蛋";
        }).thenCombine(CompletableFuture.supplyAsync(()->{
            printTimeAndThread("服务员蒸饭");
            sleepMillis(1000);
            return "米饭";
        }),(dish,rice)->{
            printTimeAndThread("服务员打饭");
            sleepMillis(1000);
            return String.format("%s + %s 好了",dish,rice);
        });
        printTimeAndThread("小白再打王者");
        printTimeAndThread(String.format("%s,小白开吃",completableFuture.join()));
        //  join()方法的返回值类型就是CompletableFuture<>的泛型，此代码块中的返回类型就是String
    }

    /**
     * 场景：小白吃完饭，要去结账开发票
     *  小白去柜台
     *  服务员开发票
     *  两个线程各自做自己的事
     *
     */
    @Test
    public void DemoFive(){
        printTimeAndThread("小白吃完饭");
        printTimeAndThread("小白去结账");

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->{
            printTimeAndThread("服务员收款500");
            sleepMillis(1000);
            printTimeAndThread("服务员开发票");
            sleepMillis(1000);
            return "500元发票";
        });
        printTimeAndThread("小白接到朋友的电话，准备一起打游戏");
        printTimeAndThread(String.format("小白拿到%s,准备回家",completableFuture.join()));
        //  join()方法的返回值类型就是CompletableFuture<>的泛型，此代码块中的返回类型就是String
    }

    /**
     * 场景：小白吃完饭，要去结账开发票
     *  小白去柜台
     *  服务员结账
     *  服务员开发票
     *  不同的服务员做不同的事情
     *  三个线程各自做自己的事
     *
     */
    @Test
    public void DemoSix(){
        printTimeAndThread("小白吃完饭");
        printTimeAndThread("小白去结账，要求开发票");

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->{
            printTimeAndThread("服务员收款500");
            sleepMillis(1000);

            //  服务员收完款后开启异步任务开发票（开个新线程）
            CompletableFuture<String> writer2 = CompletableFuture.supplyAsync(()->{
                printTimeAndThread("服务员开发票");
                sleepMillis(1000);
                return "发票500元";
            });

            return writer2.join();
        });
        printTimeAndThread("小白接到朋友的电话，准备一起打游戏");
        printTimeAndThread(String.format("小白拿到%s,准备回家",completableFuture.join()));
        //  join()方法的返回值类型就是CompletableFuture<>的泛型，此代码块中的返回类型就是String
    }


    /**
     * 场景：小白吃完饭，要去结账开发票
     *  小白去柜台
     *  服务员结账
     *  服务员开发票
     *  不同的服务员做不同的事情
     *  三个线程各自做自己的事
     *
     */
    @Test
    public void DemoSeven(){
        printTimeAndThread("小白吃完饭");
        printTimeAndThread("小白去结账，要求开发票");

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->{
            printTimeAndThread("服务员收款500");
            sleepMillis(1000);

//            //  服务员收完款后开启异步任务开发票（开个新线程）
//            CompletableFuture<String> writer2 = CompletableFuture.supplyAsync(()->{
//                printTimeAndThread("服务员开发票");
//                sleepMillis(1000);
//                return "发票500元";
//            });

            return "500";
        }).thenApply(money ->{
            printTimeAndThread(String.format("服务员开发票 面额 %s",money));
            sleepMillis(1000);
            return String.format("%s元发票",money);
        });
        printTimeAndThread("小白接到朋友的电话，准备一起打游戏");
        printTimeAndThread(String.format("小白拿到%s,准备回家",completableFuture.join()));
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
