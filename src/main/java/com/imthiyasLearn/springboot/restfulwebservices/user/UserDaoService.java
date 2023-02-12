package com.imthiyasLearn.springboot.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users  = new ArrayList<>();
	
	
	
	
	static {
		users.add(new User(1,"Adam",LocalDate.now().minusYears(13)));
		users.add(new User(2,"Eve",LocalDate.now().minusYears(10)));
		users.add(new User(3,"Earn",LocalDate.now().minusYears(20)));
	
	}
	
	private Integer usersCount = 3;
	
	
	
	public List<User> findAll() {
		return users;
	}



	public User findOneById(int id) {
		// TODO Auto-generated method stub
		
		Predicate<? super User> predicate = user -> user.getId() == id;
		
		
		return users.stream().filter(predicate).findFirst().orElse(null);
	}
	
	
	
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
		Predicate<? super User> predicate = user -> user.getId() == id;
		
		
		users.removeIf(predicate);
		
		
	}
	
	
	
	public User save(User user) {
		
		user.setId(++usersCount);
		
		users.add(user);
		
		
		return user;
	}
	
	
	
	
	
	

}
