package com.opm.shop.entity;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import static javax.persistence.EnumType.STRING;
import javax.persistence.Lob;

@SuppressWarnings("serial")
@Entity
public class Member extends Account implements Serializable {

    public enum Status {
        Active,
        Ban
    }
    
    public enum Gender {
    	Male,
    	Female
    }
    
    private String firstName;

    private String lastName;

    private String nickname;

    private String phone;
    
    private String image;
    
    @Lob
	private String description;
    
    @Enumerated(STRING)
	private Gender gender;

    @Enumerated(STRING)
	private Status status;

    @Embedded
    private SecurityInfo security;
    
    public Member() {
    	security = new SecurityInfo();
    }

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public SecurityInfo getSecurity() {
		return security;
	}

	public void setSecurity(SecurityInfo security) {
		this.security = security;
	}
    
}