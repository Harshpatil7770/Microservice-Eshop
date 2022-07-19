package com.xoriant.delivery.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xoriant.delivery.model.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

}
