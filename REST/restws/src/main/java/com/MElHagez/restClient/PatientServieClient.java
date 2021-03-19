package com.MElHagez.restClient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.plugins.providers.jackson.ResteasyJacksonProvider;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

import com.MElHagez.jaxrs.Patient;

/**
 * @author Created by M_ElHagez on Mar 18, 2021 
 */
public class PatientServieClient {

	private static final String PATIENT_SERVICE_URL = "http://localhost:8082/restws/services/patientservice";


	public static void main(String[] args) {
//		ResteasyProviderFactory instance=ResteasyProviderFactory.getInstance();
//	    RegisterBuiltin.register(instance);
//	    instance.registerProvider(ResteasyJacksonProvider.class);
//      1- new client
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(PATIENT_SERVICE_URL).path("/patients").
				                                              path("/{id}").resolveTemplate("id", 123);
//		Response patient = target.request().get();
//		add new 
		Patient patient = target.request().get(Patient.class);
		System.out.println(patient.getName());
	}

}
