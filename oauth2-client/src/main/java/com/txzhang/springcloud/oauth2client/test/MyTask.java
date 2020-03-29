package com.txzhang.springcloud.oauth2client.test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName：MyTask
 * @Author：txzhang
 * @Date：2020/3/17—13:20
 * @Description：
 **/
@Slf4j
public class MyTask {

    public static synchronized int getCount() {
        log.info("进入getCount方法...");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        final int[] a = {0};

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    log.info("开始计算总数...");
                    TimeUnit.SECONDS.sleep(1);
                    a[0] = 500;
                    log.info(""+  a[0]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            }
        }).start();
        try {
            countDownLatch.await(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("计算结束...");
        return a[0];
    }

    public static void main(String[] args) {
        System.out.println("return 结果是：" + getCount());;
    }
}
