package com.sql.ehr.service.impl;

import com.sql.ehr.bean.GeneralEmployee;
import com.sql.ehr.util.HashMapBeanTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sql.ehr.core.bean.PageVo;
import com.sql.ehr.core.bean.Query;
import com.sql.ehr.core.bean.QueryCondition;

import com.sql.ehr.dao.ArchivesDao;
import com.sql.ehr.entity.ArchivesEntity;
import com.sql.ehr.service.ArchivesService;


@Service("archivesService")
public class ArchivesServiceImpl extends ServiceImpl<ArchivesDao, ArchivesEntity> implements ArchivesService {
    @Autowired
    ArchivesDao archivesDao;

    /**
     * 根据主键返回单条通用记录
     * @param eno
     * @return
     */
    public GeneralEmployee selectSingleRecordById(String eno){
        return archivesDao.selectSingleRecordById(eno);
    }
    /**
     * 条件查询
     * @param map
     * @return
     */
    @Override
    public PageVo selectAllByCondition(HashMap<String,Object> map) {
        List<GeneralEmployee> list=archivesDao.selectAllByCondition(map);
        List<HashMap<String,Object>> hashMapList=new LinkedList<HashMap<String, Object>>();
        for (GeneralEmployee employee: list) {
            HashMap<String,Object> hashMap= (HashMap<String, Object>) HashMapBeanTools.objToHash(employee);
            hashMapList.add(hashMap);
        }
        return new PageVo(hashMapList,map);
    }

    /**
     * 部分导出查询，删除不必要的记录并返回
     * @param map
     * @return
     */
    @Override
    public PageVo selectAllByExport(HashMap<String,Object> map) {
        List<GeneralEmployee> list= archivesDao.selectAll();
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
     * 导出条件查询全部记录，封装后返回
     * @return
     */
    public List<Map> selectAllByConditionExport(HashMap<String,Object> map) {
        List<GeneralEmployee> list= archivesDao.selectAllByCondition(map);
        List<Map> hashMapList = new LinkedList<>();
        for (GeneralEmployee employee : list) {
            HashMap<String, Object> hashMap = (HashMap<String, Object>) HashMapBeanTools.objToHash(employee);
            hashMapList.add(hashMap);
        }
        return hashMapList;
    }
    /**
     * 全部导出查询
     * @return
     */
    public List<Map> selectAllByExport() {
        List<GeneralEmployee> list= archivesDao.selectAll();
        List<Map> hashMapList = new LinkedList<>();
        for (GeneralEmployee employee : list) {
            HashMap<String, Object> hashMap = (HashMap<String, Object>) HashMapBeanTools.objToHash(employee);
            hashMapList.add(hashMap);
        }
        return hashMapList;
    }
    /**
     *
     * @param params
     * @return
     */
    @Override
    public PageVo selectAllByPage(QueryCondition params) {
        List<GeneralEmployee> list=archivesDao.selectAll();
        List<HashMap<String,Object>> hashMapList=new LinkedList<HashMap<String, Object>>();
        for (GeneralEmployee employee: list) {
            HashMap<String,Object> hashMap= (HashMap<String, Object>) HashMapBeanTools.objToHash(employee);
            hashMapList.add(hashMap);
        }
        return new PageVo(hashMapList,params);
    }


}