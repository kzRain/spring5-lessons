package kz.cf.spring5.lesson8.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * Created by ruslan beyganov on 7/29/17.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {

		registry.addEndpoint("/ws").setAllowedOrigins("http://192.168.1.92:4200").withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry config) {
		config.setApplicationDestinationPrefixes("/app");
		config.enableSimpleBroker("/topic");
	}
}
