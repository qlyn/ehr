package com.sql.ehr.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sql.ehr.core.bean.PageVo;
import com.sql.ehr.core.bean.QueryCondition;
import com.sql.ehr.entity.EmployeeEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 
 *
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2020-07-06 23:04:32
 */
public interface EmployeeService extends IService<EmployeeEntity> {

    PageVo queryPage(QueryCondition params);

    PageVo selectAllByPage(QueryCondition params);

    public PageVo selectAllByPage(int curr, int nums);

    public PageVo selectAllByExport(HashMap<String,Object> map);

    public List<Map> selectAllByConditionExport(HashMap<String,Object> map);

    public List<Map> selectAllByExport();

    PageVo selectAllByCondition(HashMap<String,Object> map);

    public EmployeeEntity selectByAccount(String account);

//    PageVo selectAllByCondition(String ename, String egender, String edno, String epno,QueryCondition queryCondition);

}

