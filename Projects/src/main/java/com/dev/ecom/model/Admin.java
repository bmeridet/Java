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
@Setter
@Getter
@ToString
@NoArgsConstructor
public class Admin {

    @Id
    @GeneratedValue
    private long Id;
    private String adminId;
    private String pwd;

}
