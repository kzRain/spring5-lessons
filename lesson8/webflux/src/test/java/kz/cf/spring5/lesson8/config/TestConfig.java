package kz.cf.spring5.lesson8.config;

import kz.cf.spring5.lesson8.web.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * Created by iuliana.cosmina on 8/6/17.
 */
@Configuration
public class TestConfig {

	@Autowired
    Server server;

	@Bean
	WebTestClient testClient(){
		return WebTestClient.bindToRouterFunction(server.routingFunction())
				.configureClient()
				.baseUrl("http://localhost/singers")
				.build();
	}

}
