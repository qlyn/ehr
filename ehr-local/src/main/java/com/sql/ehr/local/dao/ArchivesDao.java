package com.sql.ehr.local.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sql.ehr.local.bean.GeneralEmployee;
import com.sql.ehr.local.entity.ArchivesEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * 档案基本信息表
 * 
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:06:22
 */
@Mapper
@Repository
public interface ArchivesDao extends BaseMapper<ArchivesEntity> {
    @Select("SELECT e.*,dname,p.pname,a.* " +
            "FROM employee e,department d,post p,archives a " +
            "where e.department_dno=d.dno " +
            "and e.post_pno=p.pno " +
            "and a.employee_eno=e.eno " +
            "and e.eno=#{eno}" +
            "order by e.eno")
    public GeneralEmployee selectSingleRecordById(String eno);
    @Select("SELECT e.*,dname,p.pname,a.* " +
            "FROM employee e,department d,post p,archives a " +
            "where e.department_dno=d.dno " +
            "and e.post_pno=p.pno " +
            "and a.employee_eno=e.eno " +
            "order by e.eno")
    public List<GeneralEmployee> selectAll();

    @Select("SELECT e.*,dname,p.pname,a.* " +
            "FROM employee e,department d,post p,archives a " +
            "where e.department_dno=d.dno " +
            "and e.post_pno=p.pno " +
            "and a.employee_eno=e.eno " +
            "and e.post_pno like #{post_pno}"+
            "and e.department_dno like #{department_dno}"+
            "and e.egender like #{egender}"+
            "and e.ename like #{ename}"+
            "and a.aname like #{aname}"+
            "and a.ano like #{ano}")
    public List<GeneralEmployee> selectAllByCondition(HashMap<String,Object> map);
	
}
