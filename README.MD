# Bookings client

This is a sample Liferay project to illustrate how to consume a Bookings SOAP Service

The project consists of 5 modules:
* cxf-provider-fragment: overrides com.liferay.portal.remote.soap.extender.impl so as to export package org.apache.cxf.jaxws.spi
* booking-soap-client:
  - Generates the SOAP client and model from the WSDL using cxf-codegen-plugin
  - Implements a BookingsPortFactory @Component that makes BookingsPort instances available to consumers
  - The instantiation of the BookingsPortService needs to happen inside of the @Activate method of BookingsPortFactory because this is where the Jaxws Provider class is visible from the classloader
  - The bundle exposes the packages of the generated SOAP client and model (the jaxb bindings ensure that they belong to different packages)
* booking-service-api: An internal api to decouple the portlet from the soap client
* booking-service-impl: Its implementation that also implements object caching using the Liferay Caching framework with an example of cache invalidation when a Cached item is updated
* booking-portlet: A sample portlet that uses the registered booking-service-api

This is a rough start that does not include the CXF configuration.

Todo:
* Management of request timeouts
* Logging
* Proper exception management

Bear in mind that when the portal dispatches PortletRequests from an HttpServletRequest, all happens in a single Thread.
PortletRequests are not handled in parallel.
As a consequence, a SOAP request that takes time to execute is blocking.
SOAP requests cannot be sent in parallel by several portlets present on the same page.

Refrain from making time consuming requests to SOAP services in RenderRequests.
Caching may be very important from a performance point of view.
