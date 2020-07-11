package kz.cf.spring5.lesson5.config;

import org.davidmoten.rx.jdbc.Database;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Value("${jdbc.url}")
    public String url;

    @Bean
    public Database providesDatabaseConn() {
        return Database.from(url, Runtime.getRuntime().availableProcessors() * 2);
    }

}
