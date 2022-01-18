package com.sql.ehr.external.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sql.ehr.external.dto.ApplicationEntity;
import com.sql.ehr.external.core.bean.PageVo;
import com.sql.ehr.external.core.bean.Query;
import com.sql.ehr.external.core.bean.QueryCondition;
import com.sql.ehr.external.dao.ApplicationDao;
import com.sql.ehr.external.service.ApplicationService;
import org.springframework.stereotype.Service;


@Service("applicationService")
public class ApplicationServiceImpl extends ServiceImpl<ApplicationDao, ApplicationEntity> implements ApplicationService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<ApplicationEntity> page = this.page(
                new Query<ApplicationEntity>().getPage(params),
                new QueryWrapper<ApplicationEntity>()
        );

        return new PageVo(page);
    }

}