package com.g9.handbagstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.g9.handbagstore.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("from User where username = :username")
	User getUserByUserName(@Param("username") String username);
}