package com.cg.model;

import javax.persistence.Column;

public class RoomDetailsPayload {
	@Column(name = "room_id")
	private int roomIdPayload;
	@Column(name = "room_type")
	private String roomTypePayload;
	@Column(name = "rate_per_day")
	private double ratePerDayPayload;
	@Column(name = "is_available")
	private boolean isAvailablePayload;
	@Column(name = "room_no")
	private int roomNoPayload;

	public int getRoomIdPayload() {
		return roomIdPayload;
	}

	public void setRoomIdPayload(int roomIdPayload) {
		this.roomIdPayload = roomIdPayload;
	}

	public String getRoomTypePayload() {
		return roomTypePayload;
	}

	public void setRoomTypePayload(String roomTypePayload) {
		this.roomTypePayload = roomTypePayload;
	}

	public double getRatePerDayPayload() {
		return ratePerDayPayload;
	}

	public void setRatePerDayPayload(double ratePerDayPayload) {
		this.ratePerDayPayload = ratePerDayPayload;
	}

	public boolean isAvailablePayload() {
		return isAvailablePayload;
	}

	public void setAvailablePayload(boolean isAvailablePayload) {
		this.isAvailablePayload = isAvailablePayload;
	}

	public int getRoomNoPayload() {
		return roomNoPayload;
	}

	public void setRoomNoPayload(int roomNoPayload) {
		this.roomNoPayload = roomNoPayload;
	}

}