package com.csv.prod;

public class PICVData {
	
	public String customer_id;
	public String customer_type;
	public String billing_account_reference;
	public String product_order_id;
	public String order_date;
	public String order_completed_date;
	public String product_instance_id;
	public String type;
	public String Serial_number;
	
	
	
	public PICVData(String customer_id, String customer_type, String billing_account_reference, String product_order_id,
			String order_date, String order_completed_date, String product_instance_id, 
			String serial_number,String type) {
		super();
		this.customer_id = customer_id;
		this.customer_type = customer_type;
		this.billing_account_reference = billing_account_reference;
		this.product_order_id = product_order_id;
		this.order_date = order_date;
		this.order_completed_date = order_completed_date;
		this.product_instance_id = product_instance_id;
		this.Serial_number = serial_number;
		this.type = type;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_type() {
		return customer_type;
	}
	public void setCustomer_type(String customer_type) {
		this.customer_type = customer_type;
	}
	public String getBilling_account_reference() {
		return billing_account_reference;
	}
	public void setBilling_account_reference(String billing_account_reference) {
		this.billing_account_reference = billing_account_reference;
	}
	public String getProduct_order_id() {
		return product_order_id;
	}
	public void setProduct_order_id(String product_order_id) {
		this.product_order_id = product_order_id;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public String getOrder_completed_date() {
		return order_completed_date;
	}
	public void setOrder_completed_date(String order_completed_date) {
		this.order_completed_date = order_completed_date;
	}
	public String getProduct_instance_id() {
		return product_instance_id;
	}
	public void setProduct_instance_id(String product_instance_id) {
		this.product_instance_id = product_instance_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSerial_number() {
		return Serial_number;
	}
	public void setSerial_number(String serial_number) {
		Serial_number = serial_number;
	}
	
	
	
}
