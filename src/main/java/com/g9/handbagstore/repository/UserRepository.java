package com.g9.handbagstore.repository;

import com.g9.handbagstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("from User where username = :username")
	User getUserByUserName(@Param("username") String username);
}