package com.sql.ehr.service;

import com.sql.ehr.entity.RoleEntity;

import java.util.List;

public interface Employee_RoleService {

    /**
     * 根据用户id查的所拥有的角色
     * @param eno
     * @return
     */
    public List<RoleEntity> selectRoleListByEno(String eno);
    /**
     * 根据用户用户名查的所拥有的角色
     * @param eaccount
     * @return
     */
    public List<RoleEntity> selectRoleListByEaccount(String eaccount);
}
