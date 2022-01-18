package com.sql.ehr.local.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sql.ehr.local.core.bean.PageVo;
import com.sql.ehr.local.core.bean.QueryCondition;
import com.sql.ehr.local.entity.PermissionEntity;
import com.sql.ehr.local.entity.RolePermissionEntity;
import io.swagger.annotations.ApiOperation;

import java.util.List;


/**
 * 角色权限关联表（只关联最后的叶子菜单，即有跳转链接的菜单）
 *
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:06:22
 */
public interface RolePermissionService extends IService<RolePermissionEntity> {

    @ApiOperation("根据角色id查的所拥有的权限")
    public List<PermissionEntity> selectPermissionByRno(Integer rno);

    PageVo queryPage(QueryCondition params);
}

