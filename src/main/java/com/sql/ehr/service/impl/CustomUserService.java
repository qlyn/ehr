package com.sql.ehr.service.impl;

import com.sql.ehr.dao.EmployeeDao;
import com.sql.ehr.dao.Employee_RoleServiceDao;
import com.sql.ehr.entity.EmployeeEntity;
import com.sql.ehr.entity.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * SpringSecurity用户角色关联数据类
 */
@Service
public class CustomUserService implements UserDetailsService { //自定义UserDetailsService 接口

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    Employee_RoleServiceDao employee_roleServiceDao;
    //loadUserByUsername方法将数据库用户角色权限添加至SpringSecurity中
    @Override
    public UserDetails loadUserByUsername(String username) { //重写loadUserByUsername 方法获得 userdetails 类型用户

        EmployeeEntity employee = employeeDao.selectByAccount(username);
        if(employee == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        //用于添加用户的权限。只要把用户权限添加到authorities 就万事大吉。
        for(RoleEntity role : employee_roleServiceDao.selectRoleListByEno(employee.getEno()))
        {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRolename()));//注意：权限要加上"ROLE_"，SpringSecurity规定，或者在数据库中就加上"ROLE_"
        }
        return new org.springframework.security.core.userdetails.User(employee.getEaccount(),
                employee.getEpassword(), authorities);
    }
}
