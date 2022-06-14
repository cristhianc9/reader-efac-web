//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2022.04.23 at 10:36:17 PM COT
//


package com.generated.sri.xsd.factura;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.generated.sri.xsd.signature.SignatureType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="infoTributaria" type="{}infoTributaria"/&gt;
 *         &lt;element name="infoCompRetencion"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="fechaEmision" type="{}fechaEmision"/&gt;
 *                   &lt;element name="dirEstablecimiento" type="{}dirEstablecimiento" minOccurs="0"/&gt;
 *                   &lt;element name="contribuyenteEspecial" type="{}contribuyenteEspecial" minOccurs="0"/&gt;
 *                   &lt;element name="obligadoContabilidad" type="{}obligadoContabilidad" minOccurs="0"/&gt;
 *                   &lt;element name="tipoIdentificacionSujetoRetenido" type="{}tipoIdentificacionSujetoRetenido"/&gt;
 *                   &lt;element name="razonSocialSujetoRetenido" type="{}razonSocialSujetoRetenido"/&gt;
 *                   &lt;element name="identificacionSujetoRetenido" type="{}identificacionSujetoRetenido"/&gt;
 *                   &lt;element name="periodoFiscal" type="{}periodoFiscal"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="impuestos"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="impuesto" type="{}impuesto" maxOccurs="unbounded"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="maquinaFiscal" type="{}maquinaFiscal" minOccurs="0"/&gt;
 *         &lt;element name="infoAdicional" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="campoAdicional" maxOccurs="15"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;simpleContent&gt;
 *                         &lt;extension base="&lt;&gt;campoAdicional"&gt;
 *                           &lt;attribute name="nombre" use="required" type="{}nombre" /&gt;
 *                         &lt;/extension&gt;
 *                       &lt;/simpleContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}Signature" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="id"&gt;
 *         &lt;simpleType&gt;
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *             &lt;enumeration value="comprobante"/&gt;
 *           &lt;/restriction&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}NMTOKEN" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "infoTributaria",
    "infoCompRetencion",
    "impuestos",
    "maquinaFiscal",
    "infoAdicional",
    "signature"
})
@XmlRootElement(name = "comprobanteRetencion", namespace = "")
public class ComprobanteRetencion {

    @XmlElement(namespace = "", required = true)
    protected InfoTributaria infoTributaria;
    @XmlElement(namespace = "", required = true)
    protected ComprobanteRetencion.InfoCompRetencion infoCompRetencion;
    @XmlElement(namespace = "", required = true)
    protected ComprobanteRetencion.Impuestos impuestos;
    @XmlElement(namespace = "")
    protected MaquinaFiscal maquinaFiscal;
    @XmlElement(namespace = "")
    protected ComprobanteRetencion.InfoAdicional infoAdicional;
    @XmlElement(name = "Signature")
    protected SignatureType signature;
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "version", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NMTOKEN")
    protected String version;

    /**
     * Gets the value of the infoTributaria property.
     *
     * @return
     *     possible object is
     *     {@link InfoTributaria }
     *
     */
    public InfoTributaria getInfoTributaria() {
        return infoTributaria;
    }

    /**
     * Sets the value of the infoTributaria property.
     *
     * @param value
     *     allowed object is
     *     {@link InfoTributaria }
     *
     */
    public void setInfoTributaria(InfoTributaria value) {
        this.infoTributaria = value;
    }

    /**
     * Gets the value of the infoCompRetencion property.
     *
     * @return
     *     possible object is
     *     {@link ComprobanteRetencion.InfoCompRetencion }
     *
     */
    public ComprobanteRetencion.InfoCompRetencion getInfoCompRetencion() {
        return infoCompRetencion;
    }

    /**
     * Sets the value of the infoCompRetencion property.
     *
     * @param value
     *     allowed object is
     *     {@link ComprobanteRetencion.InfoCompRetencion }
     *
     */
    public void setInfoCompRetencion(ComprobanteRetencion.InfoCompRetencion value) {
        this.infoCompRetencion = value;
    }

    /**
     * Gets the value of the impuestos property.
     *
     * @return
     *     possible object is
     *     {@link ComprobanteRetencion.Impuestos }
     *
     */
    public ComprobanteRetencion.Impuestos getImpuestos() {
        return impuestos;
    }

    /**
     * Sets the value of the impuestos property.
     *
     * @param value
     *     allowed object is
     *     {@link ComprobanteRetencion.Impuestos }
     *
     */
    public void setImpuestos(ComprobanteRetencion.Impuestos value) {
        this.impuestos = value;
    }

