package edu.gatech.chai.BSER.model.util;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

public class BSEREducationLevelUtil {

	public static CodeableConcept code = 
		new CodeableConcept().addCoding(new Coding("http://loinc.org","82589-3", null));
}
