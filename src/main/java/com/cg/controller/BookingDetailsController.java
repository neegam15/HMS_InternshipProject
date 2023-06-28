package com.cg.controller;

import java.time.temporal.ChronoUnit;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.BookingDetails;
import com.cg.entity.Payments;
import com.cg.entity.RoomDetails;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.OrderRequestPayload;
import com.cg.service.IBookingDetailsService;
import com.cg.service.IPaymentsService;
import com.cg.service.IRoomDetailsService;

@RestController
@RequestMapping("/booking")
public class BookingDetailsController {
	@Autowired
	private IBookingDetailsService bookingDetailsService;
	@Autowired
	private IRoomDetailsService roomDetailsService;
	@Autowired
	private IPaymentsService paymentsService;

	@PostMapping("/save")
	public ResponseEntity<Object> bookRooms(@Valid @RequestBody OrderRequestPayload reqPayload) {
		BookingDetails bookkingDetails = new BookingDetails();
		bookkingDetails.setUserId(reqPayload.getUserIdPayload());
		bookkingDetails.setHotelId(reqPayload.getHotelIdPayload());
		bookkingDetails.setBookedTo(reqPayload.getBookedToPayload());
		bookkingDetails.setBookedFrom(reqPayload.getBookedFromPayload());
		bookkingDetails.setNoOfAdults(reqPayload.getNoOfAdultsPayload());
		bookkingDetails.setNoOfChildren(reqPayload.getNoOfChildrenPayload());
		double totalAmount = 0;
		List<RoomDetails> roomDetailsArray = bookkingDetails.getRooms();
		for (int room_id : reqPayload.getOrderRoomId()) {
			RoomDetails roomDetail = roomDetailsService.showRoomDetails(room_id);
			if (!roomDetail.isAvailable()) {
				throw new ResourceNotFoundException(
						"Room with Room Number:" + roomDetail.getRoomNo() + " is already booked. Please try again.");
			}
			totalAmount += roomDetail.getRatePerDay();
			roomDetailsArray.add(roomDetail);
			roomDetail.setBookingDetails(bookkingDetails);
			roomDetail.setAvailable(false);
		}

		totalAmount *= ChronoUnit.DAYS.between(bookkingDetails.getBookedFrom(), bookkingDetails.getBookedTo());
		bookkingDetails.setAmount(totalAmount);
		bookkingDetails.setRooms(roomDetailsArray);
		BookingDetails bookingDetailsToBeAdded = bookingDetailsService.addBookingDetails(bookkingDetails);

		Payments payment = new Payments();
		payment.setAmount(totalAmount);
		payment.setBookingId(bookkingDetails.getBookingId());
		paymentsService.addPayment(payment);

		return new ResponseEntity<>(bookingDetailsToBeAdded, HttpStatus.CREATED);
	}

	@GetMapping("/all")
	public List<BookingDetails> getAllBookingDetails() {
		return bookingDetailsService.showAllBookingDetails();

	}

	@GetMapping("/refresh")
	public ResponseEntity<String> refreshBookingDetails() {

		String response = bookingDetailsService.refreshBookingDetails();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/cancel/{roomid}")
	public ResponseEntity<String> cancelBookings(@Valid @PathVariable("roomid") int roomId) {
		roomDetailsService.cancelBooking(roomId);
		return new ResponseEntity<>("Booking Cancelled", HttpStatus.OK);
	}
}