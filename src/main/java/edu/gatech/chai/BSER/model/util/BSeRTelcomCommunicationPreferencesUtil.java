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

public class BSeRTelcomCommunicationPreferencesUtil {

	public static CodeableConcept bestDay = 
		new CodeableConcept().addCoding(new Coding(CommonUtil.bserCodeSystemUrl,"BDTC", "Best Day To Call"));

	public static CodeableConcept bestTime = 
		new CodeableConcept().addCoding(new Coding(CommonUtil.bserCodeSystemUrl,"BTTC", "Best Time To Call"));

	public static CodeableConcept leaveMessageIndicator = 
		new CodeableConcept().addCoding(new Coding(CommonUtil.bserCodeSystemUrl,"LMI", "Leave Message Indicator"));
}
