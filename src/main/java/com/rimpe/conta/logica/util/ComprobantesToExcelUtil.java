/**
 * 
 */
package com.rimpe.conta.logica.util;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import com.generated.sri.xsd.factura.Factura;
import com.generated.sri.xsd.factura.Factura.Detalles.Detalle;
import com.generated.sri.xsd.factura.Impuesto;
import com.rimpe.conta.sri.integracion.enums.TablaImpuestoEnum;
import com.rimpe.conta.sri.integracion.enums.TablaTarifaIvaEnum;

/**
 * @author crisheads
 *
 */
public final class ComprobantesToExcelUtil {

	private static final String FORMATO_DD_MM_YYYY = "dd/mm/yyyy";
	private static final DateFormat FORMATO_FECHA_CORTA = new SimpleDateFormat(FORMATO_DD_MM_YYYY);

	public static byte[] generarExcel2(final List<Factura> facturas) throws FileNotFoundException, IOException {

		List<String> cabeceras = Arrays.asList("TIPO", "FECHA", "PUNTO DE EMISION", "SECUENCIA", "N° FACTURA",
				"RUC PROVEEDOR", "PROVEEDOR", "CONTRIBUYENTE RIMPE", "Identificación comprador",
				"Nombre o Razon social del comprador", "CLAVE DE ACCESO", "DETALLE DE LA COMPRA", "Cantidad",
				"Precio unitario", "Precio sin subsidio", "Descuento USD", "Total sin impuestos USD", "IVA 0%",
				"IVA 12%", "IVA 14%", "No Objeto de impuesto", "Exento de IVA", "IVA diferenciado", "ICE", "IRBPNR",
				"Total");

		try (Workbook wb = new SXSSFWorkbook(100)) {
			CreationHelper createHelper = wb.getCreationHelper();

			CellStyle cellStyle = wb.createCellStyle();
			cellStyle.setDataFormat(createHelper.createDataFormat().getFormat(FORMATO_DD_MM_YYYY));

			Sheet sheet = wb.createSheet("Facturas2");

			Row rowCabecera = sheet.createRow(0);
			for (int i = 0; i < cabeceras.size(); i++) {
				Cell cell = rowCabecera.createCell(i);
				cell.setCellValue(cabeceras.get(i));
			}

			crearFilas2(facturas, cellStyle, sheet);
			byte[] resultado;
			try (ByteArrayOutputStream out = new ByteArrayOutputStream()) {
				wb.write(out);
				resultado = out.toByteArray();
				out.close();
			}
			return resultado;

		}

	}

	public static void generarExcel(final List<Factura> facturas, final String rutaNombreArchivo)
			throws FileNotFoundException, IOException {

		List<String> cabeceras = Arrays.asList("TIPO", "FECHA", "PUNTO DE EMISION", "SECUENCIA", "N° FACTURA",
				"RUC PROVEEDOR", "PROVEEDOR", "CONTRIBUYENTE RIMPE", "Identificación comprador",
				"Nombre o Razon social del comprador", "CLAVE DE ACCESO", "DETALLE DE LA COMPRA", "Cantidad",
				"Precio unitario", "Precio sin subsidio", "Descuento USD", "Total sin impuestos USD",
				"Base imponible USD", "Tarifa %", "Valor USD", "Código de impuesto", "Impuesto", "Código de porcentaje",
				"Porcentaje");

		try (SXSSFWorkbook wb = new SXSSFWorkbook(100)) {
			CreationHelper createHelper = wb.getCreationHelper();

			CellStyle cellStyle = wb.createCellStyle();
			cellStyle.setDataFormat(createHelper.createDataFormat().getFormat(FORMATO_DD_MM_YYYY));

			Sheet sheet = wb.createSheet("Facturas");

			Row rowCabecera = sheet.createRow(0);
			for (int i = 0; i < cabeceras.size(); i++) {
				Cell cell = rowCabecera.createCell(i);
				cell.setCellValue(cabeceras.get(i));
			}

			crearFilas(facturas, cellStyle, sheet);

			try (FileOutputStream out = new FileOutputStream(rutaNombreArchivo)) {
				wb.write(out);
				out.close();
				// dispose of temporary files backing this workbook on disk
				wb.dispose();
			}
		}

	}

