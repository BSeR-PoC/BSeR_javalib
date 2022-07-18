package edu.gatech.chai.BSER.model.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

public class BSERReferralTaskUtil {
	public static String taskIdentifierTypesSystemUrl = "http://terminology.hl7.org/CodeSystem/v2-0203";
	public static String refferalIntitatorType = "PLAC";
	public static String refferalRecipientType = "FILL";
	
	public static List<CodeableConcept> businessStatusVS = new ArrayList<CodeableConcept>(Arrays.asList(
			new CodeableConcept().addCoding(new Coding("http://hl7.org/fhir/us/bser/CodeSystem/TaskBusinessStatusCS","2.0","Service Request Created")),
			new CodeableConcept().addCoding(new Coding("http://hl7.org/fhir/us/bser/CodeSystem/TaskBusinessStatusCS","3.0","Service Accepted")),
			new CodeableConcept().addCoding(new Coding("http://hl7.org/fhir/us/bser/CodeSystem/TaskBusinessStatusCS","4.0","Service Request Denied")),
			new CodeableConcept().addCoding(new Coding("http://hl7.org/fhir/us/bser/CodeSystem/TaskBusinessStatusCS","5.4","Service Request Cancellation Requested")),
			new CodeableConcept().addCoding(new Coding("http://hl7.org/fhir/us/bser/CodeSystem/TaskBusinessStatusCS","5.x","Service Request Event State Changed")),
			new CodeableConcept().addCoding(new Coding("http://hl7.org/fhir/us/bser/CodeSystem/TaskBusinessStatusCS","6.0","Service Request Forfillment Cancelled")),
			new CodeableConcept().addCoding(new Coding("http://hl7.org/fhir/us/bser/CodeSystem/TaskBusinessStatusCS","7.0","Service Request Forfillment Completed"))
			));
}
