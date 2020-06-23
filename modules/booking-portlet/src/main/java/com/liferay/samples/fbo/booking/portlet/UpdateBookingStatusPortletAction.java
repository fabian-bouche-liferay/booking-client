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
import com.liferay.samples.fbo.bookings.model.BookingStatusEnum;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + BookingPortletKeys.BOOKING,
			"mvc.command.name=updateBookingStatus"
		},
		service = MVCActionCommand.class
	)
public class UpdateBookingStatusPortletAction implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

		_log.info("Update status request...");

		String bookingId = ParamUtil.get(actionRequest, "bookingId", "");
		BookingStatusEnum status = BookingStatusEnum.fromValue(ParamUtil.get(actionRequest, "bookingStatus", ""));
		bookingLocalService.updateBookingStatus(bookingId, status);
		
		_log.info("Updated booking with ID: " + bookingId);

		return true;
	}

	private static Log _log = LogFactoryUtil.getLog(UpdateBookingStatusPortletAction.class);
	
	@Reference
	private BookingLocalService bookingLocalService;
}
