package org.yixi.vblogserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yixi.vblogserver.bean.RespBean;
import org.yixi.vblogserver.bean.User;
import org.yixi.vblogserver.service.UserService;
import org.yixi.vblogserver.utils.Util;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 获取当前用户名
     * @return
     */
    @GetMapping("/currentUserName")
    public String currentUserName(){
        return Util.getCurrentUser().getNickname();
    }

    /**
     * 获取当前用户id
     * @return
     */
    @GetMapping("/currentUserId")
    public Long currentUserId() {
        return Util.getCurrentUser().getId();
    }

    /**
     * 获取当前邮箱
     * @return
     */
    @GetMapping("/currentUserEmail")
    public String currentUserEmail() {
        return Util.getCurrentUser().getEmail();
    }

    @GetMapping("/isAdmin")
    public boolean isAdmin() {
        List<GrantedAuthority> authorities = Util.getCurrentUser().getAuthorities();
        return authorities.stream().anyMatch(authority->authority.getAuthority().contains("超级管理员")
        );
    }

    @PutMapping("/updateUserEmail")
    public RespBean updateUserEmail(String email) {
        Integer value = userService.updateUserEmail(email);
        if(value==1){
            return new RespBean("success","修改成功");
        }
        return new RespBean("error","修改失败");

    }


}
