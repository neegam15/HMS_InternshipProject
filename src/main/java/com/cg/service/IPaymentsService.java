package com.cg.service;

import java.util.List;

import com.cg.entity.Payments;
import com.cg.model.BookingDetailsReceipt;

public interface IPaymentsService {

	Payments addPayment(Payments payment);

	BookingDetailsReceipt showInvoiceById(int paymentId);

	Payments showPaymentById(int paymentId);

	String paymentRefund(int bookingId);

	List<Payments> showAllPayments();

}
