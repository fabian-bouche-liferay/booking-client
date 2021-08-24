package com.liferay.samples.fbo.booking.portlet.async;

import com.liferay.samples.fbo.bookings.model.ListBookingsResponse;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.portlet.PortletAsyncContext;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.xml.ws.AsyncHandler;
import javax.xml.ws.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ListBookingsAsyncHandler implements AsyncHandler<ListBookingsResponse>, Runnable {

	private final static Logger LOG = LoggerFactory.getLogger(ListBookingsAsyncHandler.class);
	
	private PortletAsyncContext _asyncContext;
	private Future<?> _future;
	
	public ListBookingsAsyncHandler(PortletAsyncContext asyncContext) {
		_asyncContext = asyncContext;
	}

	@Override
	public void handleResponse(Response<ListBookingsResponse> res) {

		PortletRequestDispatcher portletRequestDispatcher;
		ResourceRequest resourceRequest = this._asyncContext.getResourceRequest();
		ResourceResponse resourceResponse = this._asyncContext.getResourceResponse();
		
		LOG.debug("ListBookingsAsyncHandler handles response");

		try {
			ListBookingsResponse listBookingsResponse = res.get();
			resourceRequest.setAttribute("bookings", listBookingsResponse.getBookingId());
			LOG.debug("ListBookingsAsyncHandler dispatches to /listAsync.jsp");

			portletRequestDispatcher = resourceRequest.getPortletContext().getRequestDispatcher("/listAsync.jsp");

		} catch (InterruptedException | ExecutionException e) {
			LOG.error("ListBookingsAsyncHandler exception", e);
			LOG.debug("ListBookingsAsyncHandler dispatches to /error.jsp");

			portletRequestDispatcher = resourceRequest.getPortletContext().getRequestDispatcher("/error.jsp");
		}
		
        try {
			portletRequestDispatcher.include(resourceRequest, resourceResponse);
	        resourceResponse.flushBuffer();
		} catch (PortletException | IOException e) {
			LOG.error("ListBookingsAsyncHandler exception", e);
		}
        this._asyncContext.complete();
		
	}

	@Override
	public void run() {
		LOG.debug("ListBookingsAsyncHandler started");
	}

	public void cancelRequest() {
		_future.cancel(true);
	}

	public void setFuture(Future<?> future) {
		_future = future;
	}

}
