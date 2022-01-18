package com.sql.ehr.local.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sql.ehr.local.bean.GeneralEmployee;
import com.sql.ehr.local.core.bean.PageVo;
import com.sql.ehr.local.core.bean.QueryCondition;
import com.sql.ehr.local.entity.ArchivesEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 档案基本信息表
 *
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:06:22
 */
public interface ArchivesService extends IService<ArchivesEntity> {

    PageVo selectAllByPage(QueryCondition params);

    public PageVo selectAllByExport(HashMap<String,Object> map);

    PageVo selectAllByCondition(HashMap<String,Object> map);

    public List<Map> selectAllByConditionExport(HashMap<String,Object> map);

    public GeneralEmployee selectSingleRecordById(String eno);

    public List<Map> selectAllByExport();
}

