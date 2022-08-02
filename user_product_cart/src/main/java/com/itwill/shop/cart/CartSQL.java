package com.itwill.shop.cart;

public class CartSQL {
	
	public static final String CART_SELECT_BY_USERID="select * from cart c join product p on p.p_no=c.p_no where c.userid=?";
	public static final String CART_INSERT="insert into cart(cart_no,userId,p_no,cart_qty) values (cart_cart_no_SEQ.nextval,?,?,?)";
	public static final String CART_UPDATE_BY_P_NO_USERID="update cart set cart_qty=cart_qty+? where userid=? and p_no=?";
	public static final String CART_SELECT_PRODUCT_COUNT_BY_USERID_P_NO=
			"select count(*)  as p_count from cart c join userinfo u on c.userid=u.userid where u.userid=? and c.p_no=?";
			
			
}
