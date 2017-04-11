package com.opm.shop.entity;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.InheritanceType.JOINED;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.PrePersist;

import com.opm.shop.utils.PasswordUtils;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = JOINED)
@DiscriminatorColumn(name = "roles")
public abstract class Account implements Serializable{

    @Id
    @GeneratedValue(strategy = IDENTITY)
	private long id;

    private String email;

    private String password;
    
    public Account() {
    }
    
    @PrePersist
	private void encript() {
    	try {
			password = PasswordUtils.encript(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}