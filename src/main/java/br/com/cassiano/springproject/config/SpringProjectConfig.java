package br.com.cassiano.springproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.cassiano.springproject.service.HelloWorldService;
import br.com.cassiano.springproject.service.HelloWorldServiceImpl;
import br.com.cassiano.springproject.user.HelloWorldUser;
import br.com.cassiano.springproject.user.HelloWorldUserImpl;

@Configuration
@EnableWebMvc
@ComponentScan("br.com.cassiano.springproject")
public class SpringProjectConfig {
	
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

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
