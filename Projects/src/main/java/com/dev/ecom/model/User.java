package com.dev.ecom.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
@Setter
@Getter
@ToString
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    private long Id;
    private String fName;
    private String lName;
    private String address;
    private int age;
    private Date dateAdded;
    private String email;
    private String pwd;

}
