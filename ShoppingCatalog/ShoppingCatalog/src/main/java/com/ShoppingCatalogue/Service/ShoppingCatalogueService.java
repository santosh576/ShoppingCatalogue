package com.ShoppingCatalogue.Service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.ShoppingCatalogue.ModelClass.Catalogue;

@Service
public interface ShoppingCatalogueService {
	
	public List<Catalogue> getAllCatalogueItems();
	
}
