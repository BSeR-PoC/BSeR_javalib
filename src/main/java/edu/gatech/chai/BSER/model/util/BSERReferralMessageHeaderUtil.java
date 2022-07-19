package edu.gatech.chai.BSER.model.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

public class BSERReferralMessageHeaderUtil {
	public static CodeableConcept eventCodableConcept = new CodeableConcept().addCoding(new Coding("http://terminology.hl7.org/CodeSystem/v2-0003","I12","REF/RRI - Patient referral"));
}
