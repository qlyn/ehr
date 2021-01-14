package com.sql.ehr.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sql.ehr.core.bean.PageVo;
import com.sql.ehr.core.bean.Query;
import com.sql.ehr.core.bean.QueryCondition;

import com.sql.ehr.dao.TransferDao;
import com.sql.ehr.entity.TransferEntity;
import com.sql.ehr.service.TransferService;


@Service("transferService")
public class TransferServiceImpl extends ServiceImpl<TransferDao, TransferEntity> implements TransferService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<TransferEntity> page = this.page(
                new Query<TransferEntity>().getPage(params),
                new QueryWrapper<TransferEntity>()
        );

        return new PageVo(page);
    }

}