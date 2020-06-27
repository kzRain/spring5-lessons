package kz.cf.spring5.lesson8.web.controller;

import kz.cf.spring5.lesson8.domain.User;
import kz.cf.spring5.lesson8.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("check")
    public String check() {
        return "Check success!";
    }
    @PostMapping
    public Mono<Long> post(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping
    public Flux<User> get() {
        return userService.get();
    }

    @GetMapping("{lastName}")
    public Flux<User> getByLastName(@PathVariable(name = "lastName") String lastName) {
        return userService.getByLastName(lastName);
    }

    @GetMapping("/sleep/{lastName}")
    public Flux<User> getByLastNameWithSleep(@PathVariable(name = "lastName") String lastName) {

        return userService.getByLastNameWithSleep(lastName);
    }
}
