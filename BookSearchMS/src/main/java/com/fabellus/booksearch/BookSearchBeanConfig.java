package com.fabellus.booksearch;

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

import com.google.common.base.Predicates;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket; 

@SpringBootApplication
//@EnableWebMvc
public class BookSearchBeanConfig implements WebMvcConfigurer{

	@Bean(name="myInventoryExchange")
	Exchange creteInventoryExchange() {
		return ExchangeBuilder.topicExchange("myinventory.exchange").build();
	}

	
	
	@Bean(name="myInventoryQueue")
	Queue createInventoryQueue() {
		return QueueBuilder.durable("myinventory.queue").build();
		
	}
	
	@Bean
	Binding inventoryBinding(Queue myInventoryQueue, TopicExchange myInventoryExchange) {
		return BindingBuilder.bind(myInventoryQueue).to(myInventoryExchange).with("myinventory.key.*");
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
	
//	@SuppressWarnings("deprecation")
	private ApiInfo getApiDetails() {
		return new ApiInfo("JLC BookStore- API",
				"BookSearchMS- API - part of BookStore",
				"1.0",
				"https://www.jlcindia.com",
				new Contact("Srinivas Dande", "https://www.jlcindia.com", "sri@jlcindia.com"), 
				"Larsen and Turbo",
				"API under Free to use License"
				);
	}
	@Bean 
	public Docket api() {
		System.out.println("docket called");
				return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.any()) 
						.apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot"))) 
						.build().apiInfo(getApiDetails()); 
			
	} 

	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub

		System.out.println("resource handler called");
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/"); 
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/"); 

		} 

}
