package com.sql.ehr.local.service.impl;


import com.sql.ehr.local.core.bean.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sql.ehr.local.core.bean.PageVo;
import com.sql.ehr.local.core.bean.QueryCondition;
import com.sql.ehr.local.dao.ContractDao;
import com.sql.ehr.local.entity.ContractEntity;
import com.sql.ehr.local.service.ContractService;
import org.springframework.stereotype.Service;

;


@Service("contractService")
public class ContractServiceImpl extends ServiceImpl<ContractDao, ContractEntity> implements ContractService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<ContractEntity> page = this.page(
                new Query<ContractEntity>().getPage(params),
                new QueryWrapper<ContractEntity>()
        );

        return new PageVo(page);
    }

}