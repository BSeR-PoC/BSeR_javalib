package edu.gatech.chai.FHIR.model.util;

import java.util.Arrays;
import java.util.List;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

public class BodyHeightUtil {
	public static CodeableConcept code = 
			new CodeableConcept().addCoding(
					new Coding("http://loinc.org","8302-2","Body height"));
	public static List<String> valueCodes = 
			Arrays.asList(new String[]{"cm", "[in_i]"});
}
