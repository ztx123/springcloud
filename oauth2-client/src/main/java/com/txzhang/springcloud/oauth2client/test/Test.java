package com.txzhang.springcloud.oauth2client.test;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName：Test
 * @Author：txzhang
 * @Date：2020/3/17—13:20
 * @Description：
 **/
@Slf4j
public class Test {

    public static void main(String[] args) {
        log.info("获取到的总数是：{}", MyTask.getCount());
    }
}
