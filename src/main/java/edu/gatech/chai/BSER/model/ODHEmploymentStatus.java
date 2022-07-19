package edu.gatech.chai.BSER.model;

import org.hl7.fhir.r4.model.Observation;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

/**
 * 
 * NOTE: Leaving a foreign resource in the BSER IG for now for ease of use
 *
 */

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/odh/StructureDefinition/odh-EmploymentStatus")
public class ODHEmploymentStatus extends Observation{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4010359680028283864L;

}
