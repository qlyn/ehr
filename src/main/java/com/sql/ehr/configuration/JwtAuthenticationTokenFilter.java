package com.sql.ehr.configuration;

import com.sql.ehr.service.impl.CustomUserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Token认证过滤器：会拦截所有请求
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    //自定义用户角色关联数据类
    @Resource
    private CustomUserService userDetailsService;
    //token工具类
    @Resource
    private JwtTokenUtils jwtTokenUtil;
    //token设置类
    @Resource
    private JwtProperties jwtProperties;


    /**
     * 请求拦截方法：任何请求（包括SecurityConfig的token获取请求）都会被其拦截
     * @param httpServletRequest
     * @param httpServletResponse
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        //如果在前端测试时出现跨域问题，到收藏的博客里面看一看

        String requestUrl = httpServletRequest.getRequestURI();
        //从请求头里取出token
        String authToken = httpServletRequest.getHeader(jwtProperties.getHeader());
        if(authToken==null||authToken.equals("")){  //导出的表格使用<form>表格模式，无法添加header请求头
            authToken=httpServletRequest.getParameter(jwtProperties.getHeader());
        }
        //从token取出用户名
        String stuId = jwtTokenUtil.getUsernameFromToken(authToken);


        System.out.println("进入自定义过滤器，自定义过滤器获得用户名为   "+stuId);

        //当token中的username不为空时进行验证token是否是有效的token
        if (stuId != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            //token中username不为空，并且Context中的认证为空，进行token验证
            //TODO,从数据库得到带有密码的完整user信息
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(stuId);


            if (jwtTokenUtil.validateToken(authToken, userDetails)) { //如username不为空，并且能够在数据库中查到
                /**
                 * UsernamePasswordAuthenticationToken继承AbstractAuthenticationToken实现Authentication
                 * 所以当在页面中输入用户名和密码之后首先会进入到UsernamePasswordAuthenticationToken验证(Authentication)，
                 * 然后生成的Authentication会被交由AuthenticationManager来进行管理
                 * 而AuthenticationManager管理一系列的AuthenticationProvider，
                 * 而每一个Provider都会通UserDetailsService和UserDetail来返回一个
                 * 以UsernamePasswordAuthenticationToken实现的带用户名和密码以及权限的Authentication
                 */
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));


                //将authentication放入SecurityContextHolder中
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
