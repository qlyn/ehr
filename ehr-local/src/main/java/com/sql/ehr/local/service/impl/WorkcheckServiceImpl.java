package com.sql.ehr.local.service.impl;


import com.sql.ehr.local.core.bean.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sql.ehr.local.core.bean.PageVo;
import com.sql.ehr.local.core.bean.QueryCondition;
import com.sql.ehr.local.dao.WorkcheckDao;
import com.sql.ehr.local.entity.WorkcheckEntity;
import com.sql.ehr.local.service.WorkcheckService;
import org.springframework.stereotype.Service;

;


@Service("workcheckService")
public class WorkcheckServiceImpl extends ServiceImpl<WorkcheckDao, WorkcheckEntity> implements WorkcheckService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<WorkcheckEntity> page = this.page(
                new Query<WorkcheckEntity>().getPage(params),
                new QueryWrapper<WorkcheckEntity>()
        );

        return new PageVo(page);
    }

}