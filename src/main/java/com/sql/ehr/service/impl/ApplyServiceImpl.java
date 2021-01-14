package com.sql.ehr.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sql.ehr.core.bean.PageVo;
import com.sql.ehr.core.bean.Query;
import com.sql.ehr.core.bean.QueryCondition;

import com.sql.ehr.dao.ApplyDao;
import com.sql.ehr.entity.ApplyEntity;
import com.sql.ehr.service.ApplyService;


@Service("applyService")
public class ApplyServiceImpl extends ServiceImpl<ApplyDao, ApplyEntity> implements ApplyService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<ApplyEntity> page = this.page(
                new Query<ApplyEntity>().getPage(params),
                new QueryWrapper<ApplyEntity>()
        );

        return new PageVo(page);
    }

}