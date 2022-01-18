package com.sql.ehr.local.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sql.ehr.local.core.bean.PageVo;
import com.sql.ehr.local.core.bean.Query;
import com.sql.ehr.local.core.bean.QueryCondition;
import com.sql.ehr.local.dao.TrainrecordDao;
import com.sql.ehr.local.entity.TrainrecordEntity;
import com.sql.ehr.local.service.TrainrecordService;
import org.springframework.stereotype.Service;

;


@Service("trainrecordService")
public class TrainrecordServiceImpl extends ServiceImpl<TrainrecordDao, TrainrecordEntity> implements TrainrecordService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<TrainrecordEntity> page = this.page(
                new Query<TrainrecordEntity>().getPage(params),
                new QueryWrapper<TrainrecordEntity>()
        );

        return new PageVo(page);
    }

}