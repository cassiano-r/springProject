package br.com.cassiano.springproject.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import br.com.cassiano.springproject.service.HelloWorldService;
import br.com.cassiano.springproject.service.HelloWorldServiceImpl;
import br.com.cassiano.springproject.user.HelloWorldUser;
import br.com.cassiano.springproject.user.HelloWorldUserImpl;

@Configuration
@EnableWebMvc
@ComponentScan("br.com.cassiano.springproject")
public class SpringProjectConfig  extends WebMvcConfigurerAdapter{
	
	@Bean
	public LocaleResolver localeResolver(){
		SessionLocaleResolver resolver = new SessionLocaleResolver();
		resolver.setDefaultLocale(new Locale("en","US"));
		return resolver;
	}
	
	@Bean
	public MessageSource messageSource(){
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:message");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry){
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("myLocale");
		registry.addInterceptor(interceptor);
	}
	
	@Bean
	public TilesConfigurer tilesConfigure(){
		TilesConfigurer tiles =new TilesConfigurer();
		tiles.setDefinitions(new String[] {"/WEB-INF/views/**/tiles.xml"});
		tiles.setCheckRefresh(true);
		return tiles;
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry){
		TilesViewResolver viewResolver = new TilesViewResolver();
		registry.viewResolver(viewResolver);
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry){
		registry.addResourceHandler("/static/**").addResourceLocations("/static/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
		registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
		registry.addResourceHandler("/img/**").addResourceLocations("/img/");
	}
	
//	@Bean
//	public ViewResolver viewResolver(){
//		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//		viewResolver.setPrefix("/WEB-INF/views/pages/");
//		viewResolver.setSuffix(".jsp");
//		return viewResolver;
//	}

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
