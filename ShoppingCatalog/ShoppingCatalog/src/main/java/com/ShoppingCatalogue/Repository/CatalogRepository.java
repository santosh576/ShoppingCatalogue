package com.ShoppingCatalogue.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ShoppingCatalogue.ModelClass.Catalogue;

@Repository
public interface CatalogRepository extends JpaRepository<Catalogue, String> {
	
	
	@Query("select u.price from Catalogue u where u.catalogueName=:catalogueName")
	int findprice(@Param("catalogueName")String catalogueName);

	
}
