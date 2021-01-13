package com.fjg.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
	
	private BigDecimal id;
	private String order_no;
	private Date order_date;
	private BigDecimal order_price;
	private String order_status;
	private BigDecimal f_user_id;
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public BigDecimal getOrder_price() {
		return order_price;
	}
	public void setOrder_price(BigDecimal order_price) {
		this.order_price = order_price;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	public BigDecimal getF_user_id() {
		return f_user_id;
	}
	public void setF_user_id(BigDecimal f_user_id) {
		this.f_user_id = f_user_id;
	}
	public Order(BigDecimal id, String order_no, Date order_date, BigDecimal order_price, String order_status,
			BigDecimal f_user_id) {
		super();
		this.id = id;
		this.order_no = order_no;
		this.order_date = order_date;
		this.order_price = order_price;
		this.order_status = order_status;
		this.f_user_id = f_user_id;
	}
	public Order() {
		super();
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", order_no=" + order_no + ", order_date=" + order_date + ", order_price="
				+ order_price + ", order_status=" + order_status + ", f_user_id=" + f_user_id + "]";
	}
	
}
