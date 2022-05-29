/**
 *
 */
package com.reader.efac.logica.util;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.reader.efac.sri.integracion.AutorizacionXml;

/**
 * @author crist
 *
 */
public final class LecturaXmlUtil {

	public static AutorizacionXml convertirAutorizacionXml(Path file) {
		JAXBContext context = null;
		Unmarshaller unmarshaller = null;
		try {
			try (final InputStream is = new FileInputStream(file.toFile())) {
				context = JAXBContext.newInstance(AutorizacionXml.class);
				unmarshaller = context.createUnmarshaller();
				Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8);
				return (AutorizacionXml) unmarshaller.unmarshal(reader);
			}
		} catch (JAXBException e) {
			throw new IllegalArgumentException(e.getMessage(), e);
		} catch (IOException e) {
			throw new IllegalArgumentException(e.getMessage(), e);
		}

	}

	public static Object convertirComprobanteXml(byte[] comprobante, Class<?> clase) {
		JAXBContext context = null;
		Unmarshaller unmarshaller = null;
		try {
			try (final InputStream is = new ByteArrayInputStream(comprobante)) {
				context = JAXBContext.newInstance(clase);
				unmarshaller = context.createUnmarshaller();
				Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8);
				return unmarshaller.unmarshal(reader);
			}
		} catch (JAXBException e) {
			throw new IllegalArgumentException(e.getMessage(), e);
		} catch (IOException e) {
			throw new IllegalArgumentException(e.getMessage(), e);
		}

	}

}
