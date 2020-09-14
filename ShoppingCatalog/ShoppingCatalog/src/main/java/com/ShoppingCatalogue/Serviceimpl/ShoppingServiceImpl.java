package com.ShoppingCatalogue.Serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShoppingCatalogue.ModelClass.Catalogue;
import com.ShoppingCatalogue.Repository.CatalogRepository;
import com.ShoppingCatalogue.Service.ShoppingCatalogueService;

@Service
public class ShoppingServiceImpl implements ShoppingCatalogueService {

	@Autowired
	CatalogRepository catalogRepository;

	@Override
	public List<Catalogue> getAllCatalogueItems() {

		return catalogRepository.findAll().stream().sorted((c1, c2) -> {
			if (c1.getPrice() > c2.getPrice())
				return 1;
			else if (c1.getPrice() == c2.getPrice()) 
				return 0;
			return -1;
		}).collect(Collectors.toList());
	}
}
