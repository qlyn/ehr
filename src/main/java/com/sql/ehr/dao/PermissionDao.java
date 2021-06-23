package com.sql.ehr.dao;

import com.sql.ehr.entity.PermissionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PermissionDao {
    @Select("SELECT p.* from permission p")
    public List<PermissionEntity> selectAllPermission();
}
