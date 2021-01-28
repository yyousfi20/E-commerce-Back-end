package com.ecomm.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data

@AllArgsConstructor
@ToString
@NoArgsConstructor
public class favoris {
    @Id
    private Long id;



}
