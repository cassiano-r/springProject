package br.com.cassiano.springproject.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import br.com.cassiano.springproject.config.SpringProjectConfig;
import br.com.cassiano.springproject.service.HelloWorldService;
import br.com.cassiano.springproject.user.HelloWorldUser;

public class SpringProjectMain {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringProjectConfig.class);
		
		HelloWorldService hello = context.getBean(HelloWorldService.class);
		hello.sayHello("Spot Dog");
		
		HelloWorldUser user = context.getBean(HelloWorldUser.class);
		user.getName("Ricardo");
		user.getPassWord("Senha");
		
		context.close();
		
		
	}

}
