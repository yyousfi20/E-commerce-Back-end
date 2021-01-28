package com.ecomm.dao;

import com.ecomm.entities.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CommentsRep extends JpaRepository<Comments,Long> {


}
