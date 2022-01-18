package com.sql.ehr.local.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sql.ehr.local.core.bean.PageVo;
import com.sql.ehr.local.core.bean.Query;
import com.sql.ehr.local.core.bean.QueryCondition;
import com.sql.ehr.local.dao.TransferDao;
import com.sql.ehr.local.entity.TransferEntity;
import com.sql.ehr.local.service.TransferService;
import org.springframework.stereotype.Service;

;
;


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