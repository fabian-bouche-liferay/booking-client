
package com.liferay.samples.fbo.bookings.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="booking" type="{http://liferay.com/samples/fbo/bookings-web-service}booking"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "booking"
})
@XmlRootElement(name = "checkBookingStatusResponse")
public class CheckBookingStatusResponse {

    @XmlElement(required = true)
    protected Booking booking;

    /**
     * Obtient la valeur de la propriété booking.
     * 
     * @return
     *     possible object is
     *     {@link Booking }
     *     
     */
    public Booking getBooking() {
        return booking;
    }

    /**
     * Définit la valeur de la propriété booking.
     * 
     * @param value
     *     allowed object is
     *     {@link Booking }
     *     
     */
    public void setBooking(Booking value) {
        this.booking = value;
    }

}
