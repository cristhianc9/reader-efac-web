//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0
// See https://eclipse-ee4j.github.io/jaxb-ri
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2022.04.23 at 10:39:31 PM COT
//


package com.generated.sri.xsd.factura;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for reembolsos complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="reembolsos"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="reembolsoDetalle" maxOccurs="unbounded"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="tipoIdentificacionProveedorReembolso" type="{}tipoIdentificacionProveedorReembolso"/&gt;
 *                   &lt;element name="identificacionProveedorReembolso" type="{}identificacionProveedorReembolso"/&gt;
 *                   &lt;element name="codPaisPagoProveedorReembolso" type="{}codPaisPagoProveedorReembolso" minOccurs="0"/&gt;
 *                   &lt;element name="tipoProveedorReembolso" type="{}tipoProveedorReembolso"/&gt;
 *                   &lt;element name="codDocReembolso" type="{}codDocReembolso"/&gt;
 *                   &lt;element name="estabDocReembolso" type="{}estabDocReembolso"/&gt;
 *                   &lt;element name="ptoEmiDocReembolso" type="{}ptoEmiDocReembolso"/&gt;
 *                   &lt;element name="secuencialDocReembolso" type="{}secuencialDocReembolso"/&gt;
 *                   &lt;element name="fechaEmisionDocReembolso" type="{}fechaEmisionDocReembolso"/&gt;
 *                   &lt;element name="numeroautorizacionDocReemb" type="{}numeroautorizacionDocReemb"/&gt;
 *                   &lt;element name="detalleImpuestos" type="{}detalleImpuestos"/&gt;
 *                   &lt;element name="compensacionesReembolso" type="{}compensacionesReembolso" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
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
@XmlType(name = "reembolsos", namespace = "", propOrder = {
    "reembolsoDetalle"
})
public class Reembolsos {

    @XmlElement(required = true)
    protected List<Reembolsos.ReembolsoDetalle> reembolsoDetalle;

