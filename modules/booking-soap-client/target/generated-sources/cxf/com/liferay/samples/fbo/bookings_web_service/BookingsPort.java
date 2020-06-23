package com.liferay.samples.fbo.bookings_web_service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.3.0
 * 2020-06-23T22:53:51.055+02:00
 * Generated source version: 3.3.0
 *
 */
@WebService(targetNamespace = "http://liferay.com/samples/fbo/bookings-web-service", name = "BookingsPort")
@XmlSeeAlso({com.liferay.samples.fbo.bookings.model.ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface BookingsPort {

    @WebMethod
    @WebResult(name = "initBookingResponse", targetNamespace = "http://liferay.com/samples/fbo/bookings-web-service", partName = "initBookingResponse")
    public com.liferay.samples.fbo.bookings.model.InitBookingResponse initBooking(
        @WebParam(partName = "initBookingRequest", name = "initBookingRequest", targetNamespace = "http://liferay.com/samples/fbo/bookings-web-service")
        com.liferay.samples.fbo.bookings.model.InitBookingRequest initBookingRequest
    );

    @WebMethod
    @WebResult(name = "checkBookingStatusResponse", targetNamespace = "http://liferay.com/samples/fbo/bookings-web-service", partName = "checkBookingStatusResponse")
    public com.liferay.samples.fbo.bookings.model.CheckBookingStatusResponse checkBookingStatus(
        @WebParam(partName = "checkBookingStatusRequest", name = "checkBookingStatusRequest", targetNamespace = "http://liferay.com/samples/fbo/bookings-web-service")
        com.liferay.samples.fbo.bookings.model.CheckBookingStatusRequest checkBookingStatusRequest
    );

    @WebMethod
    @WebResult(name = "updateBookingStatusResponse", targetNamespace = "http://liferay.com/samples/fbo/bookings-web-service", partName = "updateBookingStatusResponse")
    public com.liferay.samples.fbo.bookings.model.UpdateBookingStatusResponse updateBookingStatus(
        @WebParam(partName = "updateBookingStatusRequest", name = "updateBookingStatusRequest", targetNamespace = "http://liferay.com/samples/fbo/bookings-web-service")
        com.liferay.samples.fbo.bookings.model.UpdateBookingStatusRequest updateBookingStatusRequest
    );

    @WebMethod
    @WebResult(name = "listBookingsResponse", targetNamespace = "http://liferay.com/samples/fbo/bookings-web-service", partName = "listBookingsResponse")
    public com.liferay.samples.fbo.bookings.model.ListBookingsResponse listBookings(
        @WebParam(partName = "listBookingsRequest", name = "listBookingsRequest", targetNamespace = "http://liferay.com/samples/fbo/bookings-web-service")
        com.liferay.samples.fbo.bookings.model.ListBookingsRequest listBookingsRequest
    );
}
