package com.spring.domain;

public class WaybillVO {
	
	private int wb_num;
	private int order_num;
	private String sender;
	private String receiver;
	private int quantity;
	private String p_name;
	private String c_point;
	private String s_point;
	private String address;
	
	
	public int getWb_num() {
		return wb_num;
	}
	public void setWb_num(int wb_num) {
		this.wb_num = wb_num;
	}
	public int getOrder_num() {
		return order_num;
	}
	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getC_point() {
		return c_point;
	}
	public void setC_point(String c_point) {
		this.c_point = c_point;
	}
	public String getS_point() {
		return s_point;
	}
	public void setS_point(String s_point) {
		this.s_point = s_point;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
	
	
}
