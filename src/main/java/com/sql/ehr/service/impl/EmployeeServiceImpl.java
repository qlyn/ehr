package com.sql.ehr.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sql.ehr.bean.GeneralEmployee;
import com.sql.ehr.core.bean.PageVo;
import com.sql.ehr.core.bean.Query;
import com.sql.ehr.core.bean.QueryCondition;
import com.sql.ehr.dao.EmployeeDao;
import com.sql.ehr.entity.EmployeeEntity;
import com.sql.ehr.service.EmployeeService;
import com.sql.ehr.util.HashMapBeanTools;
import com.sql.ehr.util.IPageImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


@Service("employeeService")
public class EmployeeServiceImpl extends ServiceImpl<EmployeeDao, EmployeeEntity> implements EmployeeService {
    @Autowired
    EmployeeDao employeeDao;

    /**
     * 自定义分页查询，查询所有数据，返回GeneralEmployee对象
     * @param params
     * @return
     */
    @Override
    public PageVo selectAllByPage(QueryCondition params) {
        List<GeneralEmployee> list=employeeDao.selectAll();
        List<HashMap<String,Object>> hashMapList=new LinkedList<HashMap<String, Object>>();
        for (GeneralEmployee employee: list) {
            HashMap<String,Object> hashMap= (HashMap<String, Object>) HashMapBeanTools.objToHash(employee);
            hashMapList.add(hashMap);
        }
        return new PageVo(hashMapList,params);
    }
    /**
     * 导出查询，删除不必要的记录并返回
     * @param map
     * @return
     */
    @Override
    public PageVo selectAllByExport(HashMap<String, Object> map) {
        List<GeneralEmployee> list= employeeDao.selectAll();
        HashMap<String,Object>tmpMap=new HashMap<>();
        tmpMap.putAll(map);             //Java实现Map深拷贝只有HashMap.putAll，Map的=和putAll都是浅拷贝
        tmpMap.remove("limit");
        tmpMap.remove("page");
        System.out.println("list:"+list);
        System.out.println("tmpMap:"+tmpMap);
        List<HashMap<String, Object>> hashMapList = new LinkedList<HashMap<String, Object>>();
        List<GeneralEmployee> tmplist=new LinkedList<GeneralEmployee>();
        for (int i = 0; i < list.size(); i++) {
            GeneralEmployee employee = (GeneralEmployee) list.get(i);
            for (Map.Entry<String,Object> entry :tmpMap.entrySet()) {
                String str= (String) entry.getValue();
                if(str.equals(employee.getEno())){
                    tmplist.add(employee);
                }
            }
        }
        for (GeneralEmployee employee : tmplist) {
            HashMap<String, Object> hashMap = (HashMap<String, Object>) HashMapBeanTools.objToHash(employee);
            hashMapList.add(hashMap);
        }
        return new PageVo(hashMapList,map);
    }

    /**
     * 导出全部记录查询，封装后返回
     * @return
     */
    public List<Map> selectAllByExport() {
        List<GeneralEmployee> list= employeeDao.selectAll();
        List<Map> hashMapList = new LinkedList<>();
        for (GeneralEmployee employee : list) {
            HashMap<String, Object> hashMap = (HashMap<String, Object>) HashMapBeanTools.objToHash(employee);
            hashMapList.add(hashMap);
        }
        return hashMapList;
    }

    /**
     * 导出条件查询全部记录，封装后返回
     * @return
     */
    public List<Map> selectAllByConditionExport(HashMap<String,Object> map) {
        List<GeneralEmployee> list= employeeDao.selectAllByCondition(map);
        List<Map> hashMapList = new LinkedList<>();
        for (GeneralEmployee employee : list) {
            HashMap<String, Object> hashMap = (HashMap<String, Object>) HashMapBeanTools.objToHash(employee);
            hashMapList.add(hashMap);
        }
        return hashMapList;
    }

    /**
     * 条件查询
     * @param map
     * @return
     */
    public PageVo selectAllByCondition(HashMap<String,Object> map){
        List<GeneralEmployee> list=employeeDao.selectAllByCondition(map);
        List<HashMap<String,Object>> hashMapList=new LinkedList<HashMap<String, Object>>();
        for (GeneralEmployee employee: list) {
            HashMap<String,Object> hashMap= (HashMap<String, Object>) HashMapBeanTools.objToHash(employee);
            hashMapList.add(hashMap);
        }
        return new PageVo(hashMapList,map);
    }

    /**
     * 自定义分页查询，只查一页数据，返回GeneralEmployee对象（老的分页方法）
     * @param curr
     * @param nums
     * @return
     */
    @Override
    public PageVo selectAllByPage(int curr, int nums) {
        List<GeneralEmployee> list=employeeDao.selectAllByPage((curr-1)*nums,nums);
        return new PageVo(list,employeeDao.selectTotalCountByTage(),curr,nums);
    }

    /**
     * 根据查询参数对象调用mybatisplus查询，返回Employee对象,缺点：无法映射自定义Bean，在多表关联查询时鸡肋
     * @param params
     * @return
     */
    @Override
    public PageVo queryPage(QueryCondition params) {
        IPage<EmployeeEntity> page = this.page(
                new Query<EmployeeEntity>().getPage(params),
                new QueryWrapper<EmployeeEntity>()
        );
        return new PageVo(page);
    }


    /**
     * 条件查询(老的，废弃不使用)
     * @param ename
     * @param egender
     * @param edno
     * @param epno
     * @param queryCondition
     * @return
     */
//    @Override
//    public PageVo selectAllByCondition(String ename,String egender, String edno,  String epno,QueryCondition queryCondition) {
//        List<GeneralEmployee> list=employeeDao.selectAllByCondition(ename,egender,edno,epno);
//        return new PageVo(list,queryCondition);
//    }
}