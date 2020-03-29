package com.txzhang.springcloud.controller;

import com.txzhang.springcloud.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName：HiController
 * @Author：txzhang
 * @Date：2019/12/24—10:21
 * @Description：
 **/
@RestController
public class HiController {

    @Autowired
    private HiService hiService;

    @GetMapping("/hi")
    public String sayHi(@RequestParam(defaultValue = "txzhang", required = false) String name) {
        return hiService.sayHi(name);
    }
}
