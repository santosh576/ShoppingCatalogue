package com.ShoppingCatalogue.Responsetypes;

import java.util.List;

import com.ShoppingCatalogue.ModelClass.ShoppingCart;

public class CartResponse {
	
	
	public List<ShoppingCart> cartDetails;
	public int totalprice;
	
	public CartResponse(List<ShoppingCart> cartDetails, int totalprice) {
		super();
		this.cartDetails = cartDetails;
		this.totalprice = totalprice;
	}
	public CartResponse() {

	}
	public List<ShoppingCart> getCartDetails() {
		return cartDetails;
	}
	public void setCartDetails(List<ShoppingCart> cartDetails) {
		this.cartDetails = cartDetails;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	
	

}
