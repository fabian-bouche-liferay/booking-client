package com.liferay.samples.fbo.booking.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.samples.fbo.booking.constants.BookingPortletKeys;
import com.liferay.samples.fbo.booking.service.api.BookingLocalService;
import com.liferay.samples.fbo.bookings.model.Booking;
import com.liferay.samples.fbo.bookings.model.BookingInformation;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + BookingPortletKeys.BOOKING,
			"mvc.command.name=initBooking"
		},
		service = MVCActionCommand.class
	)
public class InitBookingPortletAction implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

		_log.info("Insertion request...");
		
		try {
			String city = ParamUtil.get(actionRequest, "city", "");

			BookingInformation bookingInformation = new BookingInformation();
			bookingInformation.setCity(city);
			bookingInformation.setArrivalDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(ParamUtil.get(actionRequest, "arrivalDate", "")));
			bookingInformation.setDepartureDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(ParamUtil.get(actionRequest, "departureDate", "")));
			Booking booking = bookingLocalService.initBookingRequest(bookingInformation);
			
			_log.info("Inserted booking with ID: " + booking.getBookingId());

		} catch (DatatypeConfigurationException e) {
			_log.error("Date conversion error", e);
			throw new PortletException();
		}

		return true;
	}

	private static Log _log = LogFactoryUtil.getLog(InitBookingPortletAction.class);
	
	@Reference
	private BookingLocalService bookingLocalService;
}
