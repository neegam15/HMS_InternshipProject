package com.cg.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.BookingDetails;
import com.cg.entity.RoomDetails;
import com.cg.exception.ResourceNotFoundException;
import com.cg.repository.IBookingDetailsRepository;
import com.cg.repository.IRoomDetailsRepository;

@Service
public class BookingDetailsServiceImpl implements IBookingDetailsService {
	@Autowired
	private IBookingDetailsRepository bookingDetailsRepository;
	@Autowired
	private IRoomDetailsRepository roomDetailsRepository;

	@Override
	public BookingDetails addBookingDetails(BookingDetails bookingDetails) {
		return bookingDetailsRepository.save(bookingDetails);
	}

	@Override
	public BookingDetails updateBookingDetails(BookingDetails bookingDetails) {

		BookingDetails updateBookingDetails = showBookingDetails(bookingDetails.getBookingId());
		updateBookingDetails = bookingDetailsRepository.save(updateBookingDetails);
		return updateBookingDetails;
	}

	@Override
	public void removeBookingDetails(int bookingId) {

		BookingDetails bookingDetails = showBookingDetails(bookingId);
		if (bookingDetails == null) {
			throw new ResourceNotFoundException("No booking found with id : " + bookingId);
		}
		bookingDetailsRepository.delete(bookingDetails);

	}

	@Override
	public List<BookingDetails> showAllBookingDetails() {
		return bookingDetailsRepository.findAll();
	}

	@Override
	public BookingDetails showBookingDetails(int bookingId) {
		Optional<BookingDetails> optionalBookingDetails = bookingDetailsRepository.findById(bookingId);
		if (optionalBookingDetails.isEmpty())
			throw new ResourceNotFoundException("User Not found with id : " + bookingId);
		return optionalBookingDetails.get();

	}

	@Override
	public String refreshBookingDetails() {
		List<BookingDetails> allBookingDetailsList = showAllBookingDetails();
		for (BookingDetails booking : allBookingDetailsList) {
			if (ChronoUnit.DAYS.between(booking.getBookedTo(), LocalDate.now()) < 0) {
				List<RoomDetails> allRoomDetailsList = booking.getRooms();
				for (RoomDetails roomDetails : allRoomDetailsList) {
					roomDetailsRepository.setAvailableToTrue(roomDetails.getRoomId());
					roomDetailsRepository.freeTheRoom(roomDetails.getRoomId());
				}
			}
		}
		return "Booking details refreshed";
	}

}