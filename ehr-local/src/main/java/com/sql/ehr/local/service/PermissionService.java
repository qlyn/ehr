package com.sql.ehr.local.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sql.ehr.local.core.bean.PageVo;
import com.sql.ehr.local.core.bean.QueryCondition;
import com.sql.ehr.local.entity.PermissionEntity;

import java.util.List;


/**
 * 权限表（菜单表）
 *
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:02:17
 */
public interface PermissionService extends IService<PermissionEntity> {
    /**
     * 根据子菜单查询父菜单列表
     * @return
     */
    public List<PermissionEntity> selectParentPermissionList(List<PermissionEntity> perimissionList);

    PageVo queryPage(QueryCondition params);
}

