package kz.cf.spring5.lesson8.service;

import kz.cf.spring5.lesson8.domain.User;
import kz.cf.spring5.lesson8.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Flux<User> get() {
        return userRepository.findAll();
    }

    @Override
    public Mono<Long> save(User user) {
        Mono<Long> id = userRepository.save(user);
        return id;
    }

    @Override
    public Flux<User> getByLastName(final String lastName) {
        return userRepository
                .findAll()
                .filter(user -> user.getLastName().equals(lastName));
    }

    @Override
    public Flux<User> getByLastNameWithSleep(String lastName) {
        try {
            TimeUnit.SECONDS.sleep(20L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userRepository
                .findAll()
//                .delayElements(Duration.ofSeconds(20))
                .filter(user -> user.getLastName().equals(lastName));
    }
}
