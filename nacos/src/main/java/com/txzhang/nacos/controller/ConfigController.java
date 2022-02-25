package com.txzhang.nacos.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.txzhang.nacos.entity.Meeting;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author txzhang
 * @date 2022/2/24 11:02
 */
@Controller
@RequestMapping("config")
public class ConfigController {

    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;
    @Resource
    private Meeting meeting;

    @RequestMapping(value = "/get", method = GET)
    @ResponseBody
    public boolean get() {
        return useLocalCache;
    }

    @RequestMapping(value = "/meeting", method = GET)
    @ResponseBody
    public Object meeting() {
        return meeting.toString();
    }
}
