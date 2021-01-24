package com.sql.ehr.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.sql.ehr.core.bean.PageVo;
import com.sql.ehr.core.bean.Resp;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class RedisTools {
    @Resource
    public RedisTemplate redisTemplate;            //操作的key可以是对象

    @Resource
    public StringRedisTemplate stringRedisTemplate;    //操作的key必须是字符串

    //存数据
    public void set(String key,Object value){
        redisTemplate.opsForValue().set(key, value);
    }

    //取数据
    public Object get(String key){
        return JSON.parseObject(JSON.toJSONString(redisTemplate.opsForValue().get(key)), new TypeReference<Object>() { });
    }
}
