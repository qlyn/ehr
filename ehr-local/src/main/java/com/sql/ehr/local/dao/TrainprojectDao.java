package com.sql.ehr.local.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sql.ehr.local.entity.TrainprojectEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 培训项目表
 * 
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:06:22
 */
@Mapper
@Repository
public interface TrainprojectDao extends BaseMapper<TrainprojectEntity> {
	
}
