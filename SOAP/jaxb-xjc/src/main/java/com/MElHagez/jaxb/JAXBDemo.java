package com.MElHagez.jaxb;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.bharatthippireddy.patient.Patient;

/**
 * @author Created by M_ElHagez on Mar 18, 2021 
 */
public class JAXBDemo {

	public static void main(String[] args) {

		
		try {
//			1- context + marchal
			JAXBContext context = JAXBContext.newInstance(Patient.class);
			Marshaller marshaller = context.createMarshaller();
//			2- object
			Patient patient = new Patient();
			patient.setId(123);
			patient.setName("mostafa");
			
			StringWriter writer = new StringWriter();
			marshaller.marshal(patient, writer);
			System.out.println(writer.toString());
//			3- unmarchaller
			Unmarshaller unmarshaller = context.createUnmarshaller();
			Patient patientResult = (Patient) unmarshaller.unmarshal(new StringReader(writer.toString()));
			System.out.println(patientResult.getName());

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
