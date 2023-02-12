package com.imthiyasLearn.springboot.restfulwebservices.filtering;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	
	@GetMapping("/filtering")
	public MappingJacksonValue filtering() {
		
		SomeBean bean  = new SomeBean("value1","value2","value3");
		
		MappingJacksonValue jacksonValue  = new MappingJacksonValue(bean);
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("someBean", filter);
		
		jacksonValue.setFilters(filters);
		
		return jacksonValue;
	}
	

	@GetMapping("/filtering-list")
	public List<SomeBean> filteringList() {
		return Arrays.asList(new SomeBean("value1","value2","value3"),new SomeBean("value4","value5","value6")) ;
	}
	
	
}
