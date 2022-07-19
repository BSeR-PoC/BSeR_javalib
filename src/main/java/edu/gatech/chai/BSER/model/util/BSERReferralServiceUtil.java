package edu.gatech.chai.BSER.model.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

public class BSERReferralServiceUtil {
	public static String taskIdentifierTypesSystemUrl = "http://terminology.hl7.org/CodeSystem/v2-0203";
	public static String refferalIntitatorType = "PLAC";
	public static String refferalRecipientType = "FILL";
	
	public static List<CodeableConcept> CodaebleConceptVS = new ArrayList<CodeableConcept>(Arrays.asList(
			new CodeableConcept().addCoding(new Coding("http://snomed.info/sct","3457005","Patient referral (procedure)")),
			new CodeableConcept().addCoding(new Coding("http://snomed.info/sct","408289007","Refeer to weight management program (procedure)")),
			new CodeableConcept().addCoding(new Coding("http://snomed.info/sct","449861000124107","Referral to tobacco use cessation conseling program (procedure)")),
			new CodeableConcept().addCoding(new Coding("http://snomed.info/sct","453591000124102","Referral for management of hypertension (procedure)")),
			new CodeableConcept().addCoding(new Coding("http://snomed.info/sct","459991000124105","Referral to diabetes prevention program (procedure)"))
			));
}
