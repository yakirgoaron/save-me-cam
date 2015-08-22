
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
 *         &lt;element name="imei" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="OldPwd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NewPwd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "oldPwd",
    "newPwd"
})
@XmlRootElement(name = "UpdateDevicePwd")
public class UpdateDevicePwd {

    protected String imei;
    @XmlElement(name = "OldPwd")
    protected String oldPwd;
    @XmlElement(name = "NewPwd")
    protected String newPwd;

    /**
     * Gets the value of the imei property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImei() {
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
    public void setImei(String value) {
        this.imei = value;
    }

    /**
     * Gets the value of the oldPwd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOldPwd() {
        return oldPwd;
    }

    /**
     * Sets the value of the oldPwd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOldPwd(String value) {
        this.oldPwd = value;
    }

    /**
     * Gets the value of the newPwd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewPwd() {
        return newPwd;
    }

    /**
     * Sets the value of the newPwd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewPwd(String value) {
        this.newPwd = value;
    }

}
