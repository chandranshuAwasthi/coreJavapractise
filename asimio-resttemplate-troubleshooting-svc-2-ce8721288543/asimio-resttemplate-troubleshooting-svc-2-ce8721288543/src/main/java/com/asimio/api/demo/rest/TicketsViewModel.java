package com.asimio.api.demo.rest;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * TicketsViewModel
 */


@JsonInclude(JsonInclude.Include.NON_NULL)
public class TicketsViewModel implements Serializable {

	private static final long serialVersionUID = -1222291233707603817L;

	private StatusMessage message;

	private Long ticketId;

	@JsonIgnore
	private Long ticketPriority;
    @JsonIgnore
	private Long manualPriority;

	private String ticketType;

	private String ticketSubType;

	private String updatedDateTime;

	private String ownedBy;

	private Long priority;

	private String orderType;

	private String orderSubType;

	private String ccd;

	private String ticketStatus;

	private String pool;

	private String parkUntil;

	private String additionalDescription;

	private String appointmentDate;

	
	private String userName;
	
	
	public Long getTicketId() {
		return ticketId;
	}

	public String getParkUntil() {
		return parkUntil;
	}

	public void setParkUntil(String parkUntil) {
		this.parkUntil = parkUntil;
	}

	

	public String getPool() {
		return pool;
	}

	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	public String getTicketSubType() {
		return ticketSubType;
	}

	public void setTicketSubType(String ticketSubType) {
		this.ticketSubType = ticketSubType;
	}

	public String getUpdatedDateTime() {
		return updatedDateTime;
	}

	public void setUpdatedDateTime(String updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}

	public String getOwnedBy() {
		return ownedBy;
	}

	public void setOwnedBy(String ownedBy) {
		this.ownedBy = ownedBy;
	}

	public Long getPriority() {
		return priority;
	}

	public void setPriority(Long priority) {
		this.priority = priority;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getOrderSubType() {
		return orderSubType;
	}

	public void setOrderSubType(String orderSubType) {
		this.orderSubType = orderSubType;
	}

	public String getCcd() {
		return ccd;
	}

	public void setCcd(String ccd) {
		this.ccd = ccd;
	}

	public String getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPool(String pool) {
		this.pool = pool;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public Long getTicketPriority() {
		return ticketPriority;
	}

	public void setTicketPriority(Long ticketPriority) {
		this.ticketPriority = ticketPriority;
	}

	public Long getManualPriority() {
		return manualPriority;
	}

	public void setManualPriority(Long manualPriority) {
		this.manualPriority = manualPriority;
	}

	public StatusMessage getMessage() {
		return message;
	}

	public void setMessage(StatusMessage message) {
		this.message = message;
	}

	public String getAdditionalDescription() {
		return additionalDescription;
	}

	public void setAdditionalDescription(String additionalDescription) {
		this.additionalDescription = additionalDescription;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	@Override
	public String toString() {
		return "TicketsViewModel{" + "ticketId=" + ticketId + ", ticketType='" + ticketType + '\'' + ", ticketSubType='"
				+ ticketSubType + '\'' + ", updatedDateTime='" + updatedDateTime + '\'' + ", additionalDescription='"
				+ additionalDescription + '\'' + ", appointmentDate='" + appointmentDate + '\'' + ", ownedBy='"
				+ ownedBy + '\'' + ", priority=" + priority + ", orderType='" + orderType + '\'' + ", orderSubType='"
				+ orderSubType + '\'' + ", ccd='" + ccd + '\'' + ", ticketStatus='" + ticketStatus + '\'' + ", pool='"
				+ pool + '\'' + ", parkUntil='" + parkUntil + '\'' + ", userName='" + userName + '\'' + '}';
	}

}
