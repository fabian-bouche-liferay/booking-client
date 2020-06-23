
package com.liferay.samples.fbo.bookings.model;

import java.math.BigInteger;
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
 *         &lt;element name="startingItem" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="numberOfItems" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
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
    "startingItem",
    "numberOfItems"
})
@XmlRootElement(name = "listBookingsRequest")
public class ListBookingsRequest {

    @XmlElement(required = true)
    protected BigInteger startingItem;
    @XmlElement(required = true)
    protected BigInteger numberOfItems;

    /**
     * Obtient la valeur de la propriété startingItem.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getStartingItem() {
        return startingItem;
    }

    /**
     * Définit la valeur de la propriété startingItem.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setStartingItem(BigInteger value) {
        this.startingItem = value;
    }

    /**
     * Obtient la valeur de la propriété numberOfItems.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNumberOfItems() {
        return numberOfItems;
    }

    /**
     * Définit la valeur de la propriété numberOfItems.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNumberOfItems(BigInteger value) {
        this.numberOfItems = value;
    }

}
