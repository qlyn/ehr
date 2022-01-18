package com.sql.ehr.local.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sql.ehr.local.core.bean.PageVo;
import com.sql.ehr.local.core.bean.QueryCondition;
import com.sql.ehr.local.entity.ApplyEntity;


/**
 * 员工申请职称信息表
 *
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:06:22
 */
public interface ApplyService extends IService<ApplyEntity> {

    PageVo queryPage(QueryCondition params);
}

