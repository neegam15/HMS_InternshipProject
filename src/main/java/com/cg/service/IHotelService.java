package com.cg.service;

import java.util.List;

import com.cg.entity.Hotel;

import com.cg.model.RoomDetailsPayload;

public interface IHotelService {
	Hotel addHotel(Hotel hotel);

	Hotel updateHotel(Hotel hotel);

	void removeHotel(int hotelId);

	List<Hotel> showAllHotels();

	Hotel showHotel(int hotelId);

	void addRoomsToHotel(RoomDetailsPayload roomDetailsPayload, int hotelId);

}