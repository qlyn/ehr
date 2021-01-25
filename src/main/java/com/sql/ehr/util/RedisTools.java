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
import java.util.Set;


@Component
public class RedisTools {
    @Autowired
    public RedisTemplate redisTemplate;            //操作的key可以是对象

    @Autowired
    public StringRedisTemplate stringRedisTemplate;    //操作的key必须是字符串

    //存数据
    public void set(String key,Object value){
        redisTemplate.opsForValue().set(key, value);
    }

    //取数据
    public <T> T get(String key){
         return JSON.parseObject(JSON.toJSONString(redisTemplate.opsForValue().get(key)), new TypeReference<T>() { });
    }

    //删除命名空间缓存（一般为类名，将该类名对应命名空间里的所有缓存删除）
    public void deleteNameSpace(String className){
        Set<String> keys = redisTemplate.keys(className + ":*");
        redisTemplate.delete(keys);
    }


    //删除单个缓存（一般为类名：方法名）
    public void deleteKey(String key){
        if(redisTemplate.hasKey(key)){
            redisTemplate.delete(key);
        }
    }
}
