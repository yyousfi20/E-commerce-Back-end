package com.ecomm.services;

import com.ecomm.dao.ProduitRep;
import com.ecomm.dao.ProjectionRep;
import com.ecomm.dao.ShoppongcartRep;
import org.springframework.beans.factory.annotation.Autowired;

public class Iccommerceimpl implements ICecommerceService {
    @Autowired
    ProduitRep produitRep;
    @Autowired
    ShoppongcartRep shoppongcartRep;
    @Autowired
    ProjectionRep projectionRep;

    @Override
    public void Projection() {

    }

    @Override
    public void produits() {
        produitRep.findAll().forEach(v->{

                }
                );
    }

    @Override
    public void shoppingcart() {

    }
}
