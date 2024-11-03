package org.yixi.vblogserver.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yixi.vblogserver.bean.RespBean;
import org.yixi.vblogserver.bean.Role;
import org.yixi.vblogserver.bean.User;
import org.yixi.vblogserver.service.CategoryService;
import org.yixi.vblogserver.service.UserService;

import java.util.List;

@RestController
@RequestMapping("admin")
public class UserManaController {
    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/user")
    public List<User> getUserByNickname(String nickname){
        return userService.getUserByNickname(nickname);
    }

    @PutMapping("/user/enabled")
    public RespBean updateUserEnabled(Boolean enabled, Long uid){
        if (userService.updateUserEnabled(enabled,uid)==1){
            return new RespBean("success","更新成功");
        }
        return new RespBean("error","更新失败");
    }
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/roles")
    public List<Role> getAllRole(){
        return userService.getAllRole();
    }

    @DeleteMapping("/user/{id}")
    public RespBean deleteUser(@PathVariable("id") Long id){
        if (userService.deleteUser(id)==1){
            return new RespBean("success","删除成功");
        }
        return new RespBean("error","删除失败");
    }




}
