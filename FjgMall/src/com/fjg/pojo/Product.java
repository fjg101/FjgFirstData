package com.fjg.pojo;

import java.math.BigDecimal;

public class Product {
	private BigDecimal id;					//商品id
	private BigDecimal f_user_id;			//用户id
	private String product_name;			//商品名
	private BigDecimal product_price;		//价格
	private BigDecimal product_sales;		//销量
	private BigDecimal product_stock;		//库存
	//图片路径
	private String product_img = "static/img/product.png";
	
	//get 、set
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
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public BigDecimal getProduct_price() {
		return product_price;
	}
	public void setProduct_price(BigDecimal product_price) {
		this.product_price = product_price;
	}
	public BigDecimal getProduct_sales() {
		return product_sales;
	}
	public void setProduct_sales(BigDecimal product_sales) {
		this.product_sales = product_sales;
	}
	public BigDecimal getProduct_stock() {
		return product_stock;
	}
	public void setProduct_stock(BigDecimal product_stock) {
		this.product_stock = product_stock;
	}
	public String getProduct_img() {
		return product_img;
	}
	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}
	public Product(BigDecimal id, BigDecimal f_user_id, String product_name, BigDecimal product_price,
			BigDecimal product_sales, BigDecimal product_stock, String product_img) {
		super();
		this.id = id;
		this.f_user_id = f_user_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_sales = product_sales;
		this.product_stock = product_stock;
		this.product_img = product_img;
	}
	public Product() {
		super();
	}
	public Product(BigDecimal id, BigDecimal f_user_id, String product_name, BigDecimal product_price,
			BigDecimal product_sales, BigDecimal product_stock) {
		super();
		this.id = id;
		this.f_user_id = f_user_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_sales = product_sales;
		this.product_stock = product_stock;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", f_user_id=" + f_user_id + ", product_name=" + product_name + ", product_price="
				+ product_price + ", product_sales=" + product_sales + ", product_stock=" + product_stock
				+ ", product_img=" + product_img + "]";
	}

}
