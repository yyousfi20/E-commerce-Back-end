package com.ecomm.dao;

import com.ecomm.dto.PrdtprojDto;
import com.ecomm.entities.Produits;
import com.ecomm.entities.Projections;
import com.ecomm.entities.ShoppingCarts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.transaction.Transactional;
import java.util.List;
@CrossOrigin("*")
@RepositoryRestResource(collectionResourceRel = "Projections", path = "projections")
@Transactional
public interface ProjectionRep extends JpaRepository<Projections,Long> {

    List <Projections> findByProduitsAndShoppingCarts(Produits produits , ShoppingCarts shoppingCarts);
    @Query("select t.quantity from Projections t where t.produits = ?1 and t.shoppingCarts = ?2")
    List<Integer> findquantity(Produits produits , ShoppingCarts shoppingCarts);
    @Query("select SUM(t.quantity)" +
            " from Projections t where  t.shoppingCarts = ?1")
    int countItems(ShoppingCarts shoppingCarts);

    @Query("select t.produits from Projections t where  t.shoppingCarts = ?1")
    List<Produits> getProduits(ShoppingCarts shoppingCarts);



    @Query("SELECT new com.ecomm.dto.PrdtprojDto(p.id,p.title,pd.quantity,p.price,p.imageUrl) "
            + "FROM Produits p INNER JOIN p.projections pd where pd.shoppingCarts = ?1")
    List<PrdtprojDto> fetchprojPrdtDataInnerJoin(ShoppingCarts shoppingCarts);

    void deleteByShoppingCarts(ShoppingCarts shoppingCarts);


}
