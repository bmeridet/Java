package com.dev.ecom.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table
@Getter
@Setter
@ToString
@NoArgsConstructor
public class PurchaseItem {

    @Id
    @GeneratedValue
    private long Id;

    @OneToOne
    private Purchase purchase;

    @OneToOne
    private Product product;

    @OneToOne
    private User user;

    private BigDecimal rate;
    private int quantity;
    private BigDecimal price;

}
