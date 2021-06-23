package com.sql.ehr.service.impl;

import com.sql.ehr.dao.PermissionDao;
import com.sql.ehr.entity.PermissionEntity;
import com.sql.ehr.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Permission;
import java.util.LinkedList;
import java.util.List;

@Service("PermissionService")
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionDao permissionDao;
    @Override
    public List<PermissionEntity> selectParentPermissionList(List<PermissionEntity> perimissionList) {
        List<PermissionEntity> allPermision=permissionDao.selectAllPermission();//查找所有权限
        List<PermissionEntity> parentPermissionList=new LinkedList<PermissionEntity>(); //最后返回的包含的所有父权限列表（去重后的）
        for(PermissionEntity sonPermission: perimissionList){  //遍历子权限列表
            for(PermissionEntity tempParentPermission: allPermision){
                //如果子权限的父权限id等于遍历所有权限的id，并且父权限List没有添加该权限
                if(sonPermission.getParentId()!=null&&sonPermission.getParentId().equals(tempParentPermission.getPerssionid())&&!parentPermissionList.contains(tempParentPermission)){
                    parentPermissionList.add(tempParentPermission);
                }
            }
        }
        return parentPermissionList;
    }
}
