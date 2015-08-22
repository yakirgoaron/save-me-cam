
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
 *         &lt;element name="GetPhotoListByDeviceIDForThreeDaysResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "getPhotoListByDeviceIDForThreeDaysResult"
})
@XmlRootElement(name = "GetPhotoListByDeviceIDForThreeDaysResponse")
public class GetPhotoListByDeviceIDForThreeDaysResponse {

    @XmlElement(name = "GetPhotoListByDeviceIDForThreeDaysResult")
    protected String getPhotoListByDeviceIDForThreeDaysResult;

    /**
     * Gets the value of the getPhotoListByDeviceIDForThreeDaysResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetPhotoListByDeviceIDForThreeDaysResult() {
        return getPhotoListByDeviceIDForThreeDaysResult;
    }

    /**
     * Sets the value of the getPhotoListByDeviceIDForThreeDaysResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetPhotoListByDeviceIDForThreeDaysResult(String value) {
        this.getPhotoListByDeviceIDForThreeDaysResult = value;
    }

}
