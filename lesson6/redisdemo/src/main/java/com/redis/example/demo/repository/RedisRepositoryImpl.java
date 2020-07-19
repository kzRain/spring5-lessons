package com.redis.example.demo.repository;


import com.redis.example.demo.model.MyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;

@Repository
public class RedisRepositoryImpl implements RedisRepository {
    private static final String KEY = "Movie";
    
    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;
    
    @Autowired
    public RedisRepositoryImpl(RedisTemplate<String, Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    private void init(){
        hashOperations = redisTemplate.opsForHash();
    }
    
    public void add(final MyMessage myMessage) {
        hashOperations.put(KEY, myMessage.getId(), myMessage.getName());
    }

    public void delete(final String id) {
        hashOperations.delete(KEY, id);
    }
    
    public MyMessage findMovie(final String id){
        return (MyMessage) hashOperations.get(KEY, id);
    }
    
    public Map<Object, Object> findAllMovies(){
        return hashOperations.entries(KEY);
    }

  
}
