package com.liferay.samples.fbo.booking.service.impl;

import com.liferay.portal.kernel.cache.MultiVMPool;
import com.liferay.portal.kernel.cache.PortalCache;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.petra.lang.HashUtil;
import com.liferay.samples.fbo.booking.service.api.BookingLocalService;
import com.liferay.samples.fbo.bookings.model.Booking;
import com.liferay.samples.fbo.bookings.model.BookingInformation;
import com.liferay.samples.fbo.bookings.model.BookingStatusEnum;
import com.liferay.samples.fbo.bookings.model.CheckBookingStatusRequest;
import com.liferay.samples.fbo.bookings.model.CheckBookingStatusResponse;
import com.liferay.samples.fbo.bookings.model.InitBookingRequest;
import com.liferay.samples.fbo.bookings.model.InitBookingResponse;
import com.liferay.samples.fbo.bookings.model.ListBookingsRequest;
import com.liferay.samples.fbo.bookings.model.ListBookingsResponse;
import com.liferay.samples.fbo.bookings.model.UpdateBookingStatusRequest;
import com.liferay.samples.fbo.bookings.model.UpdateBookingStatusResponse;
import com.liferay.samples.fbo.bookings_web_service.BookingsPort;
import com.liferay.samples.fbo.bookings_web_service.BookingsPortFactory;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		service = BookingLocalService.class
		)
public class BookingLocalServiceImpl implements BookingLocalService {

	@Override
	public Booking initBookingRequest(BookingInformation bookingInformation) {

		InitBookingRequest request = new InitBookingRequest();
		request.setBookingInformation(bookingInformation);

		BookingsPort bookingsPort = bookingsPortFactory.getPort();
		InitBookingResponse response = bookingsPort.initBooking(request);
		
		return response.getBooking();
	}

	@Override
	public Booking checkBookingStatus(String bookingId) {

		CheckBookingStatusRequest request = new CheckBookingStatusRequest();
		request.setBookingId(bookingId);

		BookingContentKey key = new BookingContentKey(bookingId);
		BookingCacheItem bookingCacheItem = _portalCache.get(key);
		
		if(bookingCacheItem == null) {

			_log.info("Cache missed for bookingId " + bookingId);

			BookingsPort bookingsPort = bookingsPortFactory.getPort();
			CheckBookingStatusResponse response = bookingsPort.checkBookingStatus(request);
			Booking booking = response.getBooking();
			_portalCache.put(key, new BookingCacheItem(booking));
			
			_log.info("Cache entry added for bookingId " + bookingId);

			return booking;
			
		} else {
			
			_log.info("Cache hit for bookingId " + bookingId);
			
			return bookingCacheItem.getBooking();
		}

	}

	@Override
	public List<String> listBookings(int start, int count) {

		ListBookingsRequest request = new ListBookingsRequest();
		request.setStartingItem(BigInteger.valueOf(start));
		request.setNumberOfItems(BigInteger.valueOf(count));
		
		BookingsPort bookingsPort = bookingsPortFactory.getPort();
		ListBookingsResponse response = bookingsPort.listBookings(request);

		return response.getBookingId();
	}
	
	@Override
	public Booking updateBookingStatus(String bookingId, BookingStatusEnum status) {

		UpdateBookingStatusRequest request = new UpdateBookingStatusRequest();
		request.setBookingId(bookingId);
		request.setBookingStatus(status);
		
		BookingContentKey key = new BookingContentKey(bookingId);
		_portalCache.remove(key);
		
		_log.info("Cache entry removed for bookingId " + bookingId);
		
		BookingsPort bookingsPort = bookingsPortFactory.getPort();
		UpdateBookingStatusResponse response = bookingsPort.updateBookingStatus(request);
		
		return response.getBooking();
	}	

	private static Log _log = LogFactoryUtil.getLog(BookingLocalServiceImpl.class);
	
    private BookingsPortFactory bookingsPortFactory;

    @Reference
    public void setBookingsPortFactory(BookingsPortFactory bookingsPortFactory) {
        this.bookingsPortFactory = bookingsPortFactory;
    }
    
	@Activate
	protected void activate() {
		_portalCache = (PortalCache<BookingContentKey, BookingCacheItem>) _multiVMPool.getPortalCache(CACHE_NAME);
	}
	
	@Deactivate
	public void deactivate() {
	    _multiVMPool.removePortalCache(CACHE_NAME);
	}
	
	private static PortalCache<BookingContentKey, BookingCacheItem> _portalCache;
	
	protected static final String CACHE_NAME = Booking.class.getName();
	
	@Reference
	private MultiVMPool _multiVMPool;
	
	private static class BookingContentKey implements Serializable {

		@Override
		public boolean equals(Object object) {
			BookingContentKey bookingContentKey = (BookingContentKey)object;
			return (bookingContentKey.bookingId.equals(bookingId));
		}

		@Override
		public int hashCode() {
			return HashUtil.hash(0, bookingId);
		}

		private BookingContentKey(String bookingId) {
			this.bookingId = bookingId;
		}

		private static final long serialVersionUID = 1L;

		private final String bookingId;

	}
	
}
