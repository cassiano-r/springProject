package br.com.cassiano.springproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;

import br.com.cassiano.springproject.service.HelloWorldService;
import br.com.cassiano.springproject.service.HelloWorldServiceImpl;
import br.com.cassiano.springproject.user.HelloWorldUser;
import br.com.cassiano.springproject.user.HelloWorldUserImpl;

@Configuration
public class SpringProjectConfig {

	@Bean(name = "helloBean")
	@Description("Description")
	public HelloWorldService hello(){
		return new HelloWorldServiceImpl();
	}
	
	@Bean(name = "helloUser")
	public HelloWorldUser user(){
		return new HelloWorldUserImpl();
	}
	
}
