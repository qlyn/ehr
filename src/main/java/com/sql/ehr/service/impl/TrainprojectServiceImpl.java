package com.sql.ehr.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sql.ehr.core.bean.PageVo;
import com.sql.ehr.core.bean.Query;
import com.sql.ehr.core.bean.QueryCondition;

import com.sql.ehr.dao.TrainprojectDao;
import com.sql.ehr.entity.TrainprojectEntity;
import com.sql.ehr.service.TrainprojectService;


@Service("trainprojectService")
public class TrainprojectServiceImpl extends ServiceImpl<TrainprojectDao, TrainprojectEntity> implements TrainprojectService {

    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<TrainprojectEntity> page = this.page(
                new Query<TrainprojectEntity>().getPage(params),
                new QueryWrapper<TrainprojectEntity>()
        );

        return new PageVo(page);
    }

}