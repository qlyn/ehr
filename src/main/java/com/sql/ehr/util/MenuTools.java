package com.sql.ehr.util;

import com.sql.ehr.bean.Menu;
import com.sql.ehr.entity.PermissionEntity;
import com.sql.ehr.entity.RoleEntity;
import com.sql.ehr.service.Employee_RoleService;
import com.sql.ehr.service.PermissionService;
import com.sql.ehr.service.Role_PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Component
public class MenuTools {
    @Autowired
    Employee_RoleService employee_roleService;
    @Autowired
    Role_PermissionService role_permissionService;
    @Autowired
    PermissionService permissionService;

    /**
     * 传入用户拥有的权限生成菜单
     * @param permissionList
     * @return
     */
    public Map<String,Object> createMenu(List<PermissionEntity> permissionList){
        Map<String, Object> map = new HashMap<>(16);
        Menu.HomeInfo homeInfo=new Menu.HomeInfo();
        homeInfo.setTitle("首页");
        homeInfo.setHref("page/welcome-1.html?t=1");
        Menu.LogoInfo logoInfo=new Menu.LogoInfo();
        logoInfo.setHref("");
        logoInfo.setImage("images/logo.png");
        logoInfo.setTitle("XXX人力资源管理系统");
        map.put("homeInfo", homeInfo);
        map.put("logoInfo", logoInfo);
        map.put("menuInfo", structureTree(permissionList));
        return map;
    }

    /**
     * 构建菜单树（从叶子往上逐层构建）
     * @param sonList
     * @return
     */
    public List<PermissionEntity> structureTree(List<PermissionEntity> sonList){
        List<PermissionEntity> parentList=permissionService.selectParentPermissionList(sonList);//查询当前传入子菜单的父菜单List
        if(parentList==null||parentList.size()==0){ //递归结束，当前子菜单的父菜单为空
            return sonList;
        }
        for(PermissionEntity parentNode: parentList){   //遍历父菜单节点
            List<PermissionEntity> belongParentList=new LinkedList<PermissionEntity>(); //存放当前父菜单节点的子菜单列表
            for(PermissionEntity sonNode: sonList){
                //如果当前子菜单节点的父菜单id字段与当前父菜单节点的id相同，并且当前子菜单从未被添加，则将其添加
                if(sonNode.getParentId().equals(parentNode.getPerssionid())&&!belongParentList.contains(sonNode.getPerssionid())){
                    //System.out.println("添加节点");
                    belongParentList.add(sonNode);
                }
            }
            //将当前子菜单节点List设置为父菜单节点的Child属性
            parentNode.setChild(belongParentList);
        }
//        System.out.println("parentList:"+parentList);
//        System.out.println("parentList:"+JSONObjectTools.objectToJSONOString(parentList));
        parentList=structureTree(parentList);
        return parentList;
    }


}
