package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.BookingDetails;
import com.cg.entity.Payments;
import com.cg.entity.User;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.BookingDetailsReceipt;
import com.cg.repository.IPaymentsRepository;

@Service
public class PaymentsServiceImpl implements IPaymentsService {
	@Autowired
	private IPaymentsRepository paymentRepository;

	@Autowired
	private IBookingDetailsService bookingService;

	@Autowired
	private IUserService userService;

	@Override
	public Payments addPayment(Payments payment) {
		return paymentRepository.save(payment);
	}

	@Override
	public Payments showPaymentById(int paymentId) {
		Optional<Payments> optionalPayments = paymentRepository.findById(paymentId);
		if (optionalPayments.isEmpty())
			throw new ResourceNotFoundException("No Payment with the id " + paymentId + " found");
		return optionalPayments.get();

	}

	@Override
	public BookingDetailsReceipt showInvoiceById(int bookingId) {
		BookingDetailsReceipt bookingDetailsReceipt = new BookingDetailsReceipt();
		Optional<Payments> optionalPayment = paymentRepository.findByBookingId(bookingId);
		Payments payment = optionalPayment.get();
		int bookedId = payment.getBookingId();
		BookingDetails bookingDetails = bookingService.showBookingDetails(bookedId);
		bookingDetailsReceipt.setPayment(payment);
		bookingDetailsReceipt.setRoomDetails(bookingDetails.getRooms());
		int userId = bookingDetails.getUserId();
		User user = userService.showUser(userId);
		bookingDetailsReceipt.setUserIdPayload(userId);
		bookingDetailsReceipt.setUserNamePayload(user.getUserName());
		bookingDetailsReceipt.setAddressPayload(user.getAddress());
		bookingDetailsReceipt.setEmailPayload(user.getEmail());
		bookingDetailsReceipt.setMobilePayload(user.getMobile());
		return bookingDetailsReceipt;

	}

	@Override
	public String paymentRefund(int bookingId) {

		Optional<Payments> optional = paymentRepository.findByBookingId(bookingId);
		if (!optional.isPresent()) {
			throw new ResourceNotFoundException("booking id not found");
		}
		Payments payment = optional.get();
		double amount = payment.getAmount();
		paymentRepository.delete(payment);
		return "Payment Refund Initiated for $" + amount + " with booking_id:" + bookingId + " is cancelled";
	}

	@Override
	public List<Payments> showAllPayments() {
		return paymentRepository.findAll();
	}

}