//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.24 at 10:03:45 PM CET 
//


package com.upsam.hospital.model.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *         &lt;element ref="{}corner1"/>
 *         &lt;element ref="{}corner2"/>
 *         &lt;element ref="{}corner3"/>
 *         &lt;element ref="{}corner4"/>
 *       &lt;/sequence>
 *       &lt;attribute name="label" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="Platform1"/>
 *             &lt;enumeration value="Platform2"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "corner1",
    "corner2",
    "corner3",
    "corner4"
})
@XmlRootElement(name = "platform")
public class Platform {

    @XmlElement(required = true)
    protected Corner1 corner1;
    @XmlElement(required = true)
    protected Corner2 corner2;
    @XmlElement(required = true)
    protected Corner3 corner3;
    @XmlElement(required = true)
    protected Corner4 corner4;
    @XmlAttribute(name = "label", required = true)
    protected String label;

    /**
     * Gets the value of the corner1 property.
     * 
     * @return
     *     possible object is
     *     {@link Corner1 }
     *     
     */
    public Corner1 getCorner1() {
        return corner1;
    }

    /**
     * Sets the value of the corner1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Corner1 }
     *     
     */
    public void setCorner1(Corner1 value) {
        this.corner1 = value;
    }

    /**
     * Gets the value of the corner2 property.
     * 
     * @return
     *     possible object is
     *     {@link Corner2 }
     *     
     */
    public Corner2 getCorner2() {
        return corner2;
    }

    /**
     * Sets the value of the corner2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Corner2 }
     *     
     */
    public void setCorner2(Corner2 value) {
        this.corner2 = value;
    }

    /**
     * Gets the value of the corner3 property.
     * 
     * @return
     *     possible object is
     *     {@link Corner3 }
     *     
     */
    public Corner3 getCorner3() {
        return corner3;
    }

    /**
     * Sets the value of the corner3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Corner3 }
     *     
     */
    public void setCorner3(Corner3 value) {
        this.corner3 = value;
    }

    /**
     * Gets the value of the corner4 property.
     * 
     * @return
     *     possible object is
     *     {@link Corner4 }
     *     
     */
    public Corner4 getCorner4() {
        return corner4;
    }

    /**
     * Sets the value of the corner4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Corner4 }
     *     
     */
    public void setCorner4(Corner4 value) {
        this.corner4 = value;
    }

    /**
     * Gets the value of the label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabel(String value) {
        this.label = value;
    }

}
