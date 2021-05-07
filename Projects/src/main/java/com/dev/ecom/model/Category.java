package com.dev.ecom.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue
    private long Id;
    private String name;
}
