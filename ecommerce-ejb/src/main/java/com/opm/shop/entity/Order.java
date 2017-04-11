package com.opm.shop.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Enumerated;
import static javax.persistence.EnumType.STRING;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.TIMESTAMP;
import javax.persistence.Table;
import javax.persistence.Lob;

@SuppressWarnings("serial")
@Entity
@Table(name = "order_table")
public class Order implements Serializable{

    public enum Status {
        Pending,
        Processing,
        ConfirmShipment,
        Completed,
        Reject,
        Expired
    }
    
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    private String code;

    @Temporal(TIMESTAMP)
	private Date orderDate;

    private double unitPrice;

    private int count;

    private double commissionRate;

    @Temporal(TIMESTAMP)
	private Date minShippingDate;

    @Temporal(TIMESTAMP)
	private Date maxShippingDate;

    @Enumerated(STRING)
	private Status status;
    
    @Lob
	private String remark;

    @ManyToOne
	private Member buyer;

    @ManyToOne
	private Item item;

    @ManyToOne
	private Address shippingAddress;

    @Embedded
    private SecurityInfo security;
    
    public Order() {
    }    

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getCommissionRate() {
		return commissionRate;
	}

	public void setCommissionRate(double commissionRate) {
		this.commissionRate = commissionRate;
	}

	public Date getMinShippingDate() {
		return minShippingDate;
	}

	public void setMinShippingDate(Date minShippingDate) {
		this.minShippingDate = minShippingDate;
	}

	public Date getMaxShippingDate() {
		return maxShippingDate;
	}

	public void setMaxShippingDate(Date maxShippingDate) {
		this.maxShippingDate = maxShippingDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Member getBuyer() {
		return buyer;
	}

	public void setBuyer(Member buyer) {
		this.buyer = buyer;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Address getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public SecurityInfo getSecurity() {
		return security;
	}

	public void setSecurity(SecurityInfo security) {
		this.security = security;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
    
}