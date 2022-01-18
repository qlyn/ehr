package com.sql.ehr.local.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sql.ehr.local.entity.ContractEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 合同基本信息表
 * 
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:02:17
 */
@Mapper
@Repository
public interface ContractDao extends BaseMapper<ContractEntity> {
	
}
