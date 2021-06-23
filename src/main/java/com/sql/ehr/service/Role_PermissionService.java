package com.sql.ehr.service;

import com.sql.ehr.entity.PermissionEntity;

import java.util.List;

public interface Role_PermissionService {
    /**
     *根据角色id查的所拥有的权限
     * @param roleid
     * @return
     */
    public List<PermissionEntity> selectPermissionByRoleid(String roleid);
}
