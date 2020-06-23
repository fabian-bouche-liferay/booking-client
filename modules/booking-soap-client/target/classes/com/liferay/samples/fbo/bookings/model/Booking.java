
package com.liferay.samples.fbo.bookings.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour booking complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="booking"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="bookingInformation" type="{http://liferay.com/samples/fbo/bookings-web-service}bookingInformation"/&gt;
 *         &lt;element name="bookingId" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="bookingStatus" type="{http://liferay.com/samples/fbo/bookings-web-service}bookingStatusEnum"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "booking", propOrder = {
    "bookingInformation",
    "bookingId",
    "bookingStatus"
})
public class Booking {

    @XmlElement(required = true)
    protected BookingInformation bookingInformation;
    @XmlElement(required = true)
    protected String bookingId;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected BookingStatusEnum bookingStatus;

    /**
     * Obtient la valeur de la propriété bookingInformation.
     * 
     * @return
     *     possible object is
     *     {@link BookingInformation }
     *     
     */
    public BookingInformation getBookingInformation() {
        return bookingInformation;
    }

    /**
     * Définit la valeur de la propriété bookingInformation.
     * 
     * @param value
     *     allowed object is
     *     {@link BookingInformation }
     *     
     */
    public void setBookingInformation(BookingInformation value) {
        this.bookingInformation = value;
    }

    /**
     * Obtient la valeur de la propriété bookingId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBookingId() {
        return bookingId;
    }

    /**
     * Définit la valeur de la propriété bookingId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBookingId(String value) {
        this.bookingId = value;
    }

    /**
     * Obtient la valeur de la propriété bookingStatus.
     * 
     * @return
     *     possible object is
     *     {@link BookingStatusEnum }
     *     
     */
    public BookingStatusEnum getBookingStatus() {
        return bookingStatus;
    }

    /**
     * Définit la valeur de la propriété bookingStatus.
     * 
     * @param value
     *     allowed object is
     *     {@link BookingStatusEnum }
     *     
     */
    public void setBookingStatus(BookingStatusEnum value) {
        this.bookingStatus = value;
    }

}
