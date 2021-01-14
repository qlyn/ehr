package com.sql.ehr.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sql.ehr.entity.PayEntity;
import com.sql.ehr.core.bean.PageVo;
import com.sql.ehr.core.bean.QueryCondition;


/**
 * 
 *
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2020-07-06 23:04:32
 */
public interface PayService extends IService<PayEntity> {

    PageVo queryPage(QueryCondition params);
}

