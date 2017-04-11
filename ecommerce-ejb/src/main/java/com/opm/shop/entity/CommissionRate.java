package com.opm.shop.entity;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.TemporalType.DATE;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;

@SuppressWarnings("serial")
@Entity
public class CommissionRate implements Serializable {

	public enum RateType {
		Fix, Percent
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int id;
	
	private double amountFrom;

	private double amountTo;

	private double rate;

	@Temporal(DATE)
	private Date refDate;

	@Enumerated(STRING)
	private RateType type;

	@Column(name="del_flag")
	private boolean deleteFlag;
	
	public CommissionRate() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getAmountFrom() {
		return amountFrom;
	}

	public void setAmountFrom(Double amountFrom) {
		this.amountFrom = amountFrom;
	}

	public Double getAmountTo() {
		return amountTo;
	}

	public void setAmountTo(Double amountTo) {
		this.amountTo = amountTo;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public Date getRefDate() {
		return refDate;
	}

	public void setRefDate(Date refDate) {
		this.refDate = refDate;
	}

	public RateType getType() {
		return type;
	}

	public void setType(RateType type) {
		this.type = type;
	}

	public boolean isDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

}