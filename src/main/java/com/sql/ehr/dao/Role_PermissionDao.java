package com.sql.ehr.dao;

import com.sql.ehr.entity.PermissionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Role_PermissionDao {

    @Select("SELECT p.* FROM permission p,role_permission rp where rp.perssionid=p.perssionid and rp.roleid=#{roleid};")
    public List<PermissionEntity> selectPermissionByRoleid(String roleid);
}
