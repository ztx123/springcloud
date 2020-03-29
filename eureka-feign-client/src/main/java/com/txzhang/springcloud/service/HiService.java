package com.txzhang.springcloud.service;

import com.txzhang.springcloud.EurekaClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName：HiService
 * @Author：txzhang
 * @Date：2019/12/24—10:19
 * @Description：
 **/
@Service
public class HiService {

    @Autowired
    private EurekaClientFeign eurekaClientFeign;

    public String sayHi(String name) {
        return eurekaClientFeign.sayHiFromClientEureka(name);
    }
}
