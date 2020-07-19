package com.redis.example.demo.queue;

public interface MessagePublisher {

    void publish(final String message);
}
