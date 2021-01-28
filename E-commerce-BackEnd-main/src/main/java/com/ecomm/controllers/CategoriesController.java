package com.ecomm.controllers;

import com.ecomm.dao.CategorieRep;
import com.ecomm.entities.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name="/categories")
public class CategoriesController {
    @Autowired
    private CategorieRep categorieRep;



    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value ="/categorie")
    public List<Categories>getCategories()
    {
        return categorieRep.findAll();
    }


}
