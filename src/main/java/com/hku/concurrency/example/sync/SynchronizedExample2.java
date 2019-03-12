package com.hku.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SynchronizedExample2 {
    //修饰class
    public void test1(int k){
        synchronized (SynchronizedExample2.class) {
            for (int i = 0; i < 10; i++) {
                log.info("test1-example{}-{}", k, i);
            }
        }
    }

    //修饰静态方法
    public static synchronized void test2(int t){
        for (int i = 0; i<10; i++){
            log.info("test2-{}-{}",t,i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample2 synchronizedExample1 = new SynchronizedExample2();
        SynchronizedExample2 synchronizedExample2 = new SynchronizedExample2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        //启用线程池，可使两个线程同时启动
        executorService.execute(()->{
            synchronizedExample1.test1(1);
        });
        executorService.execute(()->{
            synchronizedExample2.test1(2);
        });

    }
}
