package kz.cf.spring5.lesson8.service;

import kz.cf.spring5.lesson8.domain.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Flux<User> get();
    Mono<Long> save(User user);
    Flux<User> getByLastName(final String lastName);
    Flux<User> getByLastNameWithSleep(final String lastName);
}
