package com.txzhang.springcloud.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName：FeignConfig
 * @Author：txzhang
 * @Date：2019/12/24—10:07
 * @Description：
 **/
@Configuration
public class FeignConfig {

    @Bean
    public Retryer FeignConfig() {
        return new Retryer.Default();
    }

}
