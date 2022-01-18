package com.sql.ehr.local.service.impl;


import com.sql.ehr.local.core.bean.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sql.ehr.local.core.bean.PageVo;
import com.sql.ehr.local.core.bean.QueryCondition;
import com.sql.ehr.local.dao.DepartmentDao;
import com.sql.ehr.local.entity.DepartmentEntity;
import com.sql.ehr.local.service.DepartmentService;
import org.springframework.stereotype.Service;

;


@Service("departmentService")
public class DepartmentServiceImpl extends ServiceImpl<DepartmentDao, DepartmentEntity> implements DepartmentService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<DepartmentEntity> page = this.page(
                new Query<DepartmentEntity>().getPage(params),
                new QueryWrapper<DepartmentEntity>()
        );

        return new PageVo(page);
    }

}