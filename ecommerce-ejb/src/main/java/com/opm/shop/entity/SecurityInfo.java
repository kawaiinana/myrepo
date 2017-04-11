package com.opm.shop.entity;

import static javax.persistence.EnumType.STRING;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.TIMESTAMP;

@SuppressWarnings("serial")
@Embeddable
public class SecurityInfo implements Serializable{

    public enum Valid {
    	ON, OFF
    }

    @Temporal(TIMESTAMP)
	private Date creation;

    private long createUser;

    @Temporal(TIMESTAMP)
	private Date modification;
    
	private long modUser;

    @Enumerated(STRING)
	private Valid valid;
    
    public SecurityInfo() {
		// TODO Auto-generated constructor stub
	}

	public Date getCreation() {
		return creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	public long getCreateUser() {
		return createUser;
	}

	public void setCreateUser(long createUser) {
		this.createUser = createUser;
	}

	public Date getModification() {
		return modification;
	}

	public void setModification(Date modification) {
		this.modification = modification;
	}

	public long getModUser() {
		return modUser;
	}

	public void setModUser(long modUser) {
		this.modUser = modUser;
	}

	public Valid getValid() {
		return valid;
	}

	public void setValid(Valid valid) {
		this.valid = valid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (createUser ^ (createUser >>> 32));
		result = prime * result + ((creation == null) ? 0 : creation.hashCode());
		result = prime * result + (int) (modUser ^ (modUser >>> 32));
		result = prime * result + ((modification == null) ? 0 : modification.hashCode());
		result = prime * result + ((valid == null) ? 0 : valid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SecurityInfo other = (SecurityInfo) obj;
		if (createUser != other.createUser)
			return false;
		if (creation == null) {
			if (other.creation != null)
				return false;
		} else if (!creation.equals(other.creation))
			return false;
		if (modUser != other.modUser)
			return false;
		if (modification == null) {
			if (other.modification != null)
				return false;
		} else if (!modification.equals(other.modification))
			return false;
		if (valid != other.valid)
			return false;
		return true;
	}

	
}