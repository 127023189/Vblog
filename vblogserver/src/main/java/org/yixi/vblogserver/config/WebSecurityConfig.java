package org.yixi.vblogserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.yixi.vblogserver.service.UserService;

import java.io.PrintWriter;
import java.nio.file.AccessDeniedException;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }


    @Override
    public void configure(WebSecurity web) throws Exception {
        //不拦截这些
        web.ignoring().antMatchers("/blogimg/**","/index.html","/static/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
           .anyRequest().authenticated()
                .and().formLogin().loginPage("/login_page").successHandler((req,rep,authentication)->{
                    rep.setContentType("application/json;charset=utf-8");
                    PrintWriter out = rep.getWriter();
                    out.write("{\"status\":\"success\",\"msg\":\"登录成功\"}");
                    out.flush();
                    out.close();
                }).failureHandler((req, res, e) -> {
                            res.setContentType("application/json;charset=utf-8");
                            PrintWriter out = res.getWriter();
                            out.write("{\"status\":\"error\",\"msg\":\"登录失败\"}");
                            out.flush();
                            out.close();
                        }).loginProcessingUrl("/login")
                .usernameParameter("username").passwordParameter("password")
                .and().logout().permitAll().and().csrf().disable().exceptionHandling().accessDeniedHandler(getAccessDeniedHandler());

    }
    AccessDeniedHandler getAccessDeniedHandler(){
        return new AuthenticationAccessDeniedHandler();
    }
}
