package com.txzhang.springcloud.oauth2client.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName：ClientController
 * @Author：txzhang
 * @Date：2020/1/15—16:41
 * @Description：
 **/
@RestController
public class ClientController {

    @GetMapping("/normal")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String normal() {
        return "用户页面";
    }

    @GetMapping("/medium")
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public String medium() {
        return "这也是用户页面";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public String admin() {
        return "管理员页面";
    }

    @GetMapping("/login1")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")
    public String login1() {
        return "这是什么东西的登录页面！";
    }

    @GetMapping("/getInfo")
    public Authentication getInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication;
    }
}
