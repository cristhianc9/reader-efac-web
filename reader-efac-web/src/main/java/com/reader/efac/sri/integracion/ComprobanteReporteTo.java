/**
 *
 */
package com.reader.efac.sri.integracion;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author crisheads
 *
 */
public class ComprobanteReporteTo implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 3578863605858381639L;

	private String comprobante;
	private String serieComprobante;
	private String rucEmisor;
	private String razonSocialEmisor;
	private String fechaEmision;
	private String fechaAutorizacion;
	private String tipoEmision;
	private String espacio;
	private String identificacionReceptor;
	private String claveAcceso;
	private String numeroAutorizacion;
	private String importeTotal;

	/**
	 * @param parametros
	 */
	public ComprobanteReporteTo(Object... parametros) {
		super();
		this.comprobante = parametros[0].toString();
		this.serieComprobante = parametros[1].toString();
		this.rucEmisor = parametros[2].toString();
		this.razonSocialEmisor = parametros[3].toString();
		this.fechaEmision = parametros[4].toString();
		this.fechaAutorizacion = parametros[5].toString();
		this.tipoEmision = parametros[6].toString();
		this.espacio = parametros[7].toString();
		this.identificacionReceptor = parametros[8].toString();
		this.claveAcceso = parametros[9].toString();
		this.numeroAutorizacion = parametros[10].toString();
		this.importeTotal = parametros[11].toString();
	}

	public String getComprobante() {
		return comprobante;
	}

	public void setComprobante(String comprobante) {
		this.comprobante = comprobante;
	}

	public String getSerieComprobante() {
		return serieComprobante;
	}

	public void setSerieComprobante(String serieComprobante) {
		this.serieComprobante = serieComprobante;
	}

	public String getRucEmisor() {
		return rucEmisor;
	}

	public void setRucEmisor(String rucEmisor) {
		this.rucEmisor = rucEmisor;
	}

	public String getRazonSocialEmisor() {
		return razonSocialEmisor;
	}

	public void setRazonSocialEmisor(String razonSocialEmisor) {
		this.razonSocialEmisor = razonSocialEmisor;
	}

	public String getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(String fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public String getFechaAutorizacion() {
		return fechaAutorizacion;
	}

	public void setFechaAutorizacion(String fechaAutorizacion) {
		this.fechaAutorizacion = fechaAutorizacion;
	}

	public String getTipoEmision() {
		return tipoEmision;
	}

	public void setTipoEmision(String tipoEmision) {
		this.tipoEmision = tipoEmision;
	}

	public String getIdentificacionReceptor() {
		return identificacionReceptor;
	}

	public void setIdentificacionReceptor(String identificacionReceptor) {
		this.identificacionReceptor = identificacionReceptor;
	}

	public String getClaveAcceso() {
		return claveAcceso;
	}

	public void setClaveAcceso(String claveAcceso) {
		this.claveAcceso = claveAcceso;
	}

	public String getNumeroAutorizacion() {
		return numeroAutorizacion;
	}

	public void setNumeroAutorizacion(String numeroAutorizacion) {
		this.numeroAutorizacion = numeroAutorizacion;
	}

	public String getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(String importeTotal) {
		this.importeTotal = importeTotal;
	}

	public String getEspacio() {
		return espacio;
	}

	public void setEspacio(String espacio) {
		this.espacio = espacio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(claveAcceso, comprobante, fechaAutorizacion, fechaEmision, identificacionReceptor,
				importeTotal, numeroAutorizacion, razonSocialEmisor, rucEmisor, serieComprobante, tipoEmision);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		ComprobanteReporteTo other = (ComprobanteReporteTo) obj;
		return Objects.equals(claveAcceso, other.claveAcceso) && Objects.equals(comprobante, other.comprobante)
				&& Objects.equals(fechaAutorizacion, other.fechaAutorizacion)
				&& Objects.equals(fechaEmision, other.fechaEmision)
				&& Objects.equals(identificacionReceptor, other.identificacionReceptor)
				&& Objects.equals(importeTotal, other.importeTotal)
				&& Objects.equals(numeroAutorizacion, other.numeroAutorizacion)
				&& Objects.equals(razonSocialEmisor, other.razonSocialEmisor)
				&& Objects.equals(rucEmisor, other.rucEmisor)
				&& Objects.equals(serieComprobante, other.serieComprobante)
				&& Objects.equals(tipoEmision, other.tipoEmision);
	}

	@Override
	public String toString() {
		return "ComprobanteReporteTo [comprobante=" + comprobante + ", serieComprobante=" + serieComprobante
				+ ", rucEmisor=" + rucEmisor + ", razonSocialEmisor=" + razonSocialEmisor + ", fechaEmision="
				+ fechaEmision + ", fechaAutorizacion=" + fechaAutorizacion + ", tipoEmision=" + tipoEmision
				+ ", identificacionReceptor=" + identificacionReceptor + ", claveAcceso=" + claveAcceso
				+ ", numeroAutorizacion=" + numeroAutorizacion + ", importeTotal=" + importeTotal + "]";
	}

}
