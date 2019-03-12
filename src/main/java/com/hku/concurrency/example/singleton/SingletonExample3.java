package com.hku.concurrency.example.singleton;

import com.hku.concurrency.annoations.NotRecommend;
import com.hku.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 懒汉模式-双重同步锁单例模式
 * 多线程有问题
 */
@Slf4j
@NotThreadSafe
public class SingletonExample3 {
    //private constructor
    private SingletonExample3(){
    }
    //1、 memory = allocate()
    //2、 ctorInstance()初始化
    //3、 instance = memory使实例指向内存

    //JVM优化后，指令重排

    //1、 memory = allocate()
    //3、 instance = memory使实例指向内存
    //2、 ctorInstance()初始化

    //A还没有初始化，就被return
    //singleton instance
    private static SingletonExample3 instance = null;
    //static factory method
    public static SingletonExample3 getInstance(){
        if(instance == null){//双重检测                 //B
            synchronized (SingletonExample3.class) {//同步锁
                if(instance == null) {
                    instance = new SingletonExample3();//A-3
                }
            }
        }
        return instance;
    }
}
