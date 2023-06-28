package com.cg.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.RoomDetails;
import com.cg.model.HotelControllerPayload;
import com.cg.model.RoomDetailsPayload;
import com.cg.service.RoomDetailsServiceImpl;

@RestController
@RequestMapping("/roomdetails")
public class RoomDetailsController {
	@Autowired
	private RoomDetailsServiceImpl roomDetailsService;

	@PostMapping("/add")
	public ResponseEntity<List<RoomDetails>> addRoomDetails(@Valid @RequestBody HotelControllerPayload hcp) {
		List<RoomDetails> roomarr = new ArrayList<>();
		for (RoomDetailsPayload roomDetailsPayload : hcp.getRoomdetailsPayload()) {
			RoomDetails roomDetails = roomDetailsService.addRoomDetails(roomDetailsPayload, hcp.getHotelIdPayload());
			roomarr.add(roomDetails);
		}
		return new ResponseEntity<>(roomarr, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public List<RoomDetails> getAllRoomDetails() {
		return roomDetailsService.showAllRoomDetails();
	}

}