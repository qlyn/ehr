package com.sql.ehr.local.service.impl;


import com.sql.ehr.local.core.bean.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sql.ehr.local.core.bean.PageVo;
import com.sql.ehr.local.core.bean.QueryCondition;
import com.sql.ehr.local.dao.RoleDao;
import com.sql.ehr.local.entity.RoleEntity;
import com.sql.ehr.local.service.RoleService;
import org.springframework.stereotype.Service;

;


@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleDao, RoleEntity> implements RoleService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<RoleEntity> page = this.page(
                new Query<RoleEntity>().getPage(params),
                new QueryWrapper<RoleEntity>()
        );

        return new PageVo(page);
    }

}