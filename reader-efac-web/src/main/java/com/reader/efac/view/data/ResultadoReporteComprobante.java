/**
 * 
 */
package com.reader.efac.view.data;

import java.time.LocalDateTime;

import org.primefaces.model.StreamedContent;

/**
 * @author crist
 *
 */
public class ResultadoReporteComprobante {

	private String nombreArchivo;
	private int numeroComprobantesTotales;
	private int numeroComprobantesLeidos;
	private LocalDateTime inicioProcesamiento;
	private LocalDateTime finalizaProcesamiento;
	private StreamedContent archivoGenerado;

	/**
	 * @param inicioProcesamiento
	 */
	public ResultadoReporteComprobante(LocalDateTime inicioProcesamiento) {
		super();
		this.inicioProcesamiento = inicioProcesamiento;
		this.numeroComprobantesTotales = 0;
		this.numeroComprobantesLeidos=0;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public int getNumeroComprobantesTotales() {
		return numeroComprobantesTotales;
	}

	public void setNumeroComprobantesTotales(int numeroComprobantesTotales) {
		this.numeroComprobantesTotales = numeroComprobantesTotales;
	}

	public int getNumeroComprobantesLeidos() {
		return numeroComprobantesLeidos;
	}

	public void setNumeroComprobantesLeidos(int numeroComprobantesLeidos) {
		this.numeroComprobantesLeidos = numeroComprobantesLeidos;
	}

	public LocalDateTime getInicioProcesamiento() {
		return inicioProcesamiento;
	}

	public void setInicioProcesamiento(LocalDateTime inicioProcesamiento) {
		this.inicioProcesamiento = inicioProcesamiento;
	}

	public LocalDateTime getFinalizaProcesamiento() {
		return finalizaProcesamiento;
	}

	public void setFinalizaProcesamiento(LocalDateTime finalizaProcesamiento) {
		this.finalizaProcesamiento = finalizaProcesamiento;
	}

	public StreamedContent getArchivoGenerado() {
		return archivoGenerado;
	}

	public void setArchivoGenerado(StreamedContent archivoGenerado) {
		this.archivoGenerado = archivoGenerado;
	}

}
