//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.04.26 at 03:41:56 AM MSK 
//


package by.it.prigozhanov.jd02_10.TaskB;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SportCars" type="{http://TaskB.jd02_10.prigozhanov.it.by}SportCars"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "sportCars"
})
@XmlRootElement(name = "CarList")
public class CarList {

    @XmlElement(name = "SportCars", required = true)
    protected SportCars sportCars;

    /**
     * Gets the value of the sportCars property.
     * 
     * @return
     *     possible object is
     *     {@link SportCars }
     *     
     */
    public SportCars getSportCars() {
        return sportCars;
    }

    /**
     * Sets the value of the sportCars property.
     * 
     * @param value
     *     allowed object is
     *     {@link SportCars }
     *     
     */
    public void setSportCars(SportCars value) {
        this.sportCars = value;
    }

    @Override
    public String toString() {
        return "CarList{" +
                "sportCars=" + sportCars +
                '}';
    }
}
