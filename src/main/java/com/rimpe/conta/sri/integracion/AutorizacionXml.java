/**
 * 
 */
package com.rimpe.conta.sri.integracion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author crisheads
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "autorizacion")
@XmlType(name = "autorizacion")
public class AutorizacionXml implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5328371577207345553L;

	@XmlElement(name = "estado")
	private String estado;
	@XmlElement(name = "numeroAutorizacion")
	private String numeroAutorizacion;

	@XmlElement(name = "ambiente")
	private String ambiente;

	@XmlElement(name = "comprobante")
	private String comprobante;

	@XmlElementWrapper(name = "mensajes")
	@XmlElement(name = "mensaje")
	private List<MensajeXml> mensajes = new ArrayList<MensajeXml>();

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNumeroAutorizacion() {
		return numeroAutorizacion;
	}

	public void setNumeroAutorizacion(String numeroAutorizacion) {
		this.numeroAutorizacion = numeroAutorizacion;
	}

	public String getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}

	public String getComprobante() {
		return comprobante;
	}

	public void setComprobante(String comprobante) {
		this.comprobante = comprobante;
	}

	public List<MensajeXml> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<MensajeXml> mensajes) {
		this.mensajes = mensajes;
	}

	@Override
	public String toString() {
		return "AutorizacionXml [estado=" + estado + ", numeroAutorizacion=" + numeroAutorizacion + ", ambiente="
				+ ambiente + ", comprobante=" + comprobante + ", mensajes=" + mensajes + "]";
	}

}
