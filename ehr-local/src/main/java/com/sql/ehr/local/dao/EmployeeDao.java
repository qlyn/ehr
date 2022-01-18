package com.sql.ehr.local.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sql.ehr.local.bean.GeneralEmployee;
import com.sql.ehr.local.entity.EmployeeEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * 员工基本信息表
 * 
 * @author shenqinlin
 * @email 1392825484@qq.com
 * @date 2021-12-09 00:02:17
 */
@Mapper
@Repository
public interface EmployeeDao extends BaseMapper<EmployeeEntity> {

    public List<GeneralEmployee> selectAll();



    List<GeneralEmployee> selectAllByCondition(HashMap<String,Object> map);

    //废弃的分页方法
    @Select("SELECT e.*,name,p.name FROM employee e,department d,post p where e.department_no=d.no and e.post_no=p.no order by e.no " +
            "limit #{position},#{nums};")
    public List<GeneralEmployee> selectAllByPage(int position,int nums);

    //废弃的分页查询总记录数
    @Select("SELECT COUNT(*) FROM employee e,department d,post p where e.department_no=d.no and e.post_no=p.no order by e.no")
    public int selectTotalCountByTage();

}
