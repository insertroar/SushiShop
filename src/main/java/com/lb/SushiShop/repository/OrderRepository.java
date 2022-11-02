package com.lb.SushiShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lb.SushiShop.model.Sushi_order;

@Repository
public interface OrderRepository extends JpaRepository<Sushi_order, Integer> {

}
