package com.cg.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.BookingDetailsReceipt;

import com.cg.service.IPaymentsService;

@RestController
@RequestMapping("/payments")
public class PaymentsController {
	@Autowired
	private IPaymentsService paymentsService;

	@GetMapping("/getinvoice/{bookingid}")

	public ResponseEntity<BookingDetailsReceipt> showPaymentsById(@Valid @PathVariable("bookingid") int bookingId) {
		BookingDetailsReceipt bookingDetailsReceipt = paymentsService.showInvoiceById(bookingId);

		return new ResponseEntity<>(bookingDetailsReceipt, HttpStatus.OK);

	}

	@DeleteMapping("/refund/{bookingid}")
	public ResponseEntity<String> refundPayment(@Valid @PathVariable("bookingid") int bookingId) {
		String message = paymentsService.paymentRefund(bookingId);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

}