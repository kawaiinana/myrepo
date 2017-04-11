package com.opm.shop.entity;

import java.io.Serializable;

import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Admin extends Account implements Serializable{

    public Admin() {
    }

}