/**
 *
 */
package com.reader.efac.view;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import com.generated.sri.xsd.factura.Factura;
import com.reader.efac.logica.util.ApiRestUtil;
import com.reader.efac.logica.util.ComprobantesToExcelUtil;
import com.reader.efac.logica.util.LecturaReporteTxtSriUtil;
import com.reader.efac.logica.util.LecturaXmlUtil;
import com.reader.efac.sri.integracion.AutorizacionXml;
import com.reader.efac.sri.integracion.ComprobanteAutorizadoTo;
import com.reader.efac.sri.integracion.ComprobanteReporteTo;

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

	private StreamedContent streamedContent;

	private List<ComprobanteReporteTo> comprobantesLeidos;

	private String nombreArchivoExcel;

	public StreamedContent getStreamedContent() {
		return streamedContent;
	}

	public void setStreamedContent(StreamedContent streamedContent) {
		this.streamedContent = streamedContent;
	}

	public void handleFileUpload(FileUploadEvent event) {
		FacesMessage message;
		try {
			comprobantesLeidos = LecturaReporteTxtSriUtil.leerArchivoTxt(event.getFile().getInputStream());
			String nombreArchivo = event.getFile().getFileName();
			nombreArchivoExcel = nombreArchivo.replace(".txt", ".xlsx");

			message = new FacesMessage("Carga de archivos", nombreArchivo + " cargado correctamente.");

		} catch (IOException e) {
			message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en la carga de archivos",
					event.getFile().getFileName() + ". " + e.getMessage());

		}
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void generarArchivo() {
		try {
			streamedContent = DefaultStreamedContent.builder().name(nombreArchivoExcel)
					.contentType("application/vnd.ms-excel").writer((outputStream) -> {
						try {
							outputStream.write(generarExcel(comprobantesLeidos));
						} catch (IOException e) {
							e.printStackTrace();
							throw new IllegalArgumentException(e);
						}
					}).build();
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());

		}
	}

	private static byte[] generarExcel(Iterable<ComprobanteReporteTo> listaReporte) throws IOException {
		List<Factura> facturasLeidas = new ArrayList<>();

		listaReporte.forEach(comprobanteReporte -> {
			ComprobanteAutorizadoTo autorizacionOnLine = ApiRestUtil
					.leerAutorizacionXmlPorInternet(comprobanteReporte.getClaveAcceso(), ComprobanteAutorizadoTo.class);

			AutorizacionXml autorizacionXml = (AutorizacionXml) LecturaXmlUtil.convertirComprobanteXml(
					autorizacionOnLine.getArchivoXML().getBytes(StandardCharsets.UTF_8), AutorizacionXml.class);

			Factura factura = (Factura) LecturaXmlUtil.convertirComprobanteXml(
					autorizacionXml.getComprobante().getBytes(StandardCharsets.UTF_8), Factura.class);

			facturasLeidas.add(factura);
		});

		return ComprobantesToExcelUtil.generarExcel2(facturasLeidas);

	}

}
