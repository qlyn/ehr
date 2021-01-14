package com.sql.ehr.dao;

import com.sql.ehr.bean.GeneralEmployee;
import com.sql.ehr.core.bean.QueryCondition;
import com.sql.ehr.entity.PostEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import javafx.geometry.Pos;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 
 * 
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2020-07-06 23:04:32
 */
@Mapper
public interface PostDao extends BaseMapper<PostEntity> {
}
