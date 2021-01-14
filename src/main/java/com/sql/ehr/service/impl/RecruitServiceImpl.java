package com.sql.ehr.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sql.ehr.core.bean.PageVo;
import com.sql.ehr.core.bean.Query;
import com.sql.ehr.core.bean.QueryCondition;

import com.sql.ehr.dao.RecruitDao;
import com.sql.ehr.entity.RecruitEntity;
import com.sql.ehr.service.RecruitService;


@Service("recruitService")
public class RecruitServiceImpl extends ServiceImpl<RecruitDao, RecruitEntity> implements RecruitService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<RecruitEntity> page = this.page(
                new Query<RecruitEntity>().getPage(params),
                new QueryWrapper<RecruitEntity>()
        );

        return new PageVo(page);
    }

}