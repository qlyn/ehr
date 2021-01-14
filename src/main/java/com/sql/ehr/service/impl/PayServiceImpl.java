package com.sql.ehr.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sql.ehr.core.bean.PageVo;
import com.sql.ehr.core.bean.Query;
import com.sql.ehr.core.bean.QueryCondition;

import com.sql.ehr.dao.PayDao;
import com.sql.ehr.entity.PayEntity;
import com.sql.ehr.service.PayService;


@Service("payService")
public class PayServiceImpl extends ServiceImpl<PayDao, PayEntity> implements PayService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<PayEntity> page = this.page(
                new Query<PayEntity>().getPage(params),
                new QueryWrapper<PayEntity>()
        );

        return new PageVo(page);
    }

}