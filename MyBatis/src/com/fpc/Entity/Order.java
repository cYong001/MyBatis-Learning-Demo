package com.fpc.Entity;

/*
 * ����orders���Ӧ��ʵ����
 * */
public class Order {
	/*
	 * Orderʵ��������������orders���е��ֶ����ǲ�һ����
	 * */
	private int id; //id & order_id
	private String orderNo; //orderNo & order_no
	private float orderPrice; //orderPrice & order_price
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public float getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(float orderPrice) {
		this.orderPrice = orderPrice;
	}
	
	public String toString() {
		return "Order [id=" + id + ", orderNo=" + orderNo + ", price=" + orderPrice+ "]";
	}
}