    /**
     * Gets the value of the reembolsoDetalle property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a <CODE>set</CODE> method for the reembolsoDetalle property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReembolsoDetalle().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Reembolsos.ReembolsoDetalle }
     *
     *
     */
    public List<Reembolsos.ReembolsoDetalle> getReembolsoDetalle() {
        if (reembolsoDetalle == null) {
            reembolsoDetalle = new ArrayList<>();
        }
        return this.reembolsoDetalle;
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
     *         &lt;element name="tipoIdentificacionProveedorReembolso" type="{}tipoIdentificacionProveedorReembolso"/&gt;
     *         &lt;element name="identificacionProveedorReembolso" type="{}identificacionProveedorReembolso"/&gt;
     *         &lt;element name="codPaisPagoProveedorReembolso" type="{}codPaisPagoProveedorReembolso" minOccurs="0"/&gt;
     *         &lt;element name="tipoProveedorReembolso" type="{}tipoProveedorReembolso"/&gt;
     *         &lt;element name="codDocReembolso" type="{}codDocReembolso"/&gt;
     *         &lt;element name="estabDocReembolso" type="{}estabDocReembolso"/&gt;
     *         &lt;element name="ptoEmiDocReembolso" type="{}ptoEmiDocReembolso"/&gt;
     *         &lt;element name="secuencialDocReembolso" type="{}secuencialDocReembolso"/&gt;
     *         &lt;element name="fechaEmisionDocReembolso" type="{}fechaEmisionDocReembolso"/&gt;
     *         &lt;element name="numeroautorizacionDocReemb" type="{}numeroautorizacionDocReemb"/&gt;
     *         &lt;element name="detalleImpuestos" type="{}detalleImpuestos"/&gt;
     *         &lt;element name="compensacionesReembolso" type="{}compensacionesReembolso" minOccurs="0"/&gt;
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
        "tipoIdentificacionProveedorReembolso",
        "identificacionProveedorReembolso",
        "codPaisPagoProveedorReembolso",
        "tipoProveedorReembolso",
        "codDocReembolso",
        "estabDocReembolso",
        "ptoEmiDocReembolso",
        "secuencialDocReembolso",
        "fechaEmisionDocReembolso",
        "numeroautorizacionDocReemb",
        "detalleImpuestos",
        "compensacionesReembolso"
    })
    public static class ReembolsoDetalle {

        @XmlElement(required = true)
        protected String tipoIdentificacionProveedorReembolso;
        @XmlElement(required = true)
        protected String identificacionProveedorReembolso;
        protected String codPaisPagoProveedorReembolso;
        @XmlElement(required = true)
        protected String tipoProveedorReembolso;
        @XmlElement(required = true)
        protected String codDocReembolso;
        @XmlElement(required = true)
        protected String estabDocReembolso;
        @XmlElement(required = true)
        protected String ptoEmiDocReembolso;
        @XmlElement(required = true)
        protected String secuencialDocReembolso;
        @XmlElement(required = true)
        protected String fechaEmisionDocReembolso;
        @XmlElement(required = true)
        protected String numeroautorizacionDocReemb;
        @XmlElement(required = true)
        protected DetalleImpuestos detalleImpuestos;
        protected CompensacionesReembolso compensacionesReembolso;

        /**
         * Gets the value of the tipoIdentificacionProveedorReembolso property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getTipoIdentificacionProveedorReembolso() {
            return tipoIdentificacionProveedorReembolso;
        }

        /**
         * Sets the value of the tipoIdentificacionProveedorReembolso property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setTipoIdentificacionProveedorReembolso(String value) {
            this.tipoIdentificacionProveedorReembolso = value;
        }

        /**
         * Gets the value of the identificacionProveedorReembolso property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getIdentificacionProveedorReembolso() {
            return identificacionProveedorReembolso;
        }

        /**
         * Sets the value of the identificacionProveedorReembolso property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setIdentificacionProveedorReembolso(String value) {
            this.identificacionProveedorReembolso = value;
        }

        /**
         * Gets the value of the codPaisPagoProveedorReembolso property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getCodPaisPagoProveedorReembolso() {
            return codPaisPagoProveedorReembolso;
        }

        /**
         * Sets the value of the codPaisPagoProveedorReembolso property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setCodPaisPagoProveedorReembolso(String value) {
            this.codPaisPagoProveedorReembolso = value;
        }

        /**
         * Gets the value of the tipoProveedorReembolso property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getTipoProveedorReembolso() {
            return tipoProveedorReembolso;
        }

        /**
         * Sets the value of the tipoProveedorReembolso property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setTipoProveedorReembolso(String value) {
            this.tipoProveedorReembolso = value;
        }

        /**
         * Gets the value of the codDocReembolso property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getCodDocReembolso() {
            return codDocReembolso;
        }

        /**
         * Sets the value of the codDocReembolso property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setCodDocReembolso(String value) {
            this.codDocReembolso = value;
        }

        /**
         * Gets the value of the estabDocReembolso property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getEstabDocReembolso() {
            return estabDocReembolso;
        }

        /**
         * Sets the value of the estabDocReembolso property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setEstabDocReembolso(String value) {
            this.estabDocReembolso = value;
        }

        /**
         * Gets the value of the ptoEmiDocReembolso property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getPtoEmiDocReembolso() {
            return ptoEmiDocReembolso;
        }

        /**
         * Sets the value of the ptoEmiDocReembolso property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setPtoEmiDocReembolso(String value) {
            this.ptoEmiDocReembolso = value;
        }

        /**
         * Gets the value of the secuencialDocReembolso property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getSecuencialDocReembolso() {
            return secuencialDocReembolso;
        }

        /**
         * Sets the value of the secuencialDocReembolso property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setSecuencialDocReembolso(String value) {
            this.secuencialDocReembolso = value;
        }

        /**
         * Gets the value of the fechaEmisionDocReembolso property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getFechaEmisionDocReembolso() {
            return fechaEmisionDocReembolso;
        }

        /**
         * Sets the value of the fechaEmisionDocReembolso property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setFechaEmisionDocReembolso(String value) {
            this.fechaEmisionDocReembolso = value;
        }

        /**
         * Gets the value of the numeroautorizacionDocReemb property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getNumeroautorizacionDocReemb() {
            return numeroautorizacionDocReemb;
        }

        /**
         * Sets the value of the numeroautorizacionDocReemb property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setNumeroautorizacionDocReemb(String value) {
            this.numeroautorizacionDocReemb = value;
        }

        /**
         * Gets the value of the detalleImpuestos property.
         *
         * @return
         *     possible object is
         *     {@link DetalleImpuestos }
         *
         */
        public DetalleImpuestos getDetalleImpuestos() {
            return detalleImpuestos;
        }

        /**
         * Sets the value of the detalleImpuestos property.
         *
         * @param value
         *     allowed object is
         *     {@link DetalleImpuestos }
         *
         */
        public void setDetalleImpuestos(DetalleImpuestos value) {
            this.detalleImpuestos = value;
        }

        /**
         * Gets the value of the compensacionesReembolso property.
         *
         * @return
         *     possible object is
         *     {@link CompensacionesReembolso }
         *
         */
        public CompensacionesReembolso getCompensacionesReembolso() {
            return compensacionesReembolso;
        }

        /**
         * Sets the value of the compensacionesReembolso property.
         *
         * @param value
         *     allowed object is
         *     {@link CompensacionesReembolso }
         *
         */
        public void setCompensacionesReembolso(CompensacionesReembolso value) {
            this.compensacionesReembolso = value;
        }

    }

}
