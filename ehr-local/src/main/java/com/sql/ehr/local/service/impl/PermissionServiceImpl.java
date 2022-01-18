package com.sql.ehr.local.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sql.ehr.local.core.bean.PageVo;
import com.sql.ehr.local.core.bean.Query;
import com.sql.ehr.local.core.bean.QueryCondition;
import com.sql.ehr.local.dao.PermissionDao;
import com.sql.ehr.local.entity.PermissionEntity;
import com.sql.ehr.local.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;


@Service("permissionService")
public class PermissionServiceImpl extends ServiceImpl<PermissionDao, PermissionEntity> implements PermissionService {
    @Autowired
    PermissionDao permissionDao;
    @Override
    public List<PermissionEntity> selectParentPermissionList(List<PermissionEntity> perimissionList) {
        List<PermissionEntity> allPermision=permissionDao.selectAllPermission();//查找所有权限
        List<PermissionEntity> parentPermissionList=new LinkedList<PermissionEntity>(); //最后返回的包含的所有父权限列表（去重后的）
        for(PermissionEntity sonPermission: perimissionList){  //遍历子权限列表
            for(PermissionEntity tempParentPermission: allPermision){
                //如果子权限的父权限id等于遍历所有权限的id，并且父权限List没有添加该权限
                if(sonPermission.getParentno()!=null&&sonPermission.getParentno().equals(tempParentPermission.getPno())&&!parentPermissionList.contains(tempParentPermission)){
                    parentPermissionList.add(tempParentPermission);
                }
            }
        }
        return parentPermissionList;
    }


    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<PermissionEntity> page = this.page(
                new Query<PermissionEntity>().getPage(params),
                new QueryWrapper<PermissionEntity>()
        );
        return new PageVo(page);
    }

}