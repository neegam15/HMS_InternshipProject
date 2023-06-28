package com.cg.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.cg.entity.RoomDetails;
import com.cg.model.RoomDetailsPayload;

@Validated
public interface IRoomDetailsService {
	RoomDetails addRoomDetails(@Valid RoomDetailsPayload roomDetailsPayload, int hotelId);

	RoomDetails updateRoomDetails(@Valid RoomDetails roomDetails);

	List<RoomDetails> showAllRoomDetails();

	RoomDetails showRoomDetails(int roomDetailsId);

	RoomDetails removeRoomDetails(int roomId);

	RoomDetails saveRooms(@Valid RoomDetails roomdetails);

	void cancelBooking(int bookingId);
}