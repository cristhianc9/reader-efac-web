/**
 * 
 */
package com.rimpe.conta.sri.integracion.enums;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author crisheads
 *
 */
public enum TablaImpuestoEnum {
	IVA("2", "IVA"), ICE("3", "ICE"), IRBPNR("5", "IRBPNR");

	private String codigo;
	private String descripcion;

	TablaImpuestoEnum(String codigo, String descripcion) {
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public static TablaImpuestoEnum getEnum(final String codigo) {
		Optional<TablaImpuestoEnum> enumeradorOptional = Arrays.asList(values()).stream()
				.filter(enumerador -> enumerador.getCodigo().equals(codigo)).findFirst();
		return enumeradorOptional.isPresent() ? enumeradorOptional.get() : null;
	}

}
