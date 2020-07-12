package kz.cf.spring5.lesson5.repository;

import kz.cf.spring5.lesson5.domain.User;
import org.davidmoten.rx.jdbc.Database;
import org.davidmoten.rx.jdbc.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    public Database db;

    @Override
    public Flux<User> findAll() {
        return Flux.from(db.select("SELECT id, first_name, last_name FROM users_system")
                .get(rs -> toUser(rs)));
    }

    private User toUser(ResultSet rs) {
        try {
            return new User(
                    rs.getLong("id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Mono<Long> save(User user) {
        return Mono.from(db
                .update("INSERT INTO users_system (first_name, last_name) VALUES (:firstname, :lastname)")
                .parameters(toParameters(user))
                .returnGeneratedKeys()
                .getAs(Long.class));
    }

    private List<Parameter> toParameters(User user) {
        List<Parameter> result = new ArrayList<>();
        result.add(Parameter.create("firstname", user.getFirstName()));
        result.add(Parameter.create("lastname", user.getLastName()));
        return result;
    }
}
