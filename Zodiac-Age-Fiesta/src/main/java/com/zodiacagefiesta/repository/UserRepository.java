package com.zodiacagefiesta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zodiacagefiesta.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	User findAllByUsername(String username);
}
