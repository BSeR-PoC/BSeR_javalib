package edu.gatech.chai.BSER.model.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

public class BSERReferralActivityStatusUtil {

	public static CodeableConcept code = 
			new CodeableConcept().addCoding(
					new Coding("http://snomed.info/sct","385641008","Action status"));
}
