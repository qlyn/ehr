package com.sql.ehr.dao;

import com.sql.ehr.bean.GeneralEmployee;
import com.sql.ehr.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Employee_RoleServiceDao {

    @Select("SELECT r.* FROM role r,employee_role er where er.roleid=r.roleid and er.eno=#{eno};")
    public List<RoleEntity> selectRoleListByEno(String eno);
    @Select("SELECT r.* FROM role r,employee_role er where er.roleid=r.roleid and er.eno=(select eno from employee where eaccount=#{eaccount});")
    public List<RoleEntity> selectRoleListByEaccount(String eaccount);

}
