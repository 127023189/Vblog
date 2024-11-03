package org.yixi.vblogserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.yixi.vblogserver.bean.Role;
import org.yixi.vblogserver.bean.User;
import org.yixi.vblogserver.mapper.RolesMapper;
import org.yixi.vblogserver.mapper.UserMapper;
import org.yixi.vblogserver.utils.Util;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RolesMapper rolesMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //查询当前用户
        User user = userMapper.loadUserByUsername(s);
        if(user == null){
            return new User();
        }
        List<Role> roles = rolesMapper.getRolesByUid(user.getId());
        user.setRoles(roles);
        //将查到的权限
        return user;

    }

    /**
     * 修改用户邮箱
     * @param email
     */
    public Integer updateUserEmail(String email) {
        return userMapper.updateUserEmail(email, Util.getCurrentUser().getId());
    }

    public List<User> getUserByNickname(String nickname) {
        return userMapper.getUserByNickname(nickname);
    }

    public int updateUserEnabled(Boolean enabled, Long uid) {
        return userMapper.updateUserEnabled(enabled, uid);
    }

    public User getUserById(Long id) {
        return userMapper.getUserById(id);
    }

    public List<Role> getAllRole() {
        return userMapper.getAllRole();
    }

    public int deleteUser(Long id) {
        return userMapper.deleteUser(id);
    }
}
