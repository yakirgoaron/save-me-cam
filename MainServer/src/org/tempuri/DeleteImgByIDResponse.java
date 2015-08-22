
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
 *         &lt;element name="DeleteImgByIDResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "deleteImgByIDResult"
})
@XmlRootElement(name = "DeleteImgByIDResponse")
public class DeleteImgByIDResponse {

    @XmlElement(name = "DeleteImgByIDResult")
    protected String deleteImgByIDResult;

    /**
     * Gets the value of the deleteImgByIDResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeleteImgByIDResult() {
        return deleteImgByIDResult;
    }

    /**
     * Sets the value of the deleteImgByIDResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeleteImgByIDResult(String value) {
        this.deleteImgByIDResult = value;
    }

}
