package edu.gatech.chai.FHIR.model.util;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

public class CommonUtil {
	public static String ucumSystemUrl = "http://unitsofmeasure.org";
	public static CodeableConcept getVitalSignsCategory() {
		return new CodeableConcept(new Coding("http://terminology.hl7.org/CodeSystem/observation-category", "vital-signs", null));
	}
}
