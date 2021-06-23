package com.sql.webpages.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
    //设置登录用户、密码、角色（注意：此处和UserDetailsService方法俩种方法设置用户密码角色只能存在一个）
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                //withUser定义用户名，password定义密码，roles定义用户角色
//                // 如果需要配置多个用户，用 and 相连
//                .withUser("zhangsan")
//                .password("123").roles("admin");
//    }
    //web.ignoring() 用来配置忽略掉的 URL 地址，一般对于静态文件，我们可以采用此操作。
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/**", "/css/**","/images/**","/lib/**","/api/**","/content/**","/page/**");
    }
    //角色继承设置
    @Bean
    RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl hierarchy = new RoleHierarchyImpl();
        //角色继承设置前面需要加上ROLE_
        hierarchy.setHierarchy("ROLE_admin > ROLE_user");//设置admin角色继承user角色所有权限，即admin能访问user能访问的所有接口
        return hierarchy;
    }
    //设置登录页面、登录接口
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //配置用户可访问的接口路径，没有设置的路径默认所有认证后的用户都可访问
                //注意：如果Controller类前面有路径需加上该路径
                .antMatchers("/getData/admin/**").hasRole("admin")//如果请求路径满足 /admin/** 格式，则用户需要具备 admin 角色
                .antMatchers("/getData/user/**").hasRole("user")//如果请求路径满足 /user/** 格式，则用户需要具备 user 角色。

                .anyRequest().authenticated()
                //登录设置
                .and()
                .formLogin()
                .loginPage("/login.html")//设置默认登录页面
                .loginProcessingUrl("/doLogin")//设置提交登录的接口，与登录页面的<form>标签的action属性一致
                //.usernameParameter("name")//设置登录的用户名参数，默认为username，与登录页面的用户名输入框<input>的name属性一致
                //.passwordParameter("passwd")//设置登录的密码参数，默认为password，与登录页面的密码输入框<input>的name属性一致
                .successForwardUrl("/index")//设置登录成功跳转页面，需要在controller里定义对应的post接口（因为form表单为post请求）重定向页面，因为post接口无法返回页面只能重定向

                //注销登录设置
                .and()
                .logout()
                .logoutUrl("/logout")//设置注销登录接口，默认接口是 /logout，调用接口后会自动注销当前用户信息，可在首页的注销接口处调用该接口
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout","POST"))//goutRequestMatcher 方法不仅可以修改注销 URL，还可以修改请求方式，实际项目中，这个方法和 logoutUrl 任意设置一个即可。
                .logoutSuccessUrl("/login.html")//设置注销成功后要跳转的页面
                .deleteCookies()//删除Cookie
                .clearAuthentication(true)//clearAuthentication 和 invalidateHttpSession 分别表示清除认证信息和使 HttpSession 失效，默认可以不用配置，默认就会清除。
                .invalidateHttpSession(true)

                //以上为前后端未分离时的设置，以下为前后端分离设置
                //HttpServletRequest可以做服务端跳转，HttpServletResponse 可以做客户端跳转 ，返回 JSON 数据。
                // Authentication 参数则保存了我们刚刚登录成功的用户信息（密码会自动加密返回空值）。

                //登录成功后以JSON格式返回数据给前端处理
//                .successHandler((req, resp, authentication) -> {
//                    Object principal = authentication.getPrincipal();
//                    resp.setContentType("application/json;charset=utf-8");
//                    PrintWriter out = resp.getWriter();
//                    out.write(new ObjectMapper().writeValueAsString(principal));//将认证数据返回给前端
//                    out.flush();
//                    out.close();
//                })
                //登录失败后以JSON格式返回数据给前端处理
//                .failureHandler((req, resp, e) -> {
//                    resp.setContentType("application/json;charset=utf-8");
//                    PrintWriter out = resp.getWriter();
//                    String msg="";  //定义异常信息并返回
//                    if (e instanceof LockedException) {
//                        msg="账户被锁定，请联系管理员!";
//                    } else if (e instanceof CredentialsExpiredException) {
//                        msg="密码过期，请联系管理员!";
//                    } else if (e instanceof AccountExpiredException) {
//                        msg="账户过期，请联系管理员!";
//                    } else if (e instanceof DisabledException) {
//                        msg="账户被禁用，请联系管理员!";
//                    } else if (e instanceof BadCredentialsException) {
//                        msg="用户名或者密码输入错误，请重新输入!";
//                    }
//                    out.write(new ObjectMapper().writeValueAsString(msg));
//                    out.flush();
//                    out.close();
//                })

                //注销登录后以JSON格式返回数据给前端处理
//                .and()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessHandler((req, resp, authentication) -> {
//                    resp.setContentType("application/json;charset=utf-8");
//                    PrintWriter out = resp.getWriter();
//                    out.write("注销成功");
//                    out.flush();
//                    out.close();
//                })

                .permitAll()
                .and()
                //去除跨域限制
                .csrf().disable()
                //未认证处理：默认情况下未认证会重定向到登录页面，但在前后端分离项目时此时未认证还无法返回登录页面，所以需要如下设置
                //            返回以下JSON提示由前端去进行页面跳转
//                .exceptionHandling()
//                .authenticationEntryPoint((req, resp, authException) -> {
//                            resp.setContentType("application/json;charset=utf-8");
//                            PrintWriter out = resp.getWriter();
//                            out.write("尚未登录，请先登录");
//                            out.flush();
//                            out.close();
//                        }
//                )
                ;
    }
    //配置多个用户角色信息
    @Bean
    protected UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("zhangsan").password("123").roles("admin").build());
        manager.createUser(User.withUsername("lisi").password("1234").roles("user").build());
        return manager;
    }
}