package com.ecomm.controllers;

import com.ecomm.dao.ShoppongcartRep;
import com.ecomm.entities.ShoppingCarts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name="/shoppint-cart")
public class shpponController {

    @Autowired
    private ShoppongcartRep shoppongcartRep;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value ="/shoppint-cart")
    public List<ShoppingCarts> getSoppincart()
    {
        return shoppongcartRep.findAll();
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/shoppint-cart")
    public ShoppingCarts save(@RequestBody ShoppingCarts p)
    {
        return shoppongcartRep.save(p);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value ="/shoppint-cart/{id}")
    public ShoppingCarts getProduits(@PathVariable(name ="id") Long id)
    {
        return  shoppongcartRep.findById(id).get();
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping(value = "/shoppint-cart/{id}")
    public ShoppingCarts Update(@PathVariable(name ="id") Long id,@RequestBody ShoppingCarts p)
    {
        p.setId(id);

        return shoppongcartRep.save(p);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(value = "/shoppint-cart/{id}")
    public void delete(@PathVariable(name ="id") Long id)
    {

        shoppongcartRep.deleteById(id);
    }

}
