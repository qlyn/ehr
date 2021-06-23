package com.sql.ehr.service.impl;

import com.sql.ehr.dao.Role_PermissionDao;
import com.sql.ehr.entity.PermissionEntity;
import com.sql.ehr.service.Role_PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("Role_PermissionService")
public class Role_PermissionServiceImpl implements Role_PermissionService {
    @Autowired
    private Role_PermissionDao role_permissionDao;

    @Override
    public List<PermissionEntity> selectPermissionByRoleid(String roleid) {
        return role_permissionDao.selectPermissionByRoleid(roleid);
    }
}
