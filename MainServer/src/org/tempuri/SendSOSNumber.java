/**
 * Auto-generated class
 */
package org.tempuri;

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
 *         &lt;element name="IMEI" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sos1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sos2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sos3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "imei",
    "sos1",
    "sos2",
    "sos3"
})
@XmlRootElement(name = "SendSOSNumber")
public class SendSOSNumber {

    @XmlElement(name = "IMEI")
    protected String imei;
    protected String sos1;
    protected String sos2;
    protected String sos3;

    /**
     * Gets the value of the imei property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIMEI() {
        return imei;
    }

    /**
     * Sets the value of the imei property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIMEI(String value) {
        this.imei = value;
    }

    /**
     * Gets the value of the sos1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSos1() {
        return sos1;
    }

    /**
     * Sets the value of the sos1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSos1(String value) {
        this.sos1 = value;
    }

    /**
     * Gets the value of the sos2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSos2() {
        return sos2;
    }

    /**
     * Sets the value of the sos2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSos2(String value) {
        this.sos2 = value;
    }

    /**
     * Gets the value of the sos3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSos3() {
        return sos3;
    }

    /**
     * Sets the value of the sos3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSos3(String value) {
        this.sos3 = value;
    }

}
