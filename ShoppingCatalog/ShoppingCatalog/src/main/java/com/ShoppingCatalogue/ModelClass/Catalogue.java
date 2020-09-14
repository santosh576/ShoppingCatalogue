package com.ShoppingCatalogue.ModelClass;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Catalogue {

	@Id
	@GeneratedValue
	public int id;
	
	@Column(name="catalogue_Name")
	public String catalogueName;
	
	public int price;

	public Catalogue()
	{
		
	}
	
	public Catalogue(int id, String catalogueName, int price) {
		super();
		this.id = id;
		this.catalogueName = catalogueName;
		this.price=price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getCatalogueName() {
		return catalogueName;
	}

	public void setCatalogueName(String catalogueName) {
		this.catalogueName = catalogueName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	
	
	

	
	
	
	
}
