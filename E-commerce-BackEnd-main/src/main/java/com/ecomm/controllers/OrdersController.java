package com.ecomm.controllers;

import com.ecomm.dao.OrdersRep;
import com.ecomm.dao.ShippingRep;
import com.ecomm.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name="/Orders")

public class OrdersController {

    @Autowired
    ShippingRep shippingRep;
    @Autowired
    OrdersRep ordersRep;
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/orders/{ids}/{idc}")
    public Orders save(@PathVariable Long ids,@PathVariable Long idc,@RequestBody Orders p)
    {
        Shipping shipping= new Shipping();
        ShoppingCarts shoppingCarts= new ShoppingCarts();

        shipping.setId(ids);

        p.setShipping(shipping);
        shoppingCarts.setId(idc);
        p.setShoppingCarts(shoppingCarts);

        return ordersRep.save(p);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value ="/orders/{userid}/{shoppingCarts}")
    public List<Orders> findbyusershoppingcart(@PathVariable String userid, @PathVariable ShoppingCarts shoppingCarts)
    {
        return ordersRep.findByUseridAndShoppingCarts(userid,shoppingCarts);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value ="/orders")
    public List<Orders> getOrders()
    {
        return ordersRep.findAll();
    }



}
