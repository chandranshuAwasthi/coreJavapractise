package com.csv.prod;

public class SerialBanUsed {
	
	public String billing_account_reference;
	private String Serial_Number;
	private String type;
	public SerialBanUsed(String billing_account_reference, String serial_Number, String type) {
		super();
		this.billing_account_reference = billing_account_reference;
		Serial_Number = serial_Number;
		this.type = type;
	}
	public String getBilling_account_reference() {
		return billing_account_reference;
	}
	public void setBilling_account_reference(String billing_account_reference) {
		this.billing_account_reference = billing_account_reference;
	}
	public String getSerial_Number() {
		return Serial_Number;
	}
	public void setSerial_Number(String serial_Number) {
		Serial_Number = serial_Number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
	

}
