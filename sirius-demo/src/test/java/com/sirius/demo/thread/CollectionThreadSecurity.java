package com.sirius.demo.thread;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;


@SpringBootTest
public class CollectionThreadSecurity {

    /**
     * ArrayList线程不安全
     * @throws InterruptedException
     */
    @Test
    public void demoOne() throws InterruptedException {
        ArrayList<Thread> threads = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i<1000;i++ ){
            int finalI = i;
            Thread t = new Thread(()->{
               list.add(finalI);
            });
            t.start();
            threads.add(t);
        }
        for (Thread j:threads){
            j.join();
        }
        System.out.println("结束");
        System.out.println(list.size());
    }

    /**
     * CopyOnWriteArrayList
     *
     * ReentrantLock 使得
     * ArrayList线程安全
     * @throws InterruptedException
     */
    @Test
    public void demoTwo() throws InterruptedException {
        ArrayList<Thread> threads = new ArrayList<>();
        List<Integer> list = new CopyOnWriteArrayList<>();
        for (int i = 0;i<1000;i++ ){
            int finalI = i;
            Thread t = new Thread(()->{
                list.add(finalI);
            });
            t.start();
            threads.add(t);
        }
        for (Thread j:threads){
            j.join();
        }
        System.out.println("结束");
        System.out.println(list.size());
    }

    /**
     * Vector
     *
     * synchronized 使得
     * ArrayList 线程安全
     * @throws InterruptedException
     */
    @Test
    public void demoThree() throws InterruptedException {
        ArrayList<Thread> threads = new ArrayList<>();
        List<Integer> list = new Vector<>();
        for (int i = 0;i<1000;i++ ){
            int finalI = i;
            Thread t = new Thread(()->{
                list.add(finalI);
            });
            t.start();
            threads.add(t);
        }
        for (Thread j:threads){
            j.join();
        }
        System.out.println("结束");
        System.out.println(list.size());
    }

    /**
     * Collections.synchronizedList
     *
     * synchronized 使得
     * ArrayList线程安全
     * @throws InterruptedException
     */
    @Test
    public void demoFour() throws InterruptedException {
        ArrayList<Thread> threads = new ArrayList<>();
        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
        for (int i = 0;i<1000;i++ ){
            int finalI = i;
            Thread t = new Thread(()->{
                list.add(finalI);
            });
            t.start();
            threads.add(t);
        }
        for (Thread j:threads){
            j.join();
        }
        System.out.println("结束");
        System.out.println(list.size());
    }

    /**
     * HashMap 线程不安全
     * @throws InterruptedException
     */
    @Test
    public void demoFive() throws InterruptedException {
        ArrayList<Thread> threads = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        for (int i = 0;i<10000;i++ ){
            int finalI = i;
            Thread t = new Thread(()->{
                map.put(finalI+"",finalI);
            });
            t.start();
            threads.add(t);
        }
        for (Thread j:threads){
            j.join();
        }
        System.out.println("结束");
        System.out.println(map.size());
    }

    /**
     * ConcurrentHashMap
     *
     * synchronized 使得
     * HashMap 线程安全
     * @throws InterruptedException
     */
    @Test
    public void demoSix() throws InterruptedException {
        ArrayList<Thread> threads = new ArrayList<>();
        Map<String,Object> map = new ConcurrentHashMap<>();
        for (int i = 0;i<10000;i++ ){
            int finalI = i;
            Thread t = new Thread(()->{
                map.put(finalI+"",finalI);
            });
            t.start();
            threads.add(t);
        }
        for (Thread j:threads){
            j.join();
        }
        System.out.println("结束");
        System.out.println(map.size());
    }

    /**
     * Hashtable
     *
     * synchronized 使得
     * HashMap 线程安全
     * @throws InterruptedException
     */
    @Test
    public void demoSeven() throws InterruptedException {
        ArrayList<Thread> threads = new ArrayList<>();
        Map<String,Object> map = new Hashtable<>();
        for (int i = 0;i<10000;i++ ){
            int finalI = i;
            Thread t = new Thread(()->{
                map.put(finalI+"",finalI);
            });
            t.start();
            threads.add(t);
        }
        for (Thread j:threads){
            j.join();
        }
        System.out.println("结束");
        System.out.println(map.size());
    }

    /**
     * HashSet 线程不安全
     * @throws InterruptedException
     */
    @Test
    public void demoEight() throws InterruptedException {
        ArrayList<Thread> threads = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0;i<10000;i++ ){
            int finalI = i;
            Thread t = new Thread(()->{
                set.add(finalI+"");
            });
            t.start();
            threads.add(t);
        }
        for (Thread j:threads){
            j.join();
        }
        System.out.println("结束");
        System.out.println(set.size());
    }
    /**
     * CopyOnWriteArraySet
     *
     * ReentrantLock 使得
     * HashSet 线程安全
     * @throws InterruptedException
     *
     * 其他方式使得   HashSet 线程安全    ：1、Collections.synchronizedSet(new HashSet());
     */
    @Test
    public void demoNine() throws InterruptedException {
        ArrayList<Thread> threads = new ArrayList<>();
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0;i<10000;i++ ){
            int finalI = i;
            Thread t = new Thread(()->{
                set.add(finalI+"");
            });
            t.start();
            threads.add(t);
        }
        for (Thread j:threads){
            j.join();
        }
        System.out.println("结束");
        System.out.println(set.size());

    }
    /**
     *
     */

}
