/*
 * Filename: /Users/mc142/Documents/workspace/BSeR/BSeR_javalib/src/main/java/edu/gatech/chai/BSER/model/BSEROrganization copy.java
 * Path: /Users/mc142/Documents/workspace/BSeR/BSeR_javalib/src/main/java/edu/gatech/chai/BSER/model
 * Created Date: Thursday, April 27th 2023, 2:48:42 am
 * Author: Myung Choi
 * 
 * Copyright (c) 2023 GTRI - Health Emerging and Advanced Technologies (HEAT)
 */
package edu.gatech.chai.BSER.model;

import org.hl7.fhir.r4.model.Enumeration;
import org.hl7.fhir.r4.model.MedicationStatement;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.Type;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

@ResourceDef(name = "MedicationStatment", profile = "http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-MedicationStatement")
public class BSERMedicationStatement extends MedicationStatement{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3292925445691732367L;
	public BSERMedicationStatement(){
		super();
	}
	
	public BSERMedicationStatement(Enumeration<MedicationStatementStatus> status, Type medication, Reference subject) {
		super(status, medication, subject);
	}
}
