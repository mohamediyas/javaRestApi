package com.imthiyasLearn.springboot.restfulwebservices.helloWorld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//rest api 


@RestController
public class HelloWorldController {
	
	

	@Autowired
	private MessageSource messageSource;
	
	
	@GetMapping( path = "/hello-world")
	public String helloWorld() {
		
		return "Hello World";
		
	}
	
	
	@GetMapping( path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		
		return new HelloWorldBean("Hello World");
		
	}
	
	@GetMapping( path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVaraiable(@PathVariable String name) {
		
		return new HelloWorldBean(String.format("Hello World, %s", name));
		
	}
	
	@GetMapping( path = "/hello-world-intl")
	public String helloWorldInternazialize() {
		
		Locale locale = LocaleContextHolder.getLocale();
		
	 return	messageSource.getMessage("good.morning.message", null,"Default Message",locale);
		
//		return"Hello world";
		
	}

}
