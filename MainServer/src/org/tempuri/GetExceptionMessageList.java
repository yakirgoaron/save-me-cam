
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
 *         &lt;element name="PageNo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="PageCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="TimeZones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "pageNo",
    "pageCount",
    "timeZones"
})
@XmlRootElement(name = "GetExceptionMessageList")
public class GetExceptionMessageList {

    @XmlElement(name = "Serialnumber")
    protected String serialnumber;
    @XmlElement(name = "PageNo")
    protected int pageNo;
    @XmlElement(name = "PageCount")
    protected int pageCount;
    @XmlElement(name = "TimeZones")
    protected String timeZones;

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
     * Gets the value of the pageNo property.
     * 
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * Sets the value of the pageNo property.
     * 
     */
    public void setPageNo(int value) {
        this.pageNo = value;
    }

    /**
     * Gets the value of the pageCount property.
     * 
     */
    public int getPageCount() {
        return pageCount;
    }

    /**
     * Sets the value of the pageCount property.
     * 
     */
    public void setPageCount(int value) {
        this.pageCount = value;
    }

    /**
     * Gets the value of the timeZones property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimeZones() {
        return timeZones;
    }

    /**
     * Sets the value of the timeZones property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimeZones(String value) {
        this.timeZones = value;
    }

}
