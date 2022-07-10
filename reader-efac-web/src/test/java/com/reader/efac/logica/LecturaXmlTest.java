/**
 *
 */
package com.reader.efac.logica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;

import com.generated.sri.xsd.factura.Factura;
import com.reader.efac.logica.util.ApiRestUtil;
import com.reader.efac.logica.util.ComprobantesToExcelUtil;
import com.reader.efac.logica.util.LecturaReporteTxtSriUtil;
import com.reader.efac.logica.util.LecturaXmlUtil;
import com.reader.efac.sri.integracion.AutorizacionXml;
import com.reader.efac.sri.integracion.ComprobanteAutorizadoTo;

/**
 * @author crisheads
 *
 */
public class LecturaXmlTest {

	private static final String CARPETA_PRINCIPAL = "/reader-efac-web/src/test/resource/";

	public void testFiles() {
		Set<String> archivos = leerDirectorio(CARPETA_PRINCIPAL, ".xml");
		List<Factura> facturasLeidas = new ArrayList<>();
		archivos.forEach(nombreArchivo -> facturasLeidas.add(leerXml(CARPETA_PRINCIPAL, nombreArchivo)));
		try {
			ComprobantesToExcelUtil.generarExcel(facturasLeidas,
					CARPETA_PRINCIPAL.concat("/").concat("FacturasLeidas.xlsx"));
		} catch (IOException e) {
			System.err.println(" Generar excel: " + e.getMessage());
		}

	}

	private Set<String> leerDirectorio(final String carpeta, final String extension) {
		return Stream.of(new File(carpeta).listFiles())
				.filter(file -> !file.isDirectory() && file.getName().endsWith(extension)).map(File::getName)
				.collect(Collectors.toSet());
	}

	private Factura leerXml(final String carpeta, final String nombreArchivo) {
		AutorizacionXml autorizacionXml = LecturaXmlUtil
				.convertirAutorizacionXml(Paths.get(carpeta.concat(nombreArchivo)));

		Factura factura = (Factura) LecturaXmlUtil.convertirComprobanteXml(
				autorizacionXml.getComprobante().getBytes(StandardCharsets.UTF_8), Factura.class);

		String imprimir = String.format(
				"Archivo: %s, autorizacion: %s, clave acceso: %s, identificacion: %s, razon social: %s, fecha emision: %s",
				nombreArchivo, autorizacionXml.getNumeroAutorizacion(), factura.getInfoTributaria().getClaveAcceso(),
				factura.getInfoTributaria().getRuc(), factura.getInfoTributaria().getRazonSocial(),
				factura.getInfoFactura().getFechaEmision());

		System.out.println(imprimir);

		return factura;
	}

	public void leerComprobanteOnline() throws FileNotFoundException, IOException {
		try {
			ComprobanteAutorizadoTo autorizacionOnLine = ApiRestUtil.leerAutorizacionXmlPorInternet(
					"1501202201179047524700120010060302962173029621714", ComprobanteAutorizadoTo.class);

			AutorizacionXml autorizacionXml = (AutorizacionXml) LecturaXmlUtil.convertirComprobanteXml(
					autorizacionOnLine.getArchivoXML().getBytes(StandardCharsets.UTF_8), AutorizacionXml.class);

			System.out.println("AUTO XML ONLINE  => " + autorizacionXml.getNumeroAutorizacion());

			Factura factura = (Factura) LecturaXmlUtil.convertirComprobanteXml(
					autorizacionXml.getComprobante().getBytes(StandardCharsets.UTF_8), Factura.class);

			List<Factura> facturasLeidas = Arrays.asList(factura);
			ComprobantesToExcelUtil.generarExcel(facturasLeidas,
					CARPETA_PRINCIPAL.concat("/").concat("FacturasLeidasOnLine.xlsx"));

		} catch (IllegalArgumentException e) {
			System.err.println(e.getMessage());
		}

	}

	public void leerReporte() throws IllegalArgumentException {
		try {

			String path = "src/test/resource/1709492324001_Recibidos.txt";
			File file = new File(path);
			List<Factura> facturasLeidas = new ArrayList<>();

			try (InputStream fileInput = new FileInputStream(file)) {

				LecturaReporteTxtSriUtil.leerArchivoTxt(fileInput).forEach(comprobanteReporte -> {
					ComprobanteAutorizadoTo autorizacionOnLine = ApiRestUtil.leerAutorizacionXmlPorInternet(
							comprobanteReporte.getClaveAcceso(), ComprobanteAutorizadoTo.class);

					AutorizacionXml autorizacionXml = (AutorizacionXml) LecturaXmlUtil.convertirComprobanteXml(
							autorizacionOnLine.getArchivoXML().getBytes(StandardCharsets.UTF_8), AutorizacionXml.class);

					Factura factura = (Factura) LecturaXmlUtil.convertirComprobanteXml(
							autorizacionXml.getComprobante().getBytes(StandardCharsets.UTF_8), Factura.class);

					facturasLeidas.add(factura);
				});

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			byte[] resultado = ComprobantesToExcelUtil.generarExcel2(facturasLeidas);
			Assert.assertNotNull(resultado);

		} catch (IOException e) {
			System.err.println("Error al leer archivo msg: " + e.getMessage());
			Assert.fail(e.getMessage());
		}

	}

}
