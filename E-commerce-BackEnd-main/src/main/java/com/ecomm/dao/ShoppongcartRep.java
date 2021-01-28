package com.ecomm.dao;

import com.ecomm.entities.ShoppingCarts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ShoppongcartRep extends JpaRepository<ShoppingCarts, Long> {


}
