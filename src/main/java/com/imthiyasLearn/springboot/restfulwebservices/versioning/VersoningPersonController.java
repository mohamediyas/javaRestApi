package com.imthiyasLearn.springboot.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersoningPersonController {
	
	@GetMapping(path = "/v1/person")
	public PersonV1 getFirstVersionPerson() {
		return new PersonV1("Bob");
	}
	
	
	@GetMapping(path = "/v2/person")
	public PersonV2 getSecondVersionPerson() {
		return new PersonV2("Bob","randa");
	}
	
	@GetMapping(path = "/person" , params = "version1")
	public PersonV2 getSecondVersionPersonRequestMappingPharameter() {
		return new PersonV2("Bob","randa");
	}
	
	
//	@GetMapping(path = "xx/header", headers = "x-api-version=2")
//	produces=application/vnd.company.app-v1+json

}
