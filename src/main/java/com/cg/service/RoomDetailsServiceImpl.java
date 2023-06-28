package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Hotel;
import com.cg.entity.RoomDetails;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.RoomDetailsPayload;
import com.cg.repository.IRoomDetailsRepository;

@Service
public class RoomDetailsServiceImpl implements IRoomDetailsService {
	@Autowired
	private IRoomDetailsRepository roomDetailsRepository;
	@Autowired
	private IHotelService hotelService;

	@Override
	public RoomDetails addRoomDetails(RoomDetailsPayload roomDetailsPayload, int hotelId) {

		RoomDetails roomDetails = new RoomDetails();
		Hotel existingHotel = hotelService.showHotel(hotelId);
		roomDetails.setRoomId(roomDetailsPayload.getRoomIdPayload());
		roomDetails.setAvailable(true);
		roomDetails.setRatePerDay(roomDetailsPayload.getRatePerDayPayload());
		roomDetails.setRoomNo(roomDetailsPayload.getRoomNoPayload());
		roomDetails.setHotel(existingHotel);
		roomDetails.setRoomType(roomDetailsPayload.getRoomTypePayload());
		return roomDetailsRepository.save(roomDetails);
	}

	@Override
	public RoomDetails updateRoomDetails(RoomDetails roomDetails) {
		return showRoomDetails(roomDetails.getRoomId());
	}

	@Override
	public RoomDetails removeRoomDetails(int roomId) {
		RoomDetails roomDetails1 = showRoomDetails(roomId);
		if (roomDetails1 == null) {
			throw new ResourceNotFoundException("Room Not found with id : " + roomId);
		}
		return roomDetails1;
	}

	@Override
	public List<RoomDetails> showAllRoomDetails() {
		return roomDetailsRepository.findAll();
	}

	@Override
	public RoomDetails showRoomDetails(int roomDetailsId) {
		Optional<RoomDetails> optionalRoomDetails = roomDetailsRepository.findById(roomDetailsId);
		if (optionalRoomDetails.isEmpty())
			throw new ResourceNotFoundException("Room Not found with id : " + roomDetailsId);
		return optionalRoomDetails.get();
	}

	@Override
	public RoomDetails saveRooms(RoomDetails roomdetails) {
		return roomDetailsRepository.save(roomdetails);
	}

	@Override
	public void cancelBooking(int roomId) {
		List<RoomDetails> allRooms = showAllRoomDetails();
		for (RoomDetails roomDetails : allRooms) {
			if (roomDetails.getRoomId() == roomId) {
				roomDetailsRepository.setAvailableToTrue(roomId);
				roomDetailsRepository.freeTheRoom(roomId);
				updateRoomDetails(roomDetails);
			}
		}

	}

}