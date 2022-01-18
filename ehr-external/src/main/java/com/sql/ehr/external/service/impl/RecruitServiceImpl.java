package com.sql.ehr.external.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sql.ehr.external.core.bean.PageVo;
import com.sql.ehr.external.core.bean.Query;
import com.sql.ehr.external.core.bean.QueryCondition;
import com.sql.ehr.external.dao.RecruitDao;
import com.sql.ehr.external.dto.RecruitEntity;
import com.sql.ehr.external.service.RecruitService;
import org.springframework.stereotype.Service;


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