package com.ShoppingCatalogue.Responsetypes;

import java.util.List;

import com.ShoppingCatalogue.ModelClass.Catalogue;

public class CatalougeItems {

	
	private List<Catalogue> availableCatalogs;

	public CatalougeItems(){
		
	}
	
	public CatalougeItems(List<Catalogue> availableCatalogs) {
		super();
		this.availableCatalogs = availableCatalogs;
	}

	public List<Catalogue> getAvailableCatalogs() {
		return availableCatalogs;
	}

	public void setAvailableCatalogs(List<Catalogue> availableCatalogs) {
		this.availableCatalogs = availableCatalogs;
	}
	
	
}
