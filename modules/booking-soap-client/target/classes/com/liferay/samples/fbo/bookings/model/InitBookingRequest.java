
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
 *         &lt;element name="bookingInformation" type="{http://liferay.com/samples/fbo/bookings-web-service}bookingInformation"/&gt;
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
    "bookingInformation"
})
@XmlRootElement(name = "initBookingRequest")
public class InitBookingRequest {

    @XmlElement(required = true)
    protected BookingInformation bookingInformation;

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

}
