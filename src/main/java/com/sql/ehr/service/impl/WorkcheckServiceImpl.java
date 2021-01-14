package com.sql.ehr.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sql.ehr.core.bean.PageVo;
import com.sql.ehr.core.bean.Query;
import com.sql.ehr.core.bean.QueryCondition;

import com.sql.ehr.dao.WorkcheckDao;
import com.sql.ehr.entity.WorkcheckEntity;
import com.sql.ehr.service.WorkcheckService;


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