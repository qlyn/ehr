package com.sql.ehr.service.impl;

import com.sql.ehr.core.bean.Query;
import com.sql.ehr.dao.Employee_RoleServiceDao;
import com.sql.ehr.entity.RoleEntity;
import com.sql.ehr.service.Employee_RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employee_RoleService")
public class Employee_RoleServiceImpl implements Employee_RoleService {
    @Autowired
    Employee_RoleServiceDao employee_roleServiceDao;

    @Override
    public List<RoleEntity> selectRoleListByEno(String eno) {
        return employee_roleServiceDao.selectRoleListByEno(eno);
    }

    @Override
    public List<RoleEntity> selectRoleListByEaccount(String eaccount) {
        return employee_roleServiceDao.selectRoleListByEaccount(eaccount);
    }

}
