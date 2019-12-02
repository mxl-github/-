package com.fh.redis.impl;

import com.fh.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void setStringKeyAndValue(String key, Object value) {
        redisTemplate.opsForValue().set(key,value);
    }

    @Override
    public Boolean isExistKey(String brands) {
        return redisTemplate.hasKey(brands);
    }

    @Override
    public Object getStringValueByKey(String brands) {
        return redisTemplate.opsForValue().get(brands);
    }

}
