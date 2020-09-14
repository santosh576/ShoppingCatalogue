package com.ShoppingCatalogue.Serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ShoppingCatalogue.Exceptions.UserMessage;
import com.ShoppingCatalogue.ModelClass.ShoppingCart;
import com.ShoppingCatalogue.Repository.CartRepository;
import com.ShoppingCatalogue.Repository.CatalogRepository;
import com.ShoppingCatalogue.Service.ShoppingCartService;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

	Logger logger = LoggerFactory.getLogger(ShoppingCartServiceImpl.class);

	private static final String EXCEPTION_OCCURED_WHILE_SAVING = "Exception occured while saving";

	private static final String NO_ITEMS_AVAILABLE_IN_CART = "No Items Available in Cart";

	private static final String EXCEPTION_OCCURED_WHILE_DELETING = "Exception occured while Deleting";
	@Autowired
	CartRepository cartrepository;

	@Autowired
	CatalogRepository catalogRepository;

	@Override
	public List<ShoppingCart> returnCartDetails(String userid) {
		List<ShoppingCart> cartDetails = new ArrayList<>();

		cartDetails = cartrepository.findbyuserid(userid);
		if (cartDetails.isEmpty()) {
			throw new UserMessage(NO_ITEMS_AVAILABLE_IN_CART);
		} else {
			return cartDetails;
		}

	}

	@Override
	public boolean addItemsToCart(ShoppingCart payload) {
		try {
			int price = catalogRepository.findprice(payload.getCatalogname());
			payload.setPrice(price);

			cartrepository.save(payload);
			return true;
		} catch (Exception exception) {
			logger.error(EXCEPTION_OCCURED_WHILE_SAVING, exception.getMessage());
			exception.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean editCartQuantity(ShoppingCart payload) {
		String quantity = cartrepository.findQuantity(payload.getCatalogname());
		try {
			if (quantity != null) {

				cartrepository.updateCartQuantity(payload.getQuantity(),
						payload.getCatalogname(), payload.getUserId());
			}
			return true;
		} catch (Exception exception) {
			logger.error(EXCEPTION_OCCURED_WHILE_SAVING, exception.getMessage());
			exception.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteCart(String userid) {
		try {

			cartrepository.deleteUserCart(userid);
			return true;
		} catch (Exception exception) {
			logger.error(EXCEPTION_OCCURED_WHILE_DELETING,
					exception.getMessage());
			exception.printStackTrace();
			return false;
		}

	}

}
