package com.sql.ehr.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sql.ehr.core.bean.PageVo;
import com.sql.ehr.core.bean.Query;
import com.sql.ehr.core.bean.QueryCondition;

import com.sql.ehr.dao.ApplicationDao;
import com.sql.ehr.entity.ApplicationEntity;
import com.sql.ehr.service.ApplicationService;


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