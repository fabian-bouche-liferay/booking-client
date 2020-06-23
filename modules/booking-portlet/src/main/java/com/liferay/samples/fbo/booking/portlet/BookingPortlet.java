package com.liferay.samples.fbo.booking.portlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.samples.fbo.booking.constants.BookingPortletKeys;
import com.liferay.samples.fbo.booking.service.api.BookingLocalService;
import com.liferay.samples.fbo.bookings.model.Booking;
import com.liferay.samples.fbo.bookings.model.BookingInformation;

/**
 * @author node
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Booking",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + BookingPortletKeys.BOOKING,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class BookingPortlet extends MVCPortlet {
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		int start = ParamUtil.get(renderRequest, "start", 0);
		int count = ParamUtil.get(renderRequest, "count", 20);
		
		renderRequest.setAttribute("bookings", bookingLocalService.listBookings(start, count));

		super.doView(renderRequest, renderResponse);

	}

	private static Log _log = LogFactoryUtil.getLog(BookingPortlet.class);
	
	@Reference
	private BookingLocalService bookingLocalService;
}