    /**
     * Gets the value of the maquinaFiscal property.
     *
     * @return
     *     possible object is
     *     {@link MaquinaFiscal }
     *
     */
    public MaquinaFiscal getMaquinaFiscal() {
        return maquinaFiscal;
    }

    /**
     * Sets the value of the maquinaFiscal property.
     *
     * @param value
     *     allowed object is
     *     {@link MaquinaFiscal }
     *
     */
    public void setMaquinaFiscal(MaquinaFiscal value) {
        this.maquinaFiscal = value;
    }

    /**
     * Gets the value of the infoAdicional property.
     *
     * @return
     *     possible object is
     *     {@link ComprobanteRetencion.InfoAdicional }
     *
     */
    public ComprobanteRetencion.InfoAdicional getInfoAdicional() {
        return infoAdicional;
    }

    /**
     * Sets the value of the infoAdicional property.
     *
     * @param value
     *     allowed object is
     *     {@link ComprobanteRetencion.InfoAdicional }
     *
     */
    public void setInfoAdicional(ComprobanteRetencion.InfoAdicional value) {
        this.infoAdicional = value;
    }

    /**
     *  Conjunto de datos asociados a la factura que garantizarán la autoría y la integridad del mensaje. Se define como opcional para facilitar la verificación y el tránsito del fichero. No obstante, debe cumplimentarse este bloque de firma electrónica para que se considere una factura electrónica válida legalmente frente a terceros.
     *
     * @return
     *     possible object is
     *     {@link SignatureType }
     *
     */
    public SignatureType getSignature() {
        return signature;
    }

    /**
     * Sets the value of the signature property.
     *
     * @param value
     *     allowed object is
     *     {@link SignatureType }
     *
     */
    public void setSignature(SignatureType value) {
        this.signature = value;
    }