	private static void crearFilas(List<Factura> facturas, CellStyle cellStyle, Sheet sheet) {
		// Inicia en la fila 1
		int filas = 1;
		for (Factura factura : facturas) {
			List<Detalle> detalles = factura.getDetalles().getDetalle();
			for (Detalle detalle : detalles) {
				for (Impuesto impuesto : detalle.getImpuestos().getImpuesto()) {
					int columna = 0;
					// Se crea la fila con el ultimo dato de repeticion
					Row row = sheet.createRow(filas++);

					// datos factura - se repiten porque tiene varios detalles
					crearCelda(columna++, "Factura_v".concat(factura.getVersion()), row, cellStyle);
					crearCelda(columna++, factura.getInfoFactura().getFechaEmision(), row, cellStyle);
					crearCelda(columna++, factura.getInfoTributaria().getEstab(), row, cellStyle);
					crearCelda(columna++, factura.getInfoTributaria().getPtoEmi(), row, cellStyle);
					crearCelda(columna++, factura.getInfoTributaria().getSecuencial(), row, cellStyle);
					crearCelda(columna++, factura.getInfoTributaria().getRuc(), row, cellStyle);
					crearCelda(columna++, factura.getInfoTributaria().getRazonSocial(), row, cellStyle);
					crearCelda(columna++, factura.getInfoTributaria().getContribuyenteRimpe(), row, cellStyle);
					crearCelda(columna++, factura.getInfoFactura().getIdentificacionComprador(), row, cellStyle);
					crearCelda(columna++, factura.getInfoFactura().getRazonSocialComprador(), row, cellStyle);
					crearCelda(columna++, factura.getInfoTributaria().getClaveAcceso(), row, cellStyle);

					// detalles - se repiten se repiten porque puede tener varios impuestos
					crearCelda(columna++, detalle.getDescripcion(), row, cellStyle);
					crearCelda(columna++, detalle.getCantidad(), row, cellStyle);
					crearCelda(columna++, detalle.getPrecioUnitario(), row, cellStyle);
					crearCelda(columna++, detalle.getPrecioSinSubsidio(), row, cellStyle);
					crearCelda(columna++, detalle.getDescuento(), row, cellStyle);
					crearCelda(columna++, detalle.getPrecioTotalSinImpuesto(), row, cellStyle);

					// impuestos
					crearCelda(columna++, impuesto.getBaseImponible(), row, cellStyle);
					crearCelda(columna++, impuesto.getTarifa(), row, cellStyle);
					crearCelda(columna++, impuesto.getValor(), row, cellStyle);
					crearCelda(columna++, impuesto.getCodigo(), row, cellStyle);
					TablaImpuestoEnum tablaImpuestoEnum = TablaImpuestoEnum.getEnum(impuesto.getCodigo());

					if (Objects.nonNull(tablaImpuestoEnum)) {
						crearCelda(columna++, TablaImpuestoEnum.getEnum(impuesto.getCodigo()).getDescripcion(), row,
								cellStyle);
					}
					crearCelda(columna++, impuesto.getCodigoPorcentaje(), row, cellStyle);

					if (Objects.nonNull(tablaImpuestoEnum) && TablaImpuestoEnum.IVA.equals(tablaImpuestoEnum)) {
						crearCelda(columna++,
								TablaTarifaIvaEnum.getEnum(impuesto.getCodigoPorcentaje()).getDescripcion(), row,
								cellStyle);
					} else {
						crearCelda(columna++, " ", row, cellStyle);
					}
				}

			}

		}
	}

