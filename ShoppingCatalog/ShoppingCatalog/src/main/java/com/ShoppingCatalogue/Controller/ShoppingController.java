package com.ShoppingCatalogue.Controller;

import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ShoppingCatalogue.ModelClass.Catalogue;
import com.ShoppingCatalogue.Responsetypes.CatalougeItems;
import com.ShoppingCatalogue.Service.ShoppingCatalogueService;


@RestController
@RequestMapping("api/shopping")
public class ShoppingController {
	
	@Autowired
	ShoppingCatalogueService shoppingCatalogueService;

	@GetMapping("/availablecatalogue")
	@ApiOperation(value="Return the available catalogue",notes="Return the list of available catalouge by requesting the required URI")
	public CatalougeItems getAllItemCatalogue()
	{
		List<Catalogue> catgalogItems=shoppingCatalogueService.
				getAllCatalogueItems();
		CatalougeItems catalogValues=new CatalougeItems();
		catalogValues.setAvailableCatalogs(catgalogItems);
		return catalogValues;
		
	}
}
