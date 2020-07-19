package com.redis.example.demo.repository;


import com.redis.example.demo.model.MyMessage;

import java.util.Map;

public interface RedisRepository {

    Map<Object, Object> findAllMovies();

    void add(MyMessage myMessage);

    void delete(String id);
    
    MyMessage findMovie(String id);
    
}
