package com.hku.concurrency.example.singleton;

import com.hku.concurrency.annoations.NotRecommend;
import com.hku.concurrency.annoations.NotThreadSafe;
import com.hku.concurrency.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 饿汉模式
 * 单例实例在类装载时创建
 * 可能有资源浪费（如果实例没有使用）
 */
@Slf4j
@ThreadSafe
public class SingletonExample2 {
    //private constructor
    private SingletonExample2(){

    }
    //singleton instance
    private static SingletonExample2 instance = new SingletonExample2();
    //static factory method
    public static SingletonExample2 getInstance(){
        return instance;
    }

}
