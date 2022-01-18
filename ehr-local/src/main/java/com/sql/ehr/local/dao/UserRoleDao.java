package com.sql.ehr.local.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sql.ehr.local.entity.RoleEntity;
import com.sql.ehr.local.entity.UserRoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户角色表
 * 
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:02:17
 */
@Mapper
@Repository
public interface UserRoleDao extends BaseMapper<UserRoleEntity> {

    @Select("SELECT r.* FROM role r,user_role ur where ur.role_rno=r.rno and ur.user_uno=#{uno};")
    public List<RoleEntity> selectRoleListByUno(String uno);

    @Select("SELECT r.* FROM role r,user_role ur where ur.role_rno=r.rno and ur.user_uno=(select uno from user where uaccount=#{uaccount});")
    public List<RoleEntity> selectRoleListByUaccount(String uaccount);
}
