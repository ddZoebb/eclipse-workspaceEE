package com.itwill.shop.cart.test;
import com.itwill.shop.cart.CartDao;
import com.itwill.shop.cart.CartItem;
import com.itwill.shop.product.Product;
public class CartDaoTestMain {
	public static void main(String[] args) throws Exception{
		CartDao cartDao=new CartDao();
		System.out.println("--------cart list------");
		System.out.println(cartDao.getCartList("guard1"));
		System.out.println("--------cart add------");
		//System.out.println(cartDao.add("guard3", 4, 3));
		
		//System.out.println(cartDao.add(new CartItem(0, "guard2", new Product(2, null, 0, null, null, 0), 3)));
		
		System.out.println("---cart product count(select)");
		
		System.out.println(cartDao.cartProductCount(new CartItem(0,"guard2",new Product(2,null,0,null,null,0),0)));
		
		System.out.println("--cart add(update)");
		System.out.println(cartDao.updateByProductNoAndUserId(new CartItem(0, "guard2", new Product(2,null,0,null,null,0), 3)));
	}
}
