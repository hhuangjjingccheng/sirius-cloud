package com.sirius.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Demo{

    //利用线程池对于一个长数组处理
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Integer> list = new ArrayList<>();
        for(int i= 1;i<=1000; i++){
            list.add(i);
        }

        List<List<Integer>> splistList = splistList(list,100);

        ArrayList<Future<ArrayList<Integer>>> resultList = new ArrayList<Future<ArrayList<Integer>>>();

        for(int i=0;i<splistList.size();i++){

            List<Integer> temp = splistList.get(i);
            Future future = executorService.submit(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    List<Integer> resultTemp = new ArrayList<>();
                    for(int a: temp){
                        resultTemp.add(a+2);
                    }

                    return resultTemp;
                }
            });
            resultList.add(future);
        }

        //关闭线程池，但是不是立即关闭，是等待所有线程完毕，不会新开线程
        executorService.shutdown();


        List<Integer> lastList = new ArrayList<>();
        while(true){
            //判断线程池的线程是否都已经执行完毕
            if(executorService.isTerminated()){
                System.out.println("长度为：" + resultList.size());
                for(int i = 0; i< resultList.size(); i++){
                    try {
                        lastList.addAll(resultList.get(i).get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
                break;
            }
            System.out.println("还没完");
        }

        System.out.println(lastList.get(list.size()-1));//查看最后一个数
    }

    public static List<List<Integer>> splistList(List<Integer> list, int splitSize) {
        if (null == list) {
            return null;
        }
        int listSize = list.size();
        List<List<Integer>> newList = new ArrayList<List<Integer>>();
        if (listSize < splitSize) {
            newList.add(list);
            return newList;
        }
        int addLength = splitSize;
        int times = listSize / splitSize;
        if (listSize % splitSize != 0) {
            times += 1;
        }
        int start = 0;
        int end = 0;
        int last = times - 1;
        for (int i = 0; i < times; i++) {
            start = i * splitSize;
            if (i < last) {
                end = start + addLength;
            } else {
                end = listSize;
            }
            newList.add(list.subList(start, end));
        }
        return newList;
    }
}

