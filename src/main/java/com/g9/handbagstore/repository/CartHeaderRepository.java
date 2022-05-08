package com.g9.handbagstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.g9.handbagstore.entity.CartHeader;

public interface CartHeaderRepository extends JpaRepository<CartHeader, Integer> {

}
