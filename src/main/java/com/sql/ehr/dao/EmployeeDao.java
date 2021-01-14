package com.sql.ehr.dao;

import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.sql.ehr.bean.GeneralEmployee;
import com.sql.ehr.entity.DepartmentEntity;
import com.sql.ehr.entity.EmployeeEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2020-07-06 23:04:32
 */
@Mapper
@Repository
public interface EmployeeDao extends BaseMapper<EmployeeEntity> {
    @Select("SELECT e.*,dname,p.pname FROM employee e,department d,post p where e.edno=d.dno and e.epno=p.pno order by e.eno;")
    public List<GeneralEmployee> selectAll();


    @Select("SELECT COUNT(*) FROM employee e,department d,post p where e.edno=d.dno and e.epno=p.pno order by e.eno")
    public int selectTotalCountByTage();

    @Select("SELECT e.*,dname,p.pname FROM employee e,department d,post p where e.edno=d.dno and e.epno=p.pno order by e.eno " +
            "limit #{position},#{nums};")
    public List<GeneralEmployee> selectAllByPage(int position,int nums);

    @Select("SELECT e.*,dname,p.pname FROM employee e,department d,post p where e.edno=d.dno and e.epno=p.pno " +
            "and ename like #{ename} and egender like #{egender} and edno like #{edno} and epno like #{epno} order by e.eno;")
    List<GeneralEmployee> selectAllByCondition(HashMap<String,Object> map);

//    @Select("SELECT e.*,dname,p.pname FROM employee e,department d,post p where e.edno=d.dno and e.epno=p.pno " +
//            "and ename like #{ename} and egender like #{egender} and edno like #{edno} and epno like #{epno} order by e.eno;")
//    List<GeneralEmployee> selectAllByCondition(String ename, String egender, String edno, String epno);
}
