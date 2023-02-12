package com.imthiyasLearn.springboot.restfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imthiyasLearn.springboot.restfulwebservices.user.Post;
import com.imthiyasLearn.springboot.restfulwebservices.user.User;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
