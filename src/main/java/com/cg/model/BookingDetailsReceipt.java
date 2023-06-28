package com.cg.model;

import java.util.List;

import javax.persistence.Column;

import com.cg.entity.Payments;
import com.cg.entity.RoomDetails;

public class BookingDetailsReceipt {
	@Column(name = "user_id")
	private int userIdPayload;
	@Column(name = "user_name")
	private String userNamePayload;
	private String emailPayload;

	private long mobilePayload;
	private String addressPayload;

	private List<RoomDetails> roomDetails;

	private Payments payment;

	public Payments getPayment() {
		return payment;
	}

	public void setPayment(Payments payment) {
		this.payment = payment;
	}

	public int getUserIdPayload() {
		return userIdPayload;
	}

	public void setUserIdPayload(int userIdPayload) {
		this.userIdPayload = userIdPayload;
	}

	public String getUserNamePayload() {
		return userNamePayload;
	}

	public void setUserNamePayload(String userNamePayload) {
		this.userNamePayload = userNamePayload;
	}

	public String getEmailPayload() {
		return emailPayload;
	}

	public void setEmailPayload(String emailPayload) {
		this.emailPayload = emailPayload;
	}

	public long getMobilePayload() {
		return mobilePayload;
	}

	public void setMobilePayload(long mobilePayload) {
		this.mobilePayload = mobilePayload;
	}

	public String getAddressPayload() {
		return addressPayload;
	}

	public void setAddressPayload(String addressPayload) {
		this.addressPayload = addressPayload;
	}

	public List<RoomDetails> getRoomDetails() {
		return roomDetails;
	}

	public void setRoomDetails(List<RoomDetails> roomDetails) {
		this.roomDetails = roomDetails;
	}

}