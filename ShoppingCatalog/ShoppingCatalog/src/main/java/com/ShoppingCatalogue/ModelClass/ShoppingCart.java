package com.ShoppingCatalogue.ModelClass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Shopping_Cart")
public class ShoppingCart {

	@Id
	@GeneratedValue
	private int id;
	
	private String userId;
	
	@Column(name="catalogue_Name")
	private String catalogueName;
	
	private int quantity;
	private int price;
	public ShoppingCart()
	{
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCatalogname() {
		return catalogueName;
	}
	public void setCatalogname(String cataloguename) {
		this.catalogueName = cataloguename;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public ShoppingCart(int id, String cataloguename, int quantity, int price,String userId) {
		super();
		this.id = id;
		this.catalogueName = cataloguename;
		this.quantity = quantity;
		this.price = price;
		this.userId=userId;
	}
	
	
	
}
