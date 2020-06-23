
package com.liferay.samples.fbo.bookings.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour bookingStatusEnum.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="bookingStatusEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="PENDING"/&gt;
 *     &lt;enumeration value="VALIDATED"/&gt;
 *     &lt;enumeration value="CANCELLED"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "bookingStatusEnum")
@XmlEnum
public enum BookingStatusEnum {

    PENDING,
    VALIDATED,
    CANCELLED;

    public String value() {
        return name();
    }

    public static BookingStatusEnum fromValue(String v) {
        return valueOf(v);
    }

}
