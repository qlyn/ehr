package com.sql.ehr.local.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sql.ehr.local.entity.PermissionEntity;
import com.sql.ehr.local.entity.RolePermissionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 角色权限关联表（只关联最后的叶子菜单，即有跳转链接的菜单）
 * 
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:06:22
 */
@Mapper
@Repository
public interface RolePermissionDao extends BaseMapper<RolePermissionEntity> {

    @Select("SELECT p.* FROM permission p,role_permission rp where rp.permission_pno=p.pno and rp.role_rno=#{rno};")
    public List<PermissionEntity> selectPermissionByRno(Integer rno);
	
}
