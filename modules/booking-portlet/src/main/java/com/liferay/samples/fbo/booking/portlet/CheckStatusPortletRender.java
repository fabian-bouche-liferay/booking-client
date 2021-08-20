package com.liferay.samples.fbo.booking.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.samples.fbo.booking.constants.BookingPortletKeys;
import com.liferay.samples.fbo.booking.service.api.BookingLocalService;
import com.liferay.samples.fbo.bookings.model.Booking;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + BookingPortletKeys.BOOKING,
				"mvc.command.name=checkStatus"
		},
		service = MVCRenderCommand.class
	)
public class CheckStatusPortletRender implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		Booking booking = bookingLocalService.checkBookingStatus(ParamUtil.get(renderRequest, "bookingId", ""));
		renderRequest.setAttribute("booking", booking);
		
		return "/checkStatus.jsp";
	}

	private static Log _log = LogFactoryUtil.getLog(CheckStatusPortletRender.class);
	
	@Reference
	private BookingLocalService bookingLocalService;

}
