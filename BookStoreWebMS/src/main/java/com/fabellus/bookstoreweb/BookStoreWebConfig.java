package com.fabellus.bookstoreweb;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
/*
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket; 
*/
@SpringBootApplication
//@EnableWebMvc
public class BookStoreWebConfig implements WebMvcConfigurer{

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("WEB-INF/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
		
	}
	private ApiInfo getApiDetails() { 
		return new ApiInfo(
		"JLC BookStore- API", 
		"BookSearchMS- API - part of BookStore",
		"1.0",
		"https://www.fabellus.com",		
		new Contact("Saurabh Bhandari", "https://www.fabellus.com", "sri@jlcindia.com"), 
		"Larsen and Turbo",
		"API under Free to use License"
		); 
		} 

	@Bean 
	public Docket apiDocket() {
		System.out.println("docket called");
		return 
				new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.fabellus.microservices.bookprice"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiDetails()); 
		} 
		@Override 
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("resource handler called");
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/"); 
		registry.addResourceHandler("/webjars/** ").addResourceLocations("classpath:/META-INF/resources/webjars/"); 
		WebMvcConfigurer.super.addResourceHandlers(registry);
		} 
}