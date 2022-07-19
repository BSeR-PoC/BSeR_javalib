package edu.gatech.chai.BSER.model;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Observation;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.BSER.model.util.BSEREducationLevelUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-EducationLevel")
public class BSEREducationLevel extends Observation{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3521086429728477845L;
	
	public BSEREducationLevel(CodeableConcept value) {
		super.setStatus(ObservationStatus.FINAL);
		super.setCode(BSEREducationLevelUtil.code);
		super.setValue(value);
	}
}