package com.liferay.samples.fbo.booking.service.impl;

import java.io.Serializable;

import com.liferay.samples.fbo.bookings.model.Booking;

public class BookingCacheItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private Booking booking;

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public BookingCacheItem(Booking booking) {
		super();
		this.booking = booking;
	}
	
}
