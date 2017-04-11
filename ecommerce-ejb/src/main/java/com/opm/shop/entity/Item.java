package com.opm.shop.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.Enumerated;
import static javax.persistence.EnumType.STRING;

@SuppressWarnings("serial")
@Entity
public class Item implements Serializable {

	public enum Status {
		Available,
		SoldOut,
		Ban
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private long id;

	private String name;

	@MapKeyColumn(name="language")
	@ElementCollection
	private Map<String, String> names;

	@Lob
	private String description;
	
	private String image;
	
	@Enumerated(STRING)
	private Status status;
	
	@ElementCollection
	private Set<String> size;

	@ElementCollection
	private Set<String> color;

	@MapKeyColumn(name="language")
	@ElementCollection
	private Map<String, String> descriptions;
	
	@ElementCollection
	private Set<Country> country;

	@ElementCollection
	private Set<State> state;
	
	@ManyToOne
	private Member owner;

	@ManyToOne
	private Category category;

	@ManyToOne
	private Brand brand;

	@ManyToOne
	private ItemState itemState;


	@ElementCollection
	private Set<Price> prices;

	private SecurityInfo security;

	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getNames() {
		return names;
	}

	public void setNames(Map<String, String> names) {
		this.names = names;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Set<String> getSize() {
		return size;
	}

	public void setSize(Set<String> size) {
		this.size = size;
	}

	public Set<String> getColor() {
		return color;
	}

	public void setColor(Set<String> color) {
		this.color = color;
	}

	public Map<String, String> getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(Map<String, String> descriptions) {
		this.descriptions = descriptions;
	}

	public Set<Country> getCountry() {
		return country;
	}

	public void setCountry(Set<Country> country) {
		this.country = country;
	}

	public Set<State> getState() {
		return state;
	}

	public void setState(Set<State> state) {
		this.state = state;
	}

	public Member getOwner() {
		return owner;
	}

	public void setOwner(Member owner) {
		this.owner = owner;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public ItemState getItemState() {
		return itemState;
	}

	public void setItemState(ItemState itemState) {
		this.itemState = itemState;
	}

	public Set<Price> getPrices() {
		return prices;
	}

	public void setPrices(Set<Price> prices) {
		this.prices = prices;
	}

	public SecurityInfo getSecurity() {
		return security;
	}

	public void setSecurity(SecurityInfo security) {
		this.security = security;
	}
	
}