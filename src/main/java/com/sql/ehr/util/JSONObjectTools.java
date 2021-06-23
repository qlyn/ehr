package com.sql.ehr.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class JSONObjectTools {
    public static String objectToJSONOString(Object object){
        return JSON.toJSONString(object, SerializerFeature.WriteMapNullValue);
    }
}
