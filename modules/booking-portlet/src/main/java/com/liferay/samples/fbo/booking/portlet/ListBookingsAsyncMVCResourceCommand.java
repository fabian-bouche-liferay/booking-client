package com.liferay.samples.fbo.booking.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.samples.fbo.booking.constants.BookingPortletKeys;
import com.liferay.samples.fbo.booking.portlet.async.ListBookingsAsyncHandler;
import com.liferay.samples.fbo.booking.portlet.async.ListBookingsAsyncListener;
import com.liferay.samples.fbo.booking.service.api.BookingLocalService;

import java.util.concurrent.Future;

import javax.portlet.PortletAsyncContext;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		immediate = true,
		property = {
			"javax.portlet.name=" + BookingPortletKeys.BOOKING,
			"mvc.command.name=" + BookingPortletKeys.LIST_BOOKINGS_ASYNC_RESOURCE_COMMAND
		},
		service = MVCResourceCommand.class
	)
public class ListBookingsAsyncMVCResourceCommand extends BaseMVCResourceCommand {


	@Override
	public void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		
		int start = ParamUtil.get(resourceRequest, "start", 0);
		int count = ParamUtil.get(resourceRequest, "count", 20);
		
		PortletAsyncContext asyncContext = resourceRequest.startPortletAsync(resourceRequest, resourceResponse);
		ListBookingsAsyncListener listener = new ListBookingsAsyncListener();
		asyncContext.setTimeout(10000);
		asyncContext.addListener(listener);
		
		ListBookingsAsyncHandler handler = new ListBookingsAsyncHandler(asyncContext);
		Future<?> future = _bookingLocalService.listBookingsAsync(start, count, handler);
		handler.setFuture(future);

		listener.setHandler(handler);
		
		asyncContext.start(handler);
		
	}
	
	@Reference
	private BookingLocalService _bookingLocalService;

}
