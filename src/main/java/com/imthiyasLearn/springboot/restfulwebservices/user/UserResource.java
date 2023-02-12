package com.imthiyasLearn.springboot.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

//@RestController
public class UserResource {
	
	
	
	@Autowired
	private UserDaoService service;

	
	@GetMapping("/users")
	public List<User> retriveAllUser(){
		return service.findAll();
		
	}
	
	
	@GetMapping("/users/{id}")
	public EntityModel<User> retriveUser(@PathVariable int id){
		User user =  service.findOneById(id);
		
		if(user == null) {
			throw new UserNotFoundException("id" +id);		}
		
		EntityModel<User> entityModel = EntityModel.of(user);
 		
		
		WebMvcLinkBuilder Link = linkTo(methodOn(this.getClass()).retriveAllUser());
		
		
		entityModel.add(Link.withRel("all-users"));
		
		return entityModel;
		
	}
	
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id){
		  service.deleteById(id);
		
		
	}
	
	
	
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
		
		User savedUser = service.save(user);
		
		 
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		 
		
		 return ResponseEntity.created(location).build();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
