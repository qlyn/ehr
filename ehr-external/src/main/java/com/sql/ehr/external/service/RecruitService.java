package com.sql.ehr.external.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sql.ehr.external.core.bean.PageVo;
import com.sql.ehr.external.core.bean.QueryCondition;
import com.sql.ehr.external.dto.RecruitEntity;


/**
 * 
 *
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2020-07-06 23:04:32
 */
public interface RecruitService extends IService<RecruitEntity> {

    PageVo queryPage(QueryCondition params);
}

