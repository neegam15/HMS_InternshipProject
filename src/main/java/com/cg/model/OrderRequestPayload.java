package com.cg.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

public class OrderRequestPayload {
	@Column(name = "hotel_id")
	private int hotelIdPayload;
	@Column(name = "user_id")
	private int userIdPayload;
	@Column(name = "booked_to")
	private LocalDate bookedToPayload;
	@Column(name = "no_of_adults")
	private int noOfAdultsPayload;
	@Column(name = "no_of_children")
	private int noOfChildrenPayload;
	@Column(name = "booked_from")
	private LocalDate bookedFromPayload;

	private List<Integer> orderRoomId = new ArrayList<>();

	public int getHotelIdPayload() {
		return hotelIdPayload;
	}

	public void setHotelIdPayload(int hotelIdPayload) {
		this.hotelIdPayload = hotelIdPayload;
	}

	public int getUserIdPayload() {
		return userIdPayload;
	}

	public void setUserIdPayload(int userIdPayload) {
		this.userIdPayload = userIdPayload;
	}

	public LocalDate getBookedToPayload() {
		return bookedToPayload;
	}

	public void setBookedToPayload(LocalDate bookedToPayload) {
		this.bookedToPayload = bookedToPayload;
	}

	public int getNoOfAdultsPayload() {
		return noOfAdultsPayload;
	}

	public void setNoOfAdultsPayload(int noOfAdultsPayload) {
		this.noOfAdultsPayload = noOfAdultsPayload;
	}

	public int getNoOfChildrenPayload() {
		return noOfChildrenPayload;
	}

	public void setNoOfChildrenPayload(int noOfChildrenPayload) {
		this.noOfChildrenPayload = noOfChildrenPayload;
	}

	public LocalDate getBookedFromPayload() {
		return bookedFromPayload;
	}

	public void setBookedFromPayload(LocalDate bookedFromPayload) {
		this.bookedFromPayload = bookedFromPayload;
	}

	public List<Integer> getOrderRoomId() {
		return orderRoomId;
	}

	public void setOrderRoomId(List<Integer> orderRoomId) {
		this.orderRoomId = orderRoomId;
	}

}