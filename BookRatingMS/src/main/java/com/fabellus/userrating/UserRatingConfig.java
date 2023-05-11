package com.fabellus.userrating;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket; 


@SpringBootApplication
public class UserRatingConfig implements WebMvcConfigurer{

	private ApiInfo getApiDetails() { 
		return new ApiInfo("JLL BookStore- API", 
		"BookRatingMS- API - part of BookStore",
		"1.0",
		"https://www.fabellus.com",
 		new Contact("Srinivas Dande", "https://www.jlcindia.com", "sri@jlcindia.com"), 
		"Larsen and Turbo",
		"API under Free to use License"); 
		} 

	@Bean 
	 Docket apiDocket() {
		System.out.println("docket called");
		return 
				new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.fabellus.userrating"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiDetails()); 
		} 

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		
		System.out.println("resource handler called");
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/"); 
		registry.addResourceHandler("/webjars/** ").addResourceLocations("classpath:/META-INF/resources/webjars/"); 
	}
	
	@Bean(name="myBookRatingsExchange")
	Exchange createBookRatingsExchange() {
		return ExchangeBuilder.topicExchange("mybookratings.exchange").build();
	}
	@Bean(name="myBookRatingsQueue")
	Queue createBookRatingsQueue() {
		return QueueBuilder.durable("mybookratings.queue").build();

	}
	@Bean
	Binding bookRatingBinding(Queue myBookRatingsQueue, TopicExchange myBookRatingsExchange) {
		  return BindingBuilder.bind(myBookRatingsQueue).to(myBookRatingsExchange).with("mybookratings.key.*");
	}		
	
	@Bean(name="myUserRatingsExchange")
	Exchange createUserRatingsExchange() {
		return ExchangeBuilder.topicExchange("myuserratings.exchange").build();
	}
	@Bean(name="myUserRatingsQueue")
	Queue createUserRatingsQueue() {
		return QueueBuilder.durable("myuserratings.queue").build();

	}
	@Bean
	Binding userRatingBinding(Queue myUserRatingsQueue, TopicExchange myUserRatingsExchange) {
		  return BindingBuilder.bind(myUserRatingsQueue).to(myUserRatingsExchange).with("myuserratings.key.*");
	}		
	
	}
