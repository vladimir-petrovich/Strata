//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.05.20 at 01:28:29 PM CDT 
//


package com.opengamma.strata.examples.fpml.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ValuationDate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ValuationDate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="singleValuationDate" type="{http://www.fpml.org/FpML-5/pretrade}SingleValuationDate"/>
 *         &lt;element name="multipleValuationDates" type="{http://www.fpml.org/FpML-5/pretrade}MultipleValuationDates"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValuationDate", propOrder = {
    "singleValuationDate",
    "multipleValuationDates"
})
public class ValuationDate {

    protected SingleValuationDate singleValuationDate;
    protected MultipleValuationDates multipleValuationDates;

    /**
     * Gets the value of the singleValuationDate property.
     * 
     * @return
     *     possible object is
     *     {@link SingleValuationDate }
     *     
     */
    public SingleValuationDate getSingleValuationDate() {
        return singleValuationDate;
    }

    /**
     * Sets the value of the singleValuationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link SingleValuationDate }
     *     
     */
    public void setSingleValuationDate(SingleValuationDate value) {
        this.singleValuationDate = value;
    }

    /**
     * Gets the value of the multipleValuationDates property.
     * 
     * @return
     *     possible object is
     *     {@link MultipleValuationDates }
     *     
     */
    public MultipleValuationDates getMultipleValuationDates() {
        return multipleValuationDates;
    }

    /**
     * Sets the value of the multipleValuationDates property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultipleValuationDates }
     *     
     */
    public void setMultipleValuationDates(MultipleValuationDates value) {
        this.multipleValuationDates = value;
    }

}