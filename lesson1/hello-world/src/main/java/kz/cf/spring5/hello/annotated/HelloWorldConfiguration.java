package kz.cf.spring5.hello.annotated;


import kz.cf.spring5.hello.decoupled.HelloWorldMessageProvider;
import kz.cf.spring5.hello.decoupled.MessageProvider;
import kz.cf.spring5.hello.decoupled.MessageRenderer;
import kz.cf.spring5.hello.decoupled.StandardOutMessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguration {

	@Bean
	public MessageProvider provider() {
		return new HelloWorldMessageProvider();
	}

	@Bean
	public MessageRenderer renderer(){
		MessageRenderer renderer = new StandardOutMessageRenderer();
		renderer.setMessageProvider(provider());
		return renderer;
	}
}
