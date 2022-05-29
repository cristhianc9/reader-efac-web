/**
 *
 */
package com.reader.efac.sri.integracion.enums;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author crisheads
 *
 */
public enum TablaTarifaIvaEnum {
	CERO("0", "0%"), DOCE("2", "12%"), CATORCE("3", "14%"), NO_OBJETO("6", "No Objeto de Impuesto"),
	EXENTO("7", "Exento de IVA"), DIFERENCIADO("8", "IVA diferenciado");

	private String codigo;
	private String descripcion;

	TablaTarifaIvaEnum(String codigo, String descripcion) {
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

	public static TablaTarifaIvaEnum getEnum(final String codigo) {
		Optional<TablaTarifaIvaEnum> enumeradorOptional = Arrays.asList(values()).stream()
				.filter(enumerador -> enumerador.getCodigo().equals(codigo)).findFirst();
		return enumeradorOptional.isPresent() ? enumeradorOptional.get() : null;
	}

}
