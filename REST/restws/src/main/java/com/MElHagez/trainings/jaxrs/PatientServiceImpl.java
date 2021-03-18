package com.MElHagez.trainings.jaxrs;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;

public class PatientServiceImpl implements PatientService {
	private long currentId = 123;
	Map<Long, Patient> patients = new HashMap<Long, Patient>();
	Map<Long, Prescription> prescriptions = new HashMap<Long, Prescription>();

	public PatientServiceImpl() {
		init();
	}

	final void init() {
		Patient patient = new Patient();
		patient.setName("John");
		patient.setId(currentId);
		patients.put(patient.getId(), patient);

		Prescription prescription = new Prescription();
		prescription.setDescription("prescription 223");
		prescription.setId(223);
		prescriptions.put(prescription.getId(), prescription);
	}

	public Response addPatient(Patient patient) {
		System.out.println("... invoking add patient name + " + patient.getName());
		patient.setId(++currentId);
		patients.put(patient.getId(), patient);
		return Response.ok(patient).build();
	}

	public Patient getPatient(String id) {
		System.out.println("... invoking get patient name + " + id);

		Patient patient = patients.get(Long.parseLong(id));
		return patient;
	}

	public Response updatePatient(Patient updatedPatient) {
		System.out.println("... invoking update patient name + " + updatedPatient.getName());

		Response response = null;
		long patientId = updatedPatient.getId();
		Patient CurrentPatient = patients.get(patientId);
		if (CurrentPatient != null) {
			patients.put(patientId, updatedPatient);
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();

		}
		return response;
	}

	public Response deletePatients(String id) {
		System.out.println("... invoking delete patient name + " + id);

		Response response = null;
		long patientId = Long.parseLong(id);
		Patient patient = patients.get(patientId);
		if (patient != null) {
			patients.remove(patient.getId());
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();

		}
		return response;
	}

	public Prescription getPrescription(String prescriptionId) {
		System.out.println("... invoking get patient name + " + prescriptionId);

		long getPrescriptionId = Long.parseLong(prescriptionId);
		Prescription prescription = prescriptions.get(getPrescriptionId);
		return prescription;
	}

}
