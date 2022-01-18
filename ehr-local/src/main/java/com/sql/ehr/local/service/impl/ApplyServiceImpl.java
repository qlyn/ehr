package com.sql.ehr.local.service.impl;


import com.sql.ehr.local.core.bean.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sql.ehr.local.core.bean.PageVo;
import com.sql.ehr.local.core.bean.QueryCondition;
import com.sql.ehr.local.dao.ApplyDao;
import com.sql.ehr.local.entity.ApplyEntity;
import com.sql.ehr.local.service.ApplyService;
import org.springframework.stereotype.Service;

;


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