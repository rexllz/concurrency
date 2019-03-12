package com.hku.concurrency.example.singleton;

import com.hku.concurrency.annoations.NotRecommend;
import com.hku.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 懒汉模式
 * 多线程有问题
 * 多个线程都检测到空值，导致拿到不同的实例
 * Synchronized修饰getInstance可安全，但是性能降低
 */
@Slf4j
@NotRecommend
@NotThreadSafe
public class SingletonExample1 {
    //private constructor
    private SingletonExample1(){

    }
    //singleton instance
    private static SingletonExample1 instance = null;
    //static factory method
    public static SingletonExample1 getInstance(){
        if(instance == null){
            instance = new SingletonExample1();
        }
        return instance;
    }
}
