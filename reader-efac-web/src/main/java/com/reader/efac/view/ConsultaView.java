/**
 *
 */
package com.reader.efac.view;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.file.UploadedFile;

import com.generated.sri.xsd.factura.Factura;
import com.reader.efac.logica.util.ApiRestUtil;
import com.reader.efac.logica.util.ComprobantesToExcelUtil;
import com.reader.efac.logica.util.LecturaReporteTxtSriUtil;
import com.reader.efac.logica.util.LecturaXmlUtil;
import com.reader.efac.sri.integracion.AutorizacionXml;
import com.reader.efac.sri.integracion.ComprobanteAutorizadoTo;
import com.reader.efac.sri.integracion.ComprobanteReporteTo;
import com.reader.efac.view.data.ResultadoReporteComprobante;

/**
 * @author crisheads
 *
 */
@Named(value = "consultaView")
@ViewScoped
public class ConsultaView implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private List<UploadedFile> files;
	private List<ResultadoReporteComprobante> listaResultadoReporteComprobante;

	/**
	 * @param comprobantesLeidos
	 */
	public ConsultaView() {
		super();
		this.listaResultadoReporteComprobante = new ArrayList<>();
		this.files = new ArrayList<>();
	}

	public void handleFileUpload(FileUploadEvent event) {
		UploadedFile file = event.getFile();
		/*
		 * this.files.add(file); FacesMessage message = new FacesMessage("Successful",
		 * file.getFileName() + " is uploaded.");
		 * FacesContext.getCurrentInstance().addMessage(null, message);
		 */
		try {
			System.out
					.println("inicio Size listaResultadoReporteComprobante " + listaResultadoReporteComprobante.size());
			generarArchivo(file, listaResultadoReporteComprobante);
			System.out.println("fin Size listaResultadoReporteComprobante " + listaResultadoReporteComprobante.size());
		} catch (IllegalArgumentException | IOException e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public void generarArchivos() {
		listaResultadoReporteComprobante.clear();
		for (UploadedFile file : this.files) {

			try {
				generarArchivo(file, listaResultadoReporteComprobante);
			} catch (IllegalArgumentException | IOException e) {
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
				FacesContext.getCurrentInstance().addMessage(null, message);
			}
		}
		this.files.clear();
	}

	public void generarArchivo(UploadedFile file, List<ResultadoReporteComprobante> listaResultadoReporteComprobante)
			throws IOException {

		List<ComprobanteReporteTo> comprobantesLeidos = LecturaReporteTxtSriUtil.leerArchivoTxt(file.getInputStream());

		ResultadoReporteComprobante resultadoReporteComprobante = new ResultadoReporteComprobante(LocalDateTime.now());
		String nombreArchivo = file.getFileName();
		resultadoReporteComprobante.setNombreArchivo(nombreArchivo);
		resultadoReporteComprobante.setNumeroComprobantesTotales(comprobantesLeidos.size());

		String nombreArchivoExcel = nombreArchivo.replace(".txt", ".xlsx");

		resultadoReporteComprobante.setArchivoGenerado(DefaultStreamedContent.builder().name(nombreArchivoExcel)
				.contentType("application/vnd.ms-excel").writer((outputStream) -> {
					try {
						outputStream.write(generarExcel(comprobantesLeidos, resultadoReporteComprobante));
					} catch (IOException e) {
						System.err.println("Error al generar el archivo excel => " + e.getMessage());
						resultadoReporteComprobante.setFinalizaProcesamiento(LocalDateTime.now());
						FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
						FacesContext.getCurrentInstance().addMessage(null, message);
					}
				}).build());

		listaResultadoReporteComprobante.add(resultadoReporteComprobante);

	}

	private byte[] generarExcel(List<ComprobanteReporteTo> listaComprobanteReporte,
			ResultadoReporteComprobante resultadoReporteComprobante) throws IOException {
		List<Factura> facturasLeidas = new ArrayList<>();

		for (ComprobanteReporteTo comprobanteReporte : listaComprobanteReporte) {

			try {
				ComprobanteAutorizadoTo autorizacionOnLine = ApiRestUtil.leerAutorizacionXmlPorInternet(
						comprobanteReporte.getClaveAcceso(), ComprobanteAutorizadoTo.class);

				resultadoReporteComprobante
						.setNumeroComprobantesLeidos(resultadoReporteComprobante.getNumeroComprobantesLeidos() + 1);

				AutorizacionXml autorizacionXml = (AutorizacionXml) LecturaXmlUtil.convertirComprobanteXml(
						autorizacionOnLine.getArchivoXML().getBytes(StandardCharsets.UTF_8), AutorizacionXml.class);

				Factura factura = (Factura) LecturaXmlUtil.convertirComprobanteXml(
						autorizacionXml.getComprobante().getBytes(StandardCharsets.UTF_8), Factura.class);

				facturasLeidas.add(factura);
			} catch (IllegalArgumentException e) {
				throw new IOException(e);
			}

		}

		return ComprobantesToExcelUtil.generarExcel2(facturasLeidas);

	}

	public List<ResultadoReporteComprobante> getListaResultadoReporteComprobante() {
		return listaResultadoReporteComprobante;
	}

	public void setListaResultadoReporteComprobante(
			List<ResultadoReporteComprobante> listaResultadoReporteComprobante) {
		this.listaResultadoReporteComprobante = listaResultadoReporteComprobante;
	}

	public List<UploadedFile> getFiles() {
		return files;
	}

	public void setFiles(List<UploadedFile> files) {
		this.files = files;
	}

}
