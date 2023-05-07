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

public class BSEREarlyChildhoodNutritionObservationUtil {

	public static CodeableConcept maternalConcern = 
		new CodeableConcept().addCoding(new Coding("http://snomed.info/sct","270472006", "Maternal concern (finding)"));
	public static CodeableConcept ableToLatch = 
		new CodeableConcept().addCoding(new Coding("http://snomed.info/sct","288988007", "Able to latch on to breast for feeding (finding)"));
	public static CodeableConcept nippleShield = 
		new CodeableConcept().addCoding(new Coding("http://snomed.info/sct","335389008", "Nipple shield (physical object)"));

}
