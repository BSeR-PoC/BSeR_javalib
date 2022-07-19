package edu.gatech.chai.BSER.model.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

public class BSEREducationLevelUtil {

	public static CodeableConcept code = 
			new CodeableConcept().addCoding(
					new Coding("http://loinc.org","80913-7","Highest level of education [US Standard Certificate of Death]"));
}
