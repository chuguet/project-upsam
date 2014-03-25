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
 *       &lt;attribute name="scaleFactor" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short">
 *             &lt;enumeration value="10000"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="nSegs" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *             &lt;enumeration value="-1"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="nPoints" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *             &lt;enumeration value="1"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="nItems" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}byte">
 *             &lt;enumeration value="-1"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="label" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="sLDBLSTANCE"/>
 *             &lt;enumeration value="sLSTANCE"/>
 *             &lt;enumeration value="sLSWING"/>
 *             &lt;enumeration value="sRDBLSTANCE"/>
 *             &lt;enumeration value="sRSTANCE"/>
 *             &lt;enumeration value="sRSWING"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="description" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="L Double Support"/>
 *             &lt;enumeration value="L Stance Phase"/>
 *             &lt;enumeration value="L Swing Phase"/>
 *             &lt;enumeration value="R Double Support"/>
 *             &lt;enumeration value="R Stance Phase"/>
 *             &lt;enumeration value="R Swing Phase"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="data" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short">
 *             &lt;enumeration value="1739"/>
 *             &lt;enumeration value="203"/>
 *             &lt;enumeration value="3913"/>
 *             &lt;enumeration value="4701"/>
 *             &lt;enumeration value="6087"/>
 *             &lt;enumeration value="9855"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="coords" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             &lt;enumeration value="V"/>
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
@XmlType(name = "")
@XmlRootElement(name = "scalar")
public class Scalar {

    @XmlAttribute(name = "scaleFactor", required = true)
    protected short scaleFactor;
    @XmlAttribute(name = "nSegs", required = true)
    protected byte nSegs;
    @XmlAttribute(name = "nPoints", required = true)
    protected byte nPoints;
    @XmlAttribute(name = "nItems", required = true)
    protected byte nItems;
    @XmlAttribute(name = "label", required = true)
    protected String label;
    @XmlAttribute(name = "description", required = true)
    protected String description;
    @XmlAttribute(name = "data", required = true)
    protected short data;
    @XmlAttribute(name = "coords", required = true)
    protected String coords;

    /**
     * Gets the value of the scaleFactor property.
     * 
     */
    public short getScaleFactor() {
        return scaleFactor;
    }

    /**
     * Sets the value of the scaleFactor property.
     * 
     */
    public void setScaleFactor(short value) {
        this.scaleFactor = value;
    }

    /**
     * Gets the value of the nSegs property.
     * 
     */
    public byte getNSegs() {
        return nSegs;
    }

    /**
     * Sets the value of the nSegs property.
     * 
     */
    public void setNSegs(byte value) {
        this.nSegs = value;
    }

    /**
     * Gets the value of the nPoints property.
     * 
     */
    public byte getNPoints() {
        return nPoints;
    }

    /**
     * Sets the value of the nPoints property.
     * 
     */
    public void setNPoints(byte value) {
        this.nPoints = value;
    }

    /**
     * Gets the value of the nItems property.
     * 
     */
    public byte getNItems() {
        return nItems;
    }

    /**
     * Sets the value of the nItems property.
     * 
     */
    public void setNItems(byte value) {
        this.nItems = value;
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

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the data property.
     * 
     */
    public short getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     */
    public void setData(short value) {
        this.data = value;
    }

    /**
     * Gets the value of the coords property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoords() {
        return coords;
    }

    /**
     * Sets the value of the coords property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoords(String value) {
        this.coords = value;
    }

}
