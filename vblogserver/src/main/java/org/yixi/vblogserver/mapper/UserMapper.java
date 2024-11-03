package org.yixi.vblogserver.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.yixi.vblogserver.bean.Role;
import org.yixi.vblogserver.bean.User;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    User loadUserByUsername(@Param("username") String username);

    /**
     * 修改用户邮箱
     * @param email
     * @param id
     */
    Integer updateUserEmail(@Param("email") String email,@Param("id") Long id);

    /**
     * 根据昵称查询用户
     * @param nickname
     * @return
     */
    List<User> getUserByNickname(@Param("nickname") String nickname);

    /**
     * 修改用户状态
     * @param enabled
     * @param uid
     * @return
     */
    int updateUserEnabled(@Param("enabled") Boolean enabled,@Param("uid") Long uid);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User getUserById(@Param("id") Long id);

    /**
     * 查询所有角色
     * @return
     */
    List<Role> getAllRole();

    /**
     * 删除用户
     * @param id
     * @return
     */
    int deleteUser(Long id);
}
