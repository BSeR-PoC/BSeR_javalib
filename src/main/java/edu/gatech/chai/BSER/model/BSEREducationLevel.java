package edu.gatech.chai.BSER.model;

import org.hl7.fhir.r4.model.CodeableConcept;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.BSER.model.util.BSEREducationLevelUtil;
import edu.gatech.chai.USCore.model.USCoreObservationSocialHistory;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-EducationLevel")
public class BSEREducationLevel extends USCoreObservationSocialHistory {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3521086429728477845L;
	
	public BSEREducationLevel() {
		super();

		this.setStatus(ObservationStatus.FINAL);
		this.setCode(BSEREducationLevelUtil.code);		
	}
	
	public BSEREducationLevel(CodeableConcept value) {
		super.setStatus(ObservationStatus.FINAL);
		super.setCode(BSEREducationLevelUtil.code);
		super.setValue(value);
	}
}