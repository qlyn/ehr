package com.sql.ehr.service;

import com.sql.ehr.entity.RoleEntity;

import java.util.List;

public interface Employee_RoleService {

    /**
     * 根据用户id查的所拥有的角色
     * @param eno
     * @return
     */
    public List<RoleEntity> selectRoleidByEno(String eno);
}
