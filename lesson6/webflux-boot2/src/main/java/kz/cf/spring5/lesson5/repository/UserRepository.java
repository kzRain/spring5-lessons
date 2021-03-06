package kz.cf.spring5.lesson5.repository;

import kz.cf.spring5.lesson5.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository  {

    Flux<User> findAll();

    Mono<Long> save(User user);
}
