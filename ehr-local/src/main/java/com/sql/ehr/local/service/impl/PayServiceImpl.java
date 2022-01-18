package com.sql.ehr.local.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sql.ehr.local.core.bean.PageVo;
import com.sql.ehr.local.core.bean.Query;
import com.sql.ehr.local.core.bean.QueryCondition;
import com.sql.ehr.local.dao.PayDao;
import com.sql.ehr.local.entity.PayEntity;
import com.sql.ehr.local.service.PayService;
import org.springframework.stereotype.Service;

;


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