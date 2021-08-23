package com.liferay.samples.fbo.booking.service.api;

import com.liferay.samples.fbo.bookings.model.Booking;
import com.liferay.samples.fbo.bookings.model.BookingInformation;
import com.liferay.samples.fbo.bookings.model.BookingStatusEnum;
import com.liferay.samples.fbo.bookings.model.ListBookingsResponse;

import java.util.List;
import java.util.concurrent.Future;

import javax.xml.ws.AsyncHandler;

public interface BookingLocalService {

	public Booking checkBookingStatus(String bookingId);

	public Booking updateBookingStatus(String bookingId, BookingStatusEnum status);

	public Booking initBookingRequest(BookingInformation bookingInformation);

	public List<String> listBookings(int start, int count);

	Future<?> listBookingsAsync(int start, int count, AsyncHandler<ListBookingsResponse> listBookingsAsyncHandler);

}