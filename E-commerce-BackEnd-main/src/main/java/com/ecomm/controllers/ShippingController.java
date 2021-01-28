package com.ecomm.controllers;

import com.ecomm.dao.ShippingRep;
import com.ecomm.entities.Shipping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(name="/Shipping")
public class ShippingController {
    @Autowired
    ShippingRep shippingRep;


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/shipping",method = RequestMethod.POST)
    public Shipping save(@RequestBody Shipping p)
    {
        return shippingRep.save(p);
    }

}
