package com.g9.handbagstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.g9.handbagstore.entity.Bag;

public interface BagRepository extends JpaRepository<Bag, Integer>{
}