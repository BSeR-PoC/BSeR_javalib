/*
 * Filename: /Users/mc142/Documents/workspace/BSeR/BSeR_javalib/src/main/java/edu/gatech/chai/BSER/model/util/BSEREducationLevelUtil copy.java
 * Path: /Users/mc142/Documents/workspace/BSeR/BSeR_javalib/src/main/java/edu/gatech/chai/BSER/model/util
 * Created Date: Thursday, April 27th 2023, 12:17:49 pm
 * Author: Myung Choi
 * 
 * Copyright (c) 2023 GTRI - Health Emerging and Advanced Technologies (HEAT)
 */
package edu.gatech.chai.BSER.model.util;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

public class BSERNRTAuthorizationStatusUtil {

	public static CodeableConcept nicotinReplTherapy = 
		new CodeableConcept().addCoding(new Coding("http://snomed.info/sct","313396002", "Nicotine replacement therapy (situation)"));

	public static CodeableConcept approved = 
		new CodeableConcept().addCoding(new Coding("http://terminology.hl7.org/CodeSystem/v2-0149","AP", "Approved"));

	public static CodeableConcept denied = 
		new CodeableConcept().addCoding(new Coding("http://terminology.hl7.org/CodeSystem/v2-0149","DE", "Denied"));

	public static CodeableConcept pending = 
		new CodeableConcept().addCoding(new Coding("http://terminology.hl7.org/CodeSystem/v2-0149","PE", "Pending"));

}
