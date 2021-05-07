package com.dev.ecom.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue
    private long Id;
    private String name;
    private BigDecimal price;
    private Date dateAdded;

    @OneToOne
    private Category category; // This may need to be an object of type category.
}
