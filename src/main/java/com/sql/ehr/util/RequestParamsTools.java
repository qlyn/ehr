package com.sql.ehr.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestParamsTools {
    public static HashMap<String,Object> RequestParamsToMap(HttpServletRequest request){
        Map<String, String[]> map=request.getParameterMap();
        HashMap<String,Object> returMap=new HashMap<String, Object>();
        for (Map.Entry<String,String[]> entry:map.entrySet()) {
            String[] str=entry.getValue();
            List<String> list= Arrays.asList(str);
            returMap.put(entry.getKey(),list.get(0).toString());
        }
        addSymbol(returMap);
        return returMap;
    }

    //在sql查询参数添加%
    public static HashMap<String,Object> addSymbol(HashMap<String,Object> map){
        for (Map.Entry<String,Object> entry : map.entrySet()) {
            if(entry.getValue().equals("select"))
                entry.setValue("");
            else if(entry.getValue().equals(""))
                entry.setValue("%"+entry.getValue()+"%");
        }
        return map;
    }

    //在sql查询参数添加%
    public static void addSymbol(List<String> list){
        for (int i=0;i<list.size();i++) {
            list.set(i , "%"+list.get(i)+"%");
        }
    }
}
