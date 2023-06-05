package com.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.main.Entity.User;
import java.util.List;
import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserDao  extends JpaRepository<User, Integer> { 
	
	public User findByUid(int uid);
	
	public User findByUsername(String username);
	
	Optional<User> findOneByUsernameAndUpwd(String username, String upwd);
	//public String findByUsername(String username);
	

}
