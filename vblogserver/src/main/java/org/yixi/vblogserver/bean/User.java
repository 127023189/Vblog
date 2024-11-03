package org.yixi.vblogserver.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class User implements UserDetails {

    private Long id;
    private String username;

    private String password;

    private String nickname;
    private boolean enabled;

    private String email;
    private String userface;
    private Timestamp regTime;

    private List<Role> roles;

    public User() {
    }

    public User(Long id, String username, String password, String nickname, boolean enabled, String email, String userface, Timestamp regTime, List<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.enabled = enabled;
        this.email = email;
        this.userface = userface;
        this.regTime = regTime;
        this.roles = roles;
    }


    @Override
    @JsonIgnore
    public List<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for(Role role:roles){
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        }
        return authorities;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public String getPassword() {
        return  password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    /**
     * 获取
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 设置
     * @param enabled
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * 获取
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取
     * @return userface
     */
    public String getUserface() {
        return userface;
    }

    /**
     * 设置
     * @param userface
     */
    public void setUserface(String userface) {
        this.userface = userface;
    }

    /**
     * 获取
     * @return regTime
     */
    public Timestamp getRegTime() {
        return regTime;
    }

    /**
     * 设置
     * @param regTime
     */
    public void setRegTime(Timestamp regTime) {
        this.regTime = regTime;
    }

    /**
     * 获取
     * @return roles
     */
    public List<Role> getRoles() {
        return roles;
    }

    /**
     * 设置
     * @param roles
     */
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String toString() {
        return "User{id = " + id + ", username = " + username + ", password = " + password + ", nickname = " + nickname + ", enabled = " + enabled + ", email = " + email + ", userface = " + userface + ", regTime = " + regTime + ", roles = " + roles + "}";
    }
}
