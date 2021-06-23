package com.sql.ehr.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    //认证失败处理类
    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    //自定义权限不足处理类
    @Resource
    private JwtAccessDeniedHandler jwtAccessDeniedHandler;

    //自定义认证成功处理器
    @Resource
    private MyAuthenticationSuccessHandler jwtAuthenticationSuccessHandler;

    //自定义认证失败处理类
    @Resource
    private LoginFailureHandler loginFailureHandler;

    //密码加密设置
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();   //无密码加密设置
        // return
    }

    // Token认证过滤器设置
    @Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
        return new JwtAuthenticationTokenFilter();
    }



    //AuthenticationManager：管理一系列的AuthenticationProvider，每一个Provider都会通UserDetailsService和UserDetail来返回一个
    //以UsernamePasswordAuthenticationToken实现的带用户名和密码以及权限的Authentication
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    //设置各种请求情况的处理器
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .formLogin()
                //自定义认证成功处理器
                .successHandler(jwtAuthenticationSuccessHandler)
                // 自定义失败处理器
                .failureHandler(loginFailureHandler)
                // 自定义登录拦截URI
                .loginProcessingUrl("/login")   //设置获取token接口
                .and()
                //token的验证方式不需要开启csrf的防护
                .csrf().disable()
                // 自定义认证处理器
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                // 自定义权限不足处理器
                .accessDeniedHandler(jwtAccessDeniedHandler)
                .and()
                //设置无状态的连接,即不创建session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers("/login").permitAll()  //放行login接口
                //配置允许匿名访问的路径
                .anyRequest().authenticated();
        // 解决跨域问题（重要）  只有在前端请求接口时才发现需要这个
        httpSecurity.cors().and().csrf().disable();


        //配置自己的jwt验证过滤器
        httpSecurity
                .addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);


        // disable page caching
        httpSecurity.headers().cacheControl();
    }
}