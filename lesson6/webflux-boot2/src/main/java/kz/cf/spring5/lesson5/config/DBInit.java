package kz.cf.spring5.lesson5.config;

import kz.cf.spring5.lesson5.domain.User;
import kz.cf.spring5.lesson5.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DBInit {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    private void fillUser() {
        User user1 = new User("Edna","Smith");
        User user2 = new User("Edna","Smith");
        User user3 = new User("Edna","Smith");
        User user4 = new User("Edna","Smith");
        userRepository.save(user1).subscribe();
        userRepository.save(user2).subscribe();
        userRepository.save(user3).subscribe();
        userRepository.save(user4).subscribe();
    }
}
