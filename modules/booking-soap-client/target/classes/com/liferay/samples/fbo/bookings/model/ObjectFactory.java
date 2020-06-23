
package com.liferay.samples.fbo.bookings.model;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.liferay.samples.fbo.bookings.model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.liferay.samples.fbo.bookings.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InitBookingRequest }
     * 
     */
    public InitBookingRequest createInitBookingRequest() {
        return new InitBookingRequest();
    }

    /**
     * Create an instance of {@link BookingInformation }
     * 
     */
    public BookingInformation createBookingInformation() {
        return new BookingInformation();
    }

    /**
     * Create an instance of {@link InitBookingResponse }
     * 
     */
    public InitBookingResponse createInitBookingResponse() {
        return new InitBookingResponse();
    }

    /**
     * Create an instance of {@link Booking }
     * 
     */
    public Booking createBooking() {
        return new Booking();
    }

    /**
     * Create an instance of {@link ListBookingsRequest }
     * 
     */
    public ListBookingsRequest createListBookingsRequest() {
        return new ListBookingsRequest();
    }

    /**
     * Create an instance of {@link ListBookingsResponse }
     * 
     */
    public ListBookingsResponse createListBookingsResponse() {
        return new ListBookingsResponse();
    }

    /**
     * Create an instance of {@link CheckBookingStatusRequest }
     * 
     */
    public CheckBookingStatusRequest createCheckBookingStatusRequest() {
        return new CheckBookingStatusRequest();
    }

    /**
     * Create an instance of {@link CheckBookingStatusResponse }
     * 
     */
    public CheckBookingStatusResponse createCheckBookingStatusResponse() {
        return new CheckBookingStatusResponse();
    }

    /**
     * Create an instance of {@link UpdateBookingStatusRequest }
     * 
     */
    public UpdateBookingStatusRequest createUpdateBookingStatusRequest() {
        return new UpdateBookingStatusRequest();
    }

    /**
     * Create an instance of {@link UpdateBookingStatusResponse }
     * 
     */
    public UpdateBookingStatusResponse createUpdateBookingStatusResponse() {
        return new UpdateBookingStatusResponse();
    }

}
