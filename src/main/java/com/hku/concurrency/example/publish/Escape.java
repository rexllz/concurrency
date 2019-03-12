package com.hku.concurrency.example.publish;

import com.hku.concurrency.annoations.NotRecommend;
import com.hku.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {
    private int escapeIt = 0;
    public Escape(){
        new InnerClass();
    }
    private class InnerClass{
        public InnerClass(){
            log.info("{}",Escape.this.escapeIt);
        }
    }
    //对象溢出，在该对象构造完成之前，就已经对他发布，使其对外可见
    public static void main(String[] args) {
        new Escape();
    }
}
