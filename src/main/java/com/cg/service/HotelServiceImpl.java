package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Hotel;
import com.cg.entity.RoomDetails;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.RoomDetailsPayload;
import com.cg.repository.IHotelRepository;

@Service
public class HotelServiceImpl implements IHotelService {
	@Autowired
	private IHotelRepository hotelRepository;

	@Override
	public Hotel addHotel(Hotel hotel) {
		return hotelRepository.save(hotel);
	}

	@Override
	public Hotel updateHotel(Hotel hotel) {
		Hotel updateHotel = showHotel(hotel.getHotelId());
		updateHotel = hotelRepository.save(updateHotel);
		return updateHotel;
	}

	@Override
	public void removeHotel(int hotelId) {
		Hotel hotel1 = showHotel(hotelId);
		if (hotel1 == null) {
			throw new ResourceNotFoundException("Hotel Not found with id : " + hotelId);
		}
		hotelRepository.delete(hotel1);
	}

	@Override
	public List<Hotel> showAllHotels() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel showHotel(int hotelId) {
		Optional<Hotel> optionalHotel = hotelRepository.findById(hotelId);
		if (optionalHotel.isEmpty())
			throw new ResourceNotFoundException("Hotel Not found with id : " + hotelId);
		return optionalHotel.get();
	}

	@Override
	public void addRoomsToHotel(RoomDetailsPayload roomDetailsPayload, int hotelId) {
		Hotel existinghotel = showHotel(hotelId);
		List<RoomDetails> allRoomsInHotel = existinghotel.getRooms();
		RoomDetails roomDetails = new RoomDetails();
		roomDetails.setRoomId(roomDetailsPayload.getRoomIdPayload());
		roomDetails.setAvailable(true);
		roomDetails.setRatePerDay(roomDetailsPayload.getRatePerDayPayload());
		roomDetails.setRoomNo(roomDetailsPayload.getRoomNoPayload());
		roomDetails.setHotel(existinghotel);
		allRoomsInHotel.add(roomDetails);
		existinghotel.setRooms(allRoomsInHotel);
	}

}