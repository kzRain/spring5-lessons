package kz.cf.spring.redis.repository;

import java.util.Map;

import kz.cf.spring.redis.model.MyMessage;

public interface RedisRepository {

    Map<Object, Object> findAllMovies();

    void add(MyMessage myMessage);

    void delete(String id);
    
    MyMessage findMovie(String id);
    
}
