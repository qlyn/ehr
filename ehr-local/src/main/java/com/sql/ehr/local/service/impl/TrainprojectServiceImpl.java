package com.sql.ehr.local.service.impl;


import com.sql.ehr.local.core.bean.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sql.ehr.local.core.bean.PageVo;
import com.sql.ehr.local.core.bean.QueryCondition;
import com.sql.ehr.local.dao.TrainprojectDao;
import com.sql.ehr.local.entity.TrainprojectEntity;
import com.sql.ehr.local.service.TrainprojectService;
import org.springframework.stereotype.Service;

;


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