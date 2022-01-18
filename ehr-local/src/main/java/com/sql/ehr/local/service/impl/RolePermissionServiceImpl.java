package com.sql.ehr.local.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sql.ehr.local.core.bean.PageVo;
import com.sql.ehr.local.core.bean.Query;
import com.sql.ehr.local.core.bean.QueryCondition;
import com.sql.ehr.local.dao.RolePermissionDao;
import com.sql.ehr.local.entity.PermissionEntity;
import com.sql.ehr.local.entity.RolePermissionEntity;
import com.sql.ehr.local.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("rolePermissionService")
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionDao, RolePermissionEntity> implements RolePermissionService {

    @Autowired
    private RolePermissionDao rolePermissionDao;

    @Override
    public List<PermissionEntity> selectPermissionByRno(Integer rno) {
        return rolePermissionDao.selectPermissionByRno(rno);
    }


    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<RolePermissionEntity> page = this.page(
                new Query<RolePermissionEntity>().getPage(params),
                new QueryWrapper<RolePermissionEntity>()
        );

        return new PageVo(page);
    }
}