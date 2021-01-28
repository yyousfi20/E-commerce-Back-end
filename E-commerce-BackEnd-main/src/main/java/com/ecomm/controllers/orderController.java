package com.ecomm.controllers;

import com.ecomm.dao.ProduitRep;
import com.ecomm.dao.ProjectionRep;
import com.ecomm.dao.ShoppongcartRep;
import com.ecomm.dto.PrdtprojDto;
import com.ecomm.entities.Produits;
import com.ecomm.entities.Projections;
import com.ecomm.entities.ShoppingCarts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class orderController {
    @Autowired
    ProduitRep produitRep;
    @Autowired
    ShoppongcartRep shoppongcartRep;
    @Autowired
    ProjectionRep projectionRep;
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value ="/projections")
    public List<Projections> getProduits()
    {
        return projectionRep.findAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/projections/{idp}/{ids}")
    public Projections save(@PathVariable Long idp,@PathVariable Long ids,@RequestBody Projections p)
    {
        Produits produits= new Produits();
        produits.setId(idp);
        ShoppingCarts s=new ShoppingCarts();
        s.setId(ids);
        p.setProduits(produits);
        p.setShoppingCarts(s);
        return projectionRep.save(p);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value ="/projections/{produits}/{shoppingCarts}")
    public List<Projections> findbyproduits(@PathVariable Produits produits,@PathVariable ShoppingCarts shoppingCarts)
    {
        return projectionRep.findByProduitsAndShoppingCarts(produits,shoppingCarts);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value ="/projections/q/{produits}/{shoppingCarts}")
    public List<Integer> findquantity(@PathVariable Produits produits,@PathVariable ShoppingCarts shoppingCarts)
    {
        return projectionRep.findquantity(produits,shoppingCarts);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/projections/{id}/{produits}/{shoppingCarts}",method = RequestMethod.PUT)
    public Projections Update(@PathVariable Long id,@PathVariable Produits produits,@PathVariable ShoppingCarts shoppingCarts, @RequestBody Projections p)
    {
        p.setId(id);
        p.setProduits(produits);
        p.setShoppingCarts(shoppingCarts);

        return projectionRep.save(p);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value ="/projections/count/{shoppingCarts}")
    public int countItems(@PathVariable ShoppingCarts shoppingCarts)
    {
        return  projectionRep.countItems(shoppingCarts);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value ="/projections/produit/{shoppingCarts}")
    public List<Produits> getProduits(@PathVariable ShoppingCarts shoppingCarts)
    {
        return  projectionRep.getProduits(shoppingCarts);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value ="/projections/produit/m/{shoppingCarts}")
    List<PrdtprojDto> fetchprojPrdtDataInnerJoin(@PathVariable ShoppingCarts shoppingCarts)
    {
        return projectionRep.fetchprojPrdtDataInnerJoin(shoppingCarts);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(value = "/projections/{shoppingCarts}")
    void clearshoppincart(@PathVariable ShoppingCarts shoppingCarts)
    {

        projectionRep.deleteByShoppingCarts(shoppingCarts);
    }








}
