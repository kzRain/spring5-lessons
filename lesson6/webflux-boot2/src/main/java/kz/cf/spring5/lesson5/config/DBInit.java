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
        User user = new User(1L,"Edna","Smith");
        userRepository.save(user).subscribe();
    }
}
