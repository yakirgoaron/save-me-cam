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
 *         &lt;element name="Serialnumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CmdType" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "serialnumber",
    "cmdType"
})
@XmlRootElement(name = "SendCommandToDeviceByCmdType")
public class SendCommandToDeviceByCmdType {

    @XmlElement(name = "Serialnumber")
    protected String serialnumber;
    @XmlElement(name = "CmdType")
    protected int cmdType;

    /**
     * Gets the value of the serialnumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSerialnumber() {
        return serialnumber;
    }

    /**
     * Sets the value of the serialnumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSerialnumber(String value) {
        this.serialnumber = value;
    }

    /**
     * Gets the value of the cmdType property.
     * 
     */
    public int getCmdType() {
        return cmdType;
    }

    /**
     * Sets the value of the cmdType property.
     * 
     */
    public void setCmdType(int value) {
        this.cmdType = value;
    }

}
