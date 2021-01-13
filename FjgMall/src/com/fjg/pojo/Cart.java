package com.fjg.pojo;

import java.math.BigDecimal;

public class Cart {
	private BigDecimal id;				//购物车id
	private BigDecimal f_user_id;		//用户id
	private BigDecimal f_product_id;	//商品id
	private String cart_name;			//加入购物车商品名
	private BigDecimal cart_num = new BigDecimal(1);		//加入购物车商品数量
	private BigDecimal cart_price;		//加入购物车商品价格
	private BigDecimal price_total;		//总金额
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public BigDecimal getF_user_id() {
		return f_user_id;
	}
	public void setF_user_id(BigDecimal f_user_id) {
		this.f_user_id = f_user_id;
	}
	public BigDecimal getF_product_id() {
		return f_product_id;
	}
	public void setF_product_id(BigDecimal f_product_id) {
		this.f_product_id = f_product_id;
	}
	public String getCart_name() {
		return cart_name;
	}
	public void setCart_name(String cart_name) {
		this.cart_name = cart_name;
	}
	public BigDecimal getCart_num() {
		return cart_num;
	}
	public void setCart_num(BigDecimal cart_num) {
		this.cart_num = cart_num;
	}
	public BigDecimal getCart_price() {
		return cart_price;
	}
	public void setCart_price(BigDecimal cart_price) {
		this.cart_price = cart_price;
	}
	public BigDecimal getPrice_total() {
		return price_total;
	}
	public void setPrice_total(BigDecimal price_total) {
		this.price_total = price_total;
	}
	public Cart(BigDecimal id, BigDecimal f_user_id, BigDecimal f_product_id, String cart_name, BigDecimal cart_num,
			BigDecimal cart_price, BigDecimal price_total) {
		super();
		this.id = id;
		this.f_user_id = f_user_id;
		this.f_product_id = f_product_id;
		this.cart_name = cart_name;
		this.cart_num = cart_num;
		this.cart_price = cart_price;
		this.price_total = price_total;
	}
	public Cart() {
		super();
	}
	
	
	public Cart(BigDecimal cart_num, BigDecimal price_total) {
		super();
		this.cart_num = cart_num;
		this.price_total = price_total;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", f_user_id=" + f_user_id + ", f_product_id=" + f_product_id + ", cart_name="
				+ cart_name + ", cart_num=" + cart_num + ", cart_price=" + cart_price + ", price_total=" + price_total
				+ "]";
	}
	
	
}
