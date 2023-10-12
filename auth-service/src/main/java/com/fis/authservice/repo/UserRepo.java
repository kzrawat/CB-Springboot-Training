package com.fis.authservice.repo;

import java.util.List;

import org.hibernate.annotations.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.fis.authservice.entity.User;



@EnableJpaRepositories
public interface UserRepo  extends JpaRepository<User, Integer>{
	
	public User findByUsernameAndPassword(String username, String password);
	
	public User findByUsername(String username);
	
	@Query(value = "SELECT u FROM User u")
	List<User> getAllUsers();

}
