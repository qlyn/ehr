package com.sql.ehr.external.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sql.ehr.external.dto.ApplicationEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 应聘信息表
 * 
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-08 23:57:13
 */
@Mapper
@Repository
public interface ApplicationDao extends BaseMapper<ApplicationEntity> {
	
}
