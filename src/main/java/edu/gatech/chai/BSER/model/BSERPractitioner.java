package edu.gatech.chai.BSER.model;

import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.Identifier;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.USCore.model.USCorePractitioner;

@ResourceDef(name = "Practitioner", profile = "http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-Practitioner")
public class BSERPractitioner extends USCorePractitioner{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2550907218824359394L;
	
	public BSERPractitioner(){
		super();
	}

	public BSERPractitioner(Identifier identifier, HumanName name) {
		super(identifier, name);
	}
	
}
