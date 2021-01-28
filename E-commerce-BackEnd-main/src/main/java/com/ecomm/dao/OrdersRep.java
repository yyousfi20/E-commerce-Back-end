package com.ecomm.dao;

import com.ecomm.entities.Orders;
import com.ecomm.entities.ShoppingCarts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource

public interface OrdersRep extends JpaRepository<Orders,Long> {
    List<Orders> findByUseridAndShoppingCarts(String userid , ShoppingCarts shoppingCarts);
}
