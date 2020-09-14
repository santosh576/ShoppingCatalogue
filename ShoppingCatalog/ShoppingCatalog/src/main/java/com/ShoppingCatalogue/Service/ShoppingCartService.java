package com.ShoppingCatalogue.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ShoppingCatalogue.ModelClass.ShoppingCart;

@Service
public interface ShoppingCartService {
	
	public List<ShoppingCart> returnCartDetails(String userid);
	
	public boolean addItemsToCart(ShoppingCart payload);
	
	public boolean editCartQuantity(ShoppingCart payload);
	
	public boolean deleteCart(String userid);

}
