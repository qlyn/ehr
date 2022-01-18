package com.sql.ehr.local.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.sql.ehr.local.core.bean.PageVo;
import com.sql.ehr.local.core.bean.QueryCondition;
import com.sql.ehr.local.entity.TrainprojectEntity;


/**
 * 培训项目表
 *
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:06:22
 */
public interface TrainprojectService extends IService<TrainprojectEntity> {

    PageVo queryPage(QueryCondition params);
}

