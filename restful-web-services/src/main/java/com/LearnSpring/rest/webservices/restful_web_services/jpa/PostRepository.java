package com.LearnSpring.rest.webservices.restful_web_services.jpa;

import com.LearnSpring.rest.webservices.restful_web_services.User.Post;
import org.springframework.data.jpa.repository.JpaRepository;



public interface PostRepository extends JpaRepository<Post, Integer> {

}