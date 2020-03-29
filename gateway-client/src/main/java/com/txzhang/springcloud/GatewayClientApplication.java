package com.txzhang.springcloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Slf4j
@SpringBootApplication
@RestController
@EnableHystrix
public class GatewayClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayClientApplication.class, args);
    }

//    @Bean
//    public RouteLocator myRoute(RouteLocatorBuilder builder) {
//        String httpUri = "http://httpbin.org:80";
//        return builder.routes()
//                .route(p -> p.path("/get")
//                        .filters(f -> f.addRequestHeader("name", "txzhang")
//                                .addRequestHeader("age", "23"))
//                        .uri(httpUri))
//                .route(p -> p.host("www.hystrix.com")
//                        .filters(f -> f.hystrix(config ->
//                                config.setName("mycmd").setFallbackUri("forward:/fallback")).addRequestHeader("Host", "*.hystrix.com"))
//                        .uri(httpUri))
//                .build();
//    }

    @GetMapping("/fallback")
    public String fallback(Boolean isSleep) {
        log.debug("参数 isSleep : {}", isSleep);
        return "hystrix common, fallback";
    }

    @HystrixCommand(fallbackMethod = "fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    @GetMapping("/test/fallback")
    public String index(@RequestParam(value = "isSleep", defaultValue = "true") Boolean isSleep) throws InterruptedException {
        log.info("是否睡眠：{}, 开始时间是：{}", isSleep, LocalDateTime.now());
        if (isSleep){
            TimeUnit.SECONDS.sleep(6);
        }
        log.info("结束时间是：{}", LocalDateTime.now());
        return "睡眠结束";
    }

}
