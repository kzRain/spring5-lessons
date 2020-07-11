package kz.cf.spring5.lesson5;

import kz.cf.spring5.lesson5.web.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by iuliana.cosmina on 8/6/17.
 */
@ComponentScan(basePackages = {"kz.cf.spring5.lesson5"})
@Configuration
public class ServerConfig {

	@Bean
	public Server server() {
		return new Server();
	}
}
