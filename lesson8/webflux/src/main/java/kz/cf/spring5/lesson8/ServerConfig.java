package kz.cf.spring5.lesson8;

import kz.cf.spring5.lesson8.web.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by iuliana.cosmina on 8/6/17.
 */
@ComponentScan(basePackages = {"kz.cf.spring5.lesson8"})
@Configuration
public class ServerConfig {

	@Bean
	public Server server() {
		return new Server();
	}
}
