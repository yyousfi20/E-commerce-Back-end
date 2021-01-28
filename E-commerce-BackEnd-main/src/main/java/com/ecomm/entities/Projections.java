package com.ecomm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data

@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Projections implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    int quantity ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Produits getProduits() {
        return produits;
    }

    public void setProduits(Produits produits) {
        this.produits = produits;
    }

    public ShoppingCarts getShoppingCarts() {
        return shoppingCarts;
    }

    public void setShoppingCarts(ShoppingCarts shoppingCarts) {
        this.shoppingCarts = shoppingCarts;
    }

    @ManyToOne
    @JsonIgnore
    @Fetch(FetchMode.JOIN)
    Produits produits;
    @ManyToOne
    @JsonIgnore
    ShoppingCarts shoppingCarts;


}
