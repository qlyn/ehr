package com.sql.ehr.service;

import com.sql.ehr.entity.PermissionEntity;

import java.util.List;

public interface PermissionService {
    /**
     * 根据子菜单查询父菜单列表
     * @return
     */
    public List<PermissionEntity> selectParentPermissionList(List<PermissionEntity> perimissionList);
}
