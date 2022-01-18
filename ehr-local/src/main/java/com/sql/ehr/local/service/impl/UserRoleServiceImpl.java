package com.sql.ehr.local.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sql.ehr.local.core.bean.PageVo;
import com.sql.ehr.local.core.bean.Query;
import com.sql.ehr.local.core.bean.QueryCondition;
import com.sql.ehr.local.dao.UserRoleDao;
import com.sql.ehr.local.entity.RoleEntity;
import com.sql.ehr.local.entity.UserRoleEntity;
import com.sql.ehr.local.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("userRoleService")
public class UserRoleServiceImpl extends ServiceImpl<UserRoleDao, UserRoleEntity> implements UserRoleService {

    @Autowired
    UserRoleDao userRoleDao;


    @Override
    public List<RoleEntity> selectRoleListByUaccount(String uaccount) {
        return userRoleDao.selectRoleListByUaccount(uaccount);
    }


    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<UserRoleEntity> page = this.page(
                new Query<UserRoleEntity>().getPage(params),
                new QueryWrapper<UserRoleEntity>()
        );

        return new PageVo(page);
    }
}