    /**
     * Gets the value of the id property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the version property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setVersion(String value) {
        this.version = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="impuesto" type="{}impuesto" maxOccurs="unbounded"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "impuesto"
    })
    public static class Impuestos {

        @XmlElement(namespace = "", required = true)
        protected List<Impuesto> impuesto;

        /**
         * Gets the value of the impuesto property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a <CODE>set</CODE> method for the impuesto property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getImpuesto().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Impuesto }
         *
         *
         */
        public List<Impuesto> getImpuesto() {
            if (impuesto == null) {
                impuesto = new ArrayList<>();
            }
            return this.impuesto;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="campoAdicional" maxOccurs="15"&gt;
     *           &lt;complexType&gt;
     *             &lt;simpleContent&gt;
     *               &lt;extension base="&lt;&gt;campoAdicional"&gt;
     *                 &lt;attribute name="nombre" use="required" type="{}nombre" /&gt;
     *               &lt;/extension&gt;
     *             &lt;/simpleContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "campoAdicional"
    })
    public static class InfoAdicional {

        @XmlElement(namespace = "", required = true)
        protected List<ComprobanteRetencion.InfoAdicional.CampoAdicional> campoAdicional;

        /**
         * Gets the value of the campoAdicional property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a <CODE>set</CODE> method for the campoAdicional property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCampoAdicional().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ComprobanteRetencion.InfoAdicional.CampoAdicional }
         *
         *
         */
        public List<ComprobanteRetencion.InfoAdicional.CampoAdicional> getCampoAdicional() {
            if (campoAdicional == null) {
                campoAdicional = new ArrayList<>();
            }
            return this.campoAdicional;
        }


        /**
         * <p>Java class for anonymous complex type.
         *
         * <p>The following schema fragment specifies the expected content contained within this class.
         *
         * <pre>
         * &lt;complexType&gt;
         *   &lt;simpleContent&gt;
         *     &lt;extension base="&lt;&gt;campoAdicional"&gt;
         *       &lt;attribute name="nombre" use="required" type="{}nombre" /&gt;
         *     &lt;/extension&gt;
         *   &lt;/simpleContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "value"
        })
        public static class CampoAdicional {

            @XmlValue
            protected String value;
            @XmlAttribute(name = "nombre", required = true)
            protected String nombre;

            /**
             * Gets the value of the value property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setValue(String value) {
                this.value = value;
            }

            /**
             * Gets the value of the nombre property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getNombre() {
                return nombre;
            }

            /**
             * Sets the value of the nombre property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setNombre(String value) {
                this.nombre = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="fechaEmision" type="{}fechaEmision"/&gt;
     *         &lt;element name="dirEstablecimiento" type="{}dirEstablecimiento" minOccurs="0"/&gt;
     *         &lt;element name="contribuyenteEspecial" type="{}contribuyenteEspecial" minOccurs="0"/&gt;
     *         &lt;element name="obligadoContabilidad" type="{}obligadoContabilidad" minOccurs="0"/&gt;
     *         &lt;element name="tipoIdentificacionSujetoRetenido" type="{}tipoIdentificacionSujetoRetenido"/&gt;
     *         &lt;element name="razonSocialSujetoRetenido" type="{}razonSocialSujetoRetenido"/&gt;
     *         &lt;element name="identificacionSujetoRetenido" type="{}identificacionSujetoRetenido"/&gt;
     *         &lt;element name="periodoFiscal" type="{}periodoFiscal"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "fechaEmision",
        "dirEstablecimiento",
        "contribuyenteEspecial",
        "obligadoContabilidad",
        "tipoIdentificacionSujetoRetenido",
        "razonSocialSujetoRetenido",
        "identificacionSujetoRetenido",
        "periodoFiscal"
    })
    public static class InfoCompRetencion {

        @XmlElement(namespace = "", required = true)
        protected String fechaEmision;
        @XmlElement(namespace = "")
        protected String dirEstablecimiento;
        @XmlElement(namespace = "")
        protected String contribuyenteEspecial;
        @XmlElement(namespace = "")
        @XmlSchemaType(name = "string")
        protected ObligadoContabilidad obligadoContabilidad;
        @XmlElement(namespace = "", required = true)
        protected String tipoIdentificacionSujetoRetenido;
        @XmlElement(namespace = "", required = true)
        protected String razonSocialSujetoRetenido;
        @XmlElement(namespace = "", required = true)
        protected String identificacionSujetoRetenido;
        @XmlElement(namespace = "", required = true)
        protected String periodoFiscal;

        /**
         * Gets the value of the fechaEmision property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getFechaEmision() {
            return fechaEmision;
        }

        /**
         * Sets the value of the fechaEmision property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setFechaEmision(String value) {
            this.fechaEmision = value;
        }

        /**
         * Gets the value of the dirEstablecimiento property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getDirEstablecimiento() {
            return dirEstablecimiento;
        }

        /**
         * Sets the value of the dirEstablecimiento property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setDirEstablecimiento(String value) {
            this.dirEstablecimiento = value;
        }

        /**
         * Gets the value of the contribuyenteEspecial property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getContribuyenteEspecial() {
            return contribuyenteEspecial;
        }

        /**
         * Sets the value of the contribuyenteEspecial property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setContribuyenteEspecial(String value) {
            this.contribuyenteEspecial = value;
        }

        /**
         * Gets the value of the obligadoContabilidad property.
         *
         * @return
         *     possible object is
         *     {@link ObligadoContabilidad }
         *
         */
        public ObligadoContabilidad getObligadoContabilidad() {
            return obligadoContabilidad;
        }

        /**
         * Sets the value of the obligadoContabilidad property.
         *
         * @param value
         *     allowed object is
         *     {@link ObligadoContabilidad }
         *
         */
        public void setObligadoContabilidad(ObligadoContabilidad value) {
            this.obligadoContabilidad = value;
        }

        /**
         * Gets the value of the tipoIdentificacionSujetoRetenido property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getTipoIdentificacionSujetoRetenido() {
            return tipoIdentificacionSujetoRetenido;
        }

        /**
         * Sets the value of the tipoIdentificacionSujetoRetenido property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setTipoIdentificacionSujetoRetenido(String value) {
            this.tipoIdentificacionSujetoRetenido = value;
        }

        /**
         * Gets the value of the razonSocialSujetoRetenido property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getRazonSocialSujetoRetenido() {
            return razonSocialSujetoRetenido;
        }

        /**
         * Sets the value of the razonSocialSujetoRetenido property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setRazonSocialSujetoRetenido(String value) {
            this.razonSocialSujetoRetenido = value;
        }

        /**
         * Gets the value of the identificacionSujetoRetenido property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getIdentificacionSujetoRetenido() {
            return identificacionSujetoRetenido;
        }

        /**
         * Sets the value of the identificacionSujetoRetenido property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setIdentificacionSujetoRetenido(String value) {
            this.identificacionSujetoRetenido = value;
        }

        /**
         * Gets the value of the periodoFiscal property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getPeriodoFiscal() {
            return periodoFiscal;
        }

        /**
         * Sets the value of the periodoFiscal property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setPeriodoFiscal(String value) {
            this.periodoFiscal = value;
        }

    }

}