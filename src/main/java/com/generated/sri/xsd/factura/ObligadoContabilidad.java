//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.04.23 at 10:39:31 PM COT 
//


package com.generated.sri.xsd.factura;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for obligadoContabilidad.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="obligadoContabilidad"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="SI"/&gt;
 *     &lt;enumeration value="NO"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "obligadoContabilidad", namespace = "")
@XmlEnum
public enum ObligadoContabilidad {

    SI,
    NO;

    public String value() {
        return name();
    }

    public static ObligadoContabilidad fromValue(String v) {
        return valueOf(v);
    }

}
