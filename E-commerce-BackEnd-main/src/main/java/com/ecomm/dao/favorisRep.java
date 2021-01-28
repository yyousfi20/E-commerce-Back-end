package com.ecomm.dao;

import com.ecomm.entities.favoris;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RepositoryRestResource
public interface favorisRep extends JpaRepository<favoris,Long> {

}
