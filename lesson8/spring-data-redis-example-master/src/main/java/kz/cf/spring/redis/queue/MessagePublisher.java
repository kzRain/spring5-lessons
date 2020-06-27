package kz.cf.spring.redis.queue;

public interface MessagePublisher {

    void publish(final String message);
}
