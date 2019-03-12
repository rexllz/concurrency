package com.hku.concurrency.example.singleton;

import com.hku.concurrency.annoations.NotThreadSafe;
import com.hku.concurrency.annoations.Recommend;
import com.hku.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 枚举模式
 * 安全且无资源浪费
 */
@Slf4j
@ThreadSafe
@Recommend
public class SingletonExample4 {
    //private constructor
    private SingletonExample4(){
    }
    public static SingletonExample4 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }
    private enum Singleton{
        INSTANCE;
        private SingletonExample4 singleton;
        //JVM保证这个方法只被调用一次
        Singleton(){
            singleton = new SingletonExample4();
        }
        public SingletonExample4 getInstance(){
            return singleton;
        }
    }
}

