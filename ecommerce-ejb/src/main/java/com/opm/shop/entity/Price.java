package com.opm.shop.entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.TIMESTAMP;

@SuppressWarnings("serial")
@Embeddable
public class Price implements Serializable{

    private double price;

    @Temporal(TIMESTAMP)
	private Date refDate;
    
    public Price() {
		// TODO Auto-generated constructor stub
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getRefDate() {
		return refDate;
	}

	public void setRefDate(Date refDate) {
		this.refDate = refDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((refDate == null) ? 0 : refDate.hashCode());
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
		Price other = (Price) obj;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (refDate == null) {
			if (other.refDate != null)
				return false;
		} else if (!refDate.equals(other.refDate))
			return false;
		return true;
	}
	
}