package com.sql.ehr.external.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sql.ehr.external.dto.ApplicationEntity;
import com.sql.ehr.external.core.bean.PageVo;
import com.sql.ehr.external.core.bean.QueryCondition;
import org.springframework.stereotype.Service;


/**
 * 
 *
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2020-07-06 23:04:32
 */
@Service
public interface ApplicationService extends IService<ApplicationEntity> {

    PageVo queryPage(QueryCondition params);
}

