package com.sql.ehr.dao;

import com.sql.ehr.bean.GeneralEmployee;
import com.sql.ehr.entity.ArchivesEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * 
 * 
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2020-07-06 23:04:32
 */
@Mapper
@Repository
public interface ArchivesDao extends BaseMapper<ArchivesEntity> {
    @Select("SELECT e.*,dname,p.pname,a.* " +
            "FROM employee e,department d,post p,archives a " +
            "where e.edno=d.dno " +
            "and e.epno=p.pno " +
            "and a.aeno=e.eno " +
            "and e.eno=#{eno}" +
            "order by e.eno")
    public GeneralEmployee selectSingleRecordById(String eno);
    @Select("SELECT e.*,dname,p.pname,a.* " +
            "FROM employee e,department d,post p,archives a " +
            "where e.edno=d.dno " +
            "and e.epno=p.pno " +
            "and a.aeno=e.eno " +
            "order by e.eno")
    public List<GeneralEmployee> selectAll();

    @Select("SELECT e.*,dname,p.pname,a.* " +
            "FROM employee e,department d,post p,archives a " +
            "where e.edno=d.dno " +
            "and e.epno=p.pno " +
            "and a.aeno=e.eno " +
            "and e.epno like #{epno}"+
            "and e.edno like #{edno}"+
            "and e.egender like #{egender}"+
            "and e.ename like #{ename}"+
            "and a.aname like #{aname}"+
            "and a.ano like #{ano}")
    public List<GeneralEmployee> selectAllByCondition(HashMap<String,Object> map);
}
