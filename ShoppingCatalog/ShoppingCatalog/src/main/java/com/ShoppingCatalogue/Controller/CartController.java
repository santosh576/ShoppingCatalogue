package com.ShoppingCatalogue.Controller;

import io.swagger.annotations.ApiOperation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

import com.ShoppingCatalogue.ModelClass.ShoppingCart;
import com.ShoppingCatalogue.ModelClass.ValidationMessage;
import com.ShoppingCatalogue.Responsetypes.CartResponse;
import com.ShoppingCatalogue.Service.ShoppingCartService;

@RestController
@RequestMapping(value="api/shopping")
public class CartController {

	private static final String ERROR_ADDING_VALUES_TO_CART = "Error adding values to cart";
	private static final String ERROR_UPDATING_VALUES_TO_CART = "Error updating values to cart";
	private static final String SUCCESS = "Success";
	private static final String ERROR_DELETING_VALUES_TO_CART = "Error Deleting values to cart";
	
	@Autowired
	ShoppingCartService shoppingCartService;
	
	@Autowired
	WebClient.Builder webclient;
	
	@Value("${CartValidation}")
	String cartValidationuri;
	
	@GetMapping("/viewcart/{userid}")
	@ApiOperation(value="View the user cart",notes="User can view his cart based")
	public CartResponse viewCart(@PathVariable String userid)
	{
		List<ShoppingCart> cartDetails=shoppingCartService.returnCartDetails(userid);
		int finalprice=cartDetails.stream().mapToInt(price->price.getPrice()*price.getQuantity()).sum();
		CartResponse finalResponse=new CartResponse();
		finalResponse.setTotalprice(finalprice);
		finalResponse.setCartDetails(cartDetails);
		return finalResponse;
		
	}
	
	@PostMapping("/addcatalogue/cart/{userid}")
	@ApiOperation(value="Add items to cart",notes="user add items to cart with qunatity and catalogname")
	public ResponseEntity<String> addValuesToCart(
			@RequestBody ShoppingCart payload,
			@PathVariable String userid) {
		ValidationMessage validation=webclient.build().post().uri(cartValidationuri).
				contentType(MediaType.APPLICATION_JSON)
		.body(Mono.just(payload), ShoppingCart.class).accept(MediaType.APPLICATION_JSON).retrieve()
		.bodyToMono(ValidationMessage.class).block();
		if(validation.getMessage().size()==0)
		{
		boolean itemsadded = true;
		payload.setUserId(userid);
		itemsadded = shoppingCartService.addItemsToCart(payload);
		if (itemsadded) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(ERROR_ADDING_VALUES_TO_CART,
					HttpStatus.BAD_REQUEST);
		}
		}
		else
		{
			return new ResponseEntity<String>(validation.getMessage().toString(), HttpStatus.BAD_REQUEST);
		}

	}
	
	@PutMapping("/editquantity/cart/{userid}")
	@ApiOperation(value="edit quantity in cart",notes="user can edit his particular items quantity cart")
	public ResponseEntity<String> editquantity(@RequestBody ShoppingCart payload,
			@PathVariable String userid)
	{
		boolean itemsedited = true;
		payload.setUserId(userid);
		itemsedited=shoppingCartService.editCartQuantity(payload);
		if (itemsedited) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(ERROR_UPDATING_VALUES_TO_CART,
					HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("delete/cart/{userid}")
	@ApiOperation(value="delete items in cart",notes="user can delete his particular cart")
	public ResponseEntity<String> deletecart(@PathVariable String userid)
	{
		
		boolean itemsdeleted = true;
		itemsdeleted=shoppingCartService.deleteCart(userid);
		if (itemsdeleted) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(ERROR_DELETING_VALUES_TO_CART,
					HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
