package com.ecomm.dao;

import com.ecomm.entities.Shipping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ShippingRep extends JpaRepository<Shipping, Long> {

}
