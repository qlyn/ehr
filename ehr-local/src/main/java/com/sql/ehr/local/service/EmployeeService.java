package com.sql.ehr.local.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sql.ehr.local.core.bean.PageVo;
import com.sql.ehr.local.core.bean.QueryCondition;
import com.sql.ehr.local.entity.EmployeeEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 员工基本信息表
 *
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:02:17
 */
public interface EmployeeService extends IService<EmployeeEntity> {

    PageVo queryPage(QueryCondition params);

    PageVo selectAllByPage(QueryCondition params);

    public PageVo selectAllByPage(int curr, int nums);

    public PageVo selectAllByExport(HashMap<String,Object> map);

    public List<Map> selectAllByConditionExport(HashMap<String,Object> map);

    public List<Map> selectAllByExport();

    PageVo selectAllByCondition(HashMap<String,Object> map);


}

