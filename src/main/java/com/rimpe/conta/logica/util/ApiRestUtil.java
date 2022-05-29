/**
 * 
 */
package com.rimpe.conta.logica.util;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

/**
 * @author crisheads
 *
 */
public final class ApiRestUtil {

	private static final String URI_API_REST_BASE = "https://srienlinea.sri.gob.ec/fedatarios-fiscales-movil/api";
	private static final String RECURSO_COMPROBANTES = "/ConsultasComprobantesElectronicos";
	private static final String METODO_CLAVE_ACCESO = "/porClaveAcceso";

	private static final Client cliente = ClientBuilder.newClient();
	private static final WebTarget webTargetPorClaveAcceso = cliente
			.target(URI_API_REST_BASE.concat(RECURSO_COMPROBANTES).concat(METODO_CLAVE_ACCESO));

	private static final Invocation.Builder solicitud = webTargetPorClaveAcceso.request().header("Content-Type",
			"application/json;charset=utf-8");

	public static <T> T leerAutorizacionXmlPorInternet(final String claveAcceso, Class<? extends T> clase) {
		MultivaluedMap<String, String> mapa = new MultivaluedHashMap<String, String>();
		mapa.add("claveAcceso", claveAcceso);
		try {
			Response response = solicitud.post(Entity.form(mapa));
			if (Response.Status.Family.SUCCESSFUL.compareTo(response.getStatusInfo().getFamily()) == 0) {
				return response.readEntity(clase);
			} else {
				throw new IllegalArgumentException(
						"Inconveniente al consumir el servicio rest. " + response.getStatusInfo().getReasonPhrase());
			}
		} catch (ProcessingException e) {
			throw new IllegalArgumentException("No se pudo consumir el servicio rest. " + e.getMessage(), e);
		}
	}

}
