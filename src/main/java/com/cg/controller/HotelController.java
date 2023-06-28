package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Hotel;
import com.cg.entity.RoomDetails;
import com.cg.model.HotelControllerPayload;
import com.cg.model.RoomDetailsPayload;
import com.cg.service.IHotelService;
import com.cg.service.IRoomDetailsService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	@Autowired
	private IHotelService hotelService;
	@Autowired
	private IRoomDetailsService roomDetailsService;

	@PostMapping("/save")
	public ResponseEntity<Hotel> addHotel(@Valid @RequestBody Hotel hotel) {
		Hotel hotelDetail = hotelService.addHotel(hotel);
		return new ResponseEntity<>(hotelDetail, HttpStatus.CREATED);
	}

	@GetMapping("/all/hotel")
	public List<Hotel> getAllHotelDetails() {
		return hotelService.showAllHotels();
	}

	@GetMapping("/get/{hotelid}")
	public ResponseEntity<Hotel> getHotelById(@Valid @PathVariable("hotelid") int hotelId) {
		Hotel returnedHotel = hotelService.showHotel(hotelId);

		return new ResponseEntity<>(returnedHotel, HttpStatus.OK);
	}

	@PostMapping("/save/rooms")
	public ResponseEntity<String> addRoomToHotel(@Valid @RequestBody HotelControllerPayload hcp) {

		int hotelId = hcp.getHotelIdPayload();
		Hotel existinghotel = hotelService.showHotel(hotelId);
		List<RoomDetails> allRoomsInHotel = existinghotel.getRooms();
		for (RoomDetailsPayload roomDetailsPayload : hcp.getRoomdetailsPayload()) {

			RoomDetails roomDetails = roomDetailsService.addRoomDetails(roomDetailsPayload, hotelId);
			allRoomsInHotel.add(roomDetails);

		}
		existinghotel.setRooms(allRoomsInHotel);
		return new ResponseEntity<>("saved room", HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{hotelid}")
	public ResponseEntity<String> deleteHotelById(@Valid @PathVariable("hotelid") int hotelId) {

		hotelService.removeHotel(hotelId);
		return new ResponseEntity<>("Hotel deleted", HttpStatus.OK);
	}

}