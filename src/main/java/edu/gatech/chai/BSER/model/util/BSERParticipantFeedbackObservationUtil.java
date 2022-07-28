package edu.gatech.chai.BSER.model.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

public class BSERParticipantFeedbackObservationUtil {

	public static List<CodeableConcept> codes = new ArrayList<CodeableConcept>(Arrays.asList(
			new CodeableConcept().addCoding(new Coding("http://snomed.info/sct","298057009","Number of appointments attended (observable entity)")),
			new CodeableConcept().addCoding(new Coding("http://snomed.info/sct","298058004","Number of appointments missed (observable entity)")),
			));
	
}
