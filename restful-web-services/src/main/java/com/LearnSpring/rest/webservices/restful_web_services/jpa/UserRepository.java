package com.LearnSpring.rest.webservices.restful_web_services.jpa;

import com.LearnSpring.rest.webservices.restful_web_services.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
