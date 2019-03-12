package com.hku.concurrency.example.publish;

import com.hku.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
@NotThreadSafe
public class UnsafePublish {
    private String [] status = {"a","b","c"};

    public String[] getStatus() {
        return status;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish =new UnsafePublish();
        log.info("status:{}", Arrays.toString(unsafePublish.status));
        unsafePublish.getStatus()[0] = "e";
        log.info("status:{}",Arrays.toString(unsafePublish.status));
    }
}
