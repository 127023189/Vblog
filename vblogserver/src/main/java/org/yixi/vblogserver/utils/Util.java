package org.yixi.vblogserver.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.yixi.vblogserver.bean.User;

public class Util {

    /**
     * 获取当前经过认证的用户
     * @return
     */
    public static User getCurrentUser(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user;
    }
}
