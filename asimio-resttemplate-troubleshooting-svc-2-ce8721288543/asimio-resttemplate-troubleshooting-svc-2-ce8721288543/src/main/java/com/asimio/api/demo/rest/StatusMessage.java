package com.asimio.api.demo.rest;

import java.io.Serializable;

public class StatusMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4816735271563298013L;

	private String messageCode;

	private String message;

	public StatusMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StatusMessage(String message, String messageCode) {
		super();
		this.message = message;
		this.messageCode = messageCode;
	}

	@Override
	public String toString() {
		return "StatusMessage [messageCode=" + messageCode + ", message=" + message + "]";
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
