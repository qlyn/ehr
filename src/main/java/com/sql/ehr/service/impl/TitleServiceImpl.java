package com.sql.ehr.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sql.ehr.core.bean.PageVo;
import com.sql.ehr.core.bean.Query;
import com.sql.ehr.core.bean.QueryCondition;

import com.sql.ehr.dao.TitleDao;
import com.sql.ehr.entity.TitleEntity;
import com.sql.ehr.service.TitleService;


@Service("titleService")
public class TitleServiceImpl extends ServiceImpl<TitleDao, TitleEntity> implements TitleService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<TitleEntity> page = this.page(
                new Query<TitleEntity>().getPage(params),
                new QueryWrapper<TitleEntity>()
        );

        return new PageVo(page);
    }

}