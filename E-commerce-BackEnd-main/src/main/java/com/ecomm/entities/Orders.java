package com.ecomm.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data

@AllArgsConstructor
@ToString
@NoArgsConstructor

public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Date dayePlaced;
    String userid;
    @OneToOne
    Shipping shipping;
    @OneToOne
    @JsonIgnore
    ShoppingCarts shoppingCarts;


}
