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
 *         &lt;element name="SN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CmdType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "sn",
    "cmdType"
})
@XmlRootElement(name = "GetCommandSummerByLD")
public class GetCommandSummerByLD {

    @XmlElement(name = "SN")
    protected String sn;
    @XmlElement(name = "CmdType")
    protected String cmdType;

    /**
     * Gets the value of the sn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSN() {
        return sn;
    }

    /**
     * Sets the value of the sn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSN(String value) {
        this.sn = value;
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

}
