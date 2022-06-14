package com.reader.efac.logica.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.reader.efac.sri.integracion.ComprobanteReporteTo;

public final class LecturaReporteTxtSriUtil {

	private LecturaReporteTxtSriUtil() {
		super();
	}

	public static List<ComprobanteReporteTo> leerArchivoTxt(InputStream inputStream) throws IOException {
		List<ComprobanteReporteTo> listaComprobanteReporteTo = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			int fila = 0;
			List<String> lineaCompleta = new ArrayList<>();
			String line;
			while ((line = br.readLine()) != null) {
				String[] linea = line.split("\t");
				if (fila > 1) {
					if (linea.length == 11) {
						lineaCompleta.addAll(Arrays.asList(linea));
					}
					if (linea.length == 1) {
						lineaCompleta.add(linea[0]);
					}

					if (lineaCompleta.size() == 12) {

						ComprobanteReporteTo comprobanteReporteTo = new ComprobanteReporteTo(lineaCompleta.toArray());
						lineaCompleta.clear();
						listaComprobanteReporteTo.add(comprobanteReporteTo);
					}

				}
				fila++;
			}

		} catch (IOException e) {
			System.err.println("No se pudo leer el reporte txt: " + e.getMessage());
		}

		return listaComprobanteReporteTo;
	}

}