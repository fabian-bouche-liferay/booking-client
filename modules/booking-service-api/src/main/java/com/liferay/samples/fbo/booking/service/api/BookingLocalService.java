package com.liferay.samples.fbo.booking.service.api;

import java.util.List;

import com.liferay.samples.fbo.bookings.model.Booking;
import com.liferay.samples.fbo.bookings.model.BookingInformation;
import com.liferay.samples.fbo.bookings.model.BookingStatusEnum;

public interface BookingLocalService {

	public Booking checkBookingStatus(String bookingId);

	public Booking updateBookingStatus(String bookingId, BookingStatusEnum status);

	public Booking initBookingRequest(BookingInformation bookingInformation);

	List<String> listBookings(int start, int count);
	
}