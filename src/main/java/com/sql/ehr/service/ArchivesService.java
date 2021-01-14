package com.sql.ehr.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sql.ehr.bean.GeneralEmployee;
import com.sql.ehr.entity.ArchivesEntity;
import com.sql.ehr.core.bean.PageVo;
import com.sql.ehr.core.bean.QueryCondition;

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
public interface ArchivesService extends IService<ArchivesEntity> {

    PageVo selectAllByPage(QueryCondition params);

    public PageVo selectAllByExport(HashMap<String,Object> map);

    PageVo selectAllByCondition(HashMap<String,Object> map);

    public List<Map> selectAllByConditionExport(HashMap<String,Object> map);

    public GeneralEmployee selectSingleRecordById(String eno);

    public List<Map> selectAllByExport();
}

