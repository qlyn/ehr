package com.sql.ehr.local.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.sql.ehr.local.core.bean.PageVo;
import com.sql.ehr.local.core.bean.QueryCondition;
import com.sql.ehr.local.entity.PayEntity;


/**
 * 薪酬记录表
 *
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:02:17
 */
public interface PayService extends IService<PayEntity> {

    PageVo queryPage(QueryCondition params);
}

