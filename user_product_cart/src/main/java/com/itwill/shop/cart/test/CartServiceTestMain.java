package com.itwill.shop.cart.test;

import com.itwill.shop.cart.CartItem;
import com.itwill.shop.cart.CartService;
import com.itwill.shop.product.Product;

public class CartServiceTestMain {
	public static void main(String[] args) throws Exception {
		CartService cartService =new CartService();
		CartItem cartItem=new CartItem(0, "guard1", new Product(1, null, 0, null, null, 0), 2);
		cartService.addCart(cartItem);
	}

}
