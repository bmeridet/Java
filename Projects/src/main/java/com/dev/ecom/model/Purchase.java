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
public class Purchase {

    @Id
    @GeneratedValue
    private long Id;

    @OneToOne
    private User user;

    private Date date;
    private BigDecimal total;

}
