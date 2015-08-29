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
 *         &lt;element name="CmdType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CmdValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "cmdType",
    "cmdValue"
})
@XmlRootElement(name = "SendCommandSummerByLD")
public class SendCommandSummerByLD {

    @XmlElement(name = "IMEI")
    protected String imei;
    @XmlElement(name = "CmdType")
    protected String cmdType;
    @XmlElement(name = "CmdValue")
    protected String cmdValue;

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
     * Gets the value of the cmdType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCmdType() {
        return cmdType;
    }

    /**
     * Sets the value of the cmdType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCmdType(String value) {
        this.cmdType = value;
    }

    /**
     * Gets the value of the cmdValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCmdValue() {
        return cmdValue;
    }

    /**
     * Sets the value of the cmdValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCmdValue(String value) {
        this.cmdValue = value;
    }

}
