/**
 * 
 */
package com.rimpe.conta.sri.integracion;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author crisheads
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "mensaje")
@XmlType(name = "mensaje")
public class MensajeXml implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2844577030512592278L;

	@XmlElement(name = "identificador")
	private String identificador;

	@XmlElement(name = "mensaje")
	private String descripcion;

	@XmlElement(name = "informacionAdicional")
	private String informacionAdicional;

	@XmlElement(name = "tipo")
	private String tipoMensaje;

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getInformacionAdicional() {
		return informacionAdicional;
	}

	public void setInformacionAdicional(String informacionAdicional) {
		this.informacionAdicional = informacionAdicional;
	}

	public String getTipoMensaje() {
		return tipoMensaje;
	}

	public void setTipoMensaje(String tipoMensaje) {
		this.tipoMensaje = tipoMensaje;
	}

	@Override
	public String toString() {
		return "MensajeXml [identificador=" + identificador + ", descripcion=" + descripcion + ", informacionAdicional="
				+ informacionAdicional + ", tipoMensaje=" + tipoMensaje + "]";
	}

}