	private static void crearFilas2(List<Factura> facturas, CellStyle cellStyle, Sheet sheet) {
		// Inicia en la fila 1
		int filas = 1;
		for (Factura factura : facturas) {
			List<Detalle> detalles = factura.getDetalles().getDetalle();
			for (Detalle detalle : detalles) {
				int columna = 0;
				// Se crea la fila con el ultimo dato de repeticion
				Row row = sheet.createRow(filas++);

				// datos factura - se repiten porque tiene varios detalles
				crearCelda(columna++, "Factura_v".concat(factura.getVersion()), row, cellStyle);
				crearCelda(columna++, factura.getInfoFactura().getFechaEmision(), row, cellStyle);
				crearCelda(columna++, factura.getInfoTributaria().getEstab(), row, cellStyle);
				crearCelda(columna++, factura.getInfoTributaria().getPtoEmi(), row, cellStyle);
				crearCelda(columna++, factura.getInfoTributaria().getSecuencial(), row, cellStyle);
				crearCelda(columna++, factura.getInfoTributaria().getRuc(), row, cellStyle);
				crearCelda(columna++, factura.getInfoTributaria().getRazonSocial(), row, cellStyle);
				crearCelda(columna++, factura.getInfoTributaria().getContribuyenteRimpe(), row, cellStyle);
				crearCelda(columna++, factura.getInfoFactura().getIdentificacionComprador(), row, cellStyle);
				crearCelda(columna++, factura.getInfoFactura().getRazonSocialComprador(), row, cellStyle);
				crearCelda(columna++, factura.getInfoTributaria().getClaveAcceso(), row, cellStyle);

				// detalles - se repiten se repiten porque puede tener varios impuestos
				crearCelda(columna++, detalle.getDescripcion(), row, cellStyle);
				crearCelda(columna++, detalle.getCantidad(), row, cellStyle);
				crearCelda(columna++, detalle.getPrecioUnitario(), row, cellStyle);
				crearCelda(columna++, detalle.getPrecioSinSubsidio(), row, cellStyle);
				crearCelda(columna++, detalle.getDescuento(), row, cellStyle);
				crearCelda(columna++, detalle.getPrecioTotalSinImpuesto(), row, cellStyle);

				List<Impuesto> impuestosIVA = detalle.getImpuestos().getImpuesto().stream()
						.filter(impuesto -> TablaImpuestoEnum.IVA.getCodigo().equals(impuesto.getCodigo()))
						.collect(Collectors.toList());
				BigDecimal total = BigDecimal.ZERO.add(detalle.getPrecioTotalSinImpuesto());

				for (TablaTarifaIvaEnum tablaTarifaIvaEnum : TablaTarifaIvaEnum.values()) {
					BigDecimal totalTarifaIVA = impuestosIVA.stream()
							.filter(impuesto -> tablaTarifaIvaEnum.getCodigo().equals(impuesto.getCodigo()))
							.map(Impuesto::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);

					crearCelda(columna++, totalTarifaIVA, row, cellStyle);
					total = total.add(totalTarifaIVA);
				}

				BigDecimal totalTarifaICE = detalle.getImpuestos().getImpuesto().stream()
						.filter(impuesto -> TablaImpuestoEnum.ICE.getCodigo().equals(impuesto.getCodigo()))
						.map(Impuesto::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
				crearCelda(columna++, totalTarifaICE, row, cellStyle);

				BigDecimal totalTarifaIRBPNR = detalle.getImpuestos().getImpuesto().stream()
						.filter(impuesto -> TablaImpuestoEnum.IRBPNR.getCodigo().equals(impuesto.getCodigo()))
						.map(Impuesto::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
				crearCelda(columna++, totalTarifaIRBPNR, row, cellStyle);

				total = total.add(totalTarifaICE).add(totalTarifaIRBPNR);
				crearCelda(columna++, total, row, cellStyle);

			}

		}
	}

	private static Cell crearCelda(int columna, Object valor, Row row, CellStyle cellStyle) {
		Cell cell = row.createCell(columna);
		if (Objects.isNull(valor)) {
			cell.setBlank();
		} else if (valor instanceof String) {
			Object nuevoValor = convertir(valor);
			if (nuevoValor instanceof Date) {
				cell.setCellStyle(cellStyle);
				cell.setCellValue((Date) nuevoValor);
			} else {
				cell.setCellValue(Objects.toString(valor));
			}
		} else if (valor instanceof BigDecimal) {
			cell.setCellValue(new BigDecimal(Objects.toString(valor)).doubleValue());
		} else if (valor instanceof Date) {
			cell.setCellValue((Date) valor);
		} else {
			cell.setCellValue(Objects.toString(valor));
		}
		return cell;
	}

	private static Object convertir(Object valor) {
		Object resultado;
		try {
			resultado = FORMATO_FECHA_CORTA.parse(Objects.toString(valor));
		} catch (ParseException e) {
			resultado = valor;
		}
		return resultado;
	}

}
