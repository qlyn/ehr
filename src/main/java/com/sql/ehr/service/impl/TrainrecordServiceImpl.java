package com.sql.ehr.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sql.ehr.core.bean.PageVo;
import com.sql.ehr.core.bean.Query;
import com.sql.ehr.core.bean.QueryCondition;

import com.sql.ehr.dao.TrainrecordDao;
import com.sql.ehr.entity.TrainrecordEntity;
import com.sql.ehr.service.TrainrecordService;


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