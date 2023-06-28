package com.cg.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

public class HotelControllerPayload {
	@Column(name = "hotel_id")
	private int hotelIdPayload;
	private List<RoomDetailsPayload> roomdetailsPayload = new ArrayList<>();

	public int getHotelIdPayload() {
		return hotelIdPayload;
	}

	public void setHotelIdPayload(int hotelIdPayload) {
		this.hotelIdPayload = hotelIdPayload;
	}

	public List<RoomDetailsPayload> getRoomdetailsPayload() {
		return roomdetailsPayload;
	}

	public void setRoomdetailsPayload(List<RoomDetailsPayload> roomdetails) {
		this.roomdetailsPayload = roomdetails;
	}

}