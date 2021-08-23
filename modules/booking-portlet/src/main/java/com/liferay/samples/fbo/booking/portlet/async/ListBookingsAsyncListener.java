package com.liferay.samples.fbo.booking.portlet.async;

import java.io.IOException;

import javax.portlet.PortletAsyncEvent;
import javax.portlet.PortletAsyncListener;

public class ListBookingsAsyncListener implements PortletAsyncListener {

	private ListBookingsAsyncHandler handler;
	
	public ListBookingsAsyncHandler getHandler() {
		return handler;
	}

	public void setHandler(ListBookingsAsyncHandler handler) {
		this.handler = handler;
	}

	@Override
	public void onComplete(PortletAsyncEvent evt) throws IOException {
	}

	@Override
	public void onError(PortletAsyncEvent evt) throws IOException {
		handler.cancelRequest();
	}

	@Override
	public void onStartAsync(PortletAsyncEvent evt) throws IOException {
		
	}

	@Override
	public void onTimeout(PortletAsyncEvent evt) throws IOException {
		handler.cancelRequest();
	}

}
