package com.ShoppingCatalogue.Repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ShoppingCatalogue.ModelClass.ShoppingCart;

@Repository
@Transactional
public interface CartRepository extends JpaRepository<ShoppingCart, String>{
	
	@Query("select u.quantity from ShoppingCart u where catalogueName=:"
			+ "catalogueName")
String findQuantity(@Param("catalogueName") String catalogName);
	
	@Query("select u from ShoppingCart u where userId=:userId")
	List<ShoppingCart> findbyuserid(@Param("userId") String userId);
	
	@Modifying
	@Query(value="delete from Shopping_Cart where user_Id=:userId" ,nativeQuery=true)
	void deleteUserCart(@Param("userId") String userId);
	
	@Modifying
	@Query(value="update Shopping_Cart set quantity=:quantity where catalogue_Name=:catalogueName"
			+ " and user_Id=:userId", nativeQuery=true)
	void updateCartQuantity(@Param("quantity") int quantity,
			@Param("catalogueName")String catalogueName
		   ,@Param("userId") String userId);
}
