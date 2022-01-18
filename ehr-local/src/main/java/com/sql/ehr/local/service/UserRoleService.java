package com.sql.ehr.local.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sql.ehr.local.core.bean.PageVo;
import com.sql.ehr.local.core.bean.QueryCondition;
import com.sql.ehr.local.entity.RoleEntity;
import com.sql.ehr.local.entity.UserRoleEntity;

import java.util.List;


/**
 * 用户角色表
 *
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:02:17
 */
public interface UserRoleService extends IService<UserRoleEntity> {

    /**
     * 根据用户用户名查的所拥有的角色
     * @param uaccount
     * @return
     */
    public List<RoleEntity> selectRoleListByUaccount(String uaccount);

    PageVo queryPage(QueryCondition params);
}

