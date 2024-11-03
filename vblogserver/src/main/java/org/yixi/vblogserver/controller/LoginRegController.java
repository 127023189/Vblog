package org.yixi.vblogserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yixi.vblogserver.bean.RespBean;
import org.yixi.vblogserver.service.UserService;

@RestController
public class LoginRegController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login_page")
    public RespBean loginPage() {
        return new RespBean("error", "尚未登录，请登录!");
    }

    @RequestMapping("/login_error")
    public RespBean loginError() {
        return new RespBean("error", "登录失败!");
    }

    @RequestMapping("/login_success")
    public RespBean loginSuccess() {
        return new RespBean("success", "登录成功!");
    }
}
