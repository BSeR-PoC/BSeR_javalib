package edu.gatech.chai.BSER.model;

import org.hl7.fhir.r4.model.Identifier;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.USCore.model.USCoreOrganization;

@ResourceDef(name = "Organization", profile = "http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-Organization")
public class BSEROrganization extends USCoreOrganization{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3292925445691732367L;
	public BSEROrganization(){
		super();
	}
	
	public BSEROrganization(Identifier identifier, boolean active, String name) {
		super(identifier, active, name);
	}

	public BSEROrganization(boolean active, String name) {
		super(active, name);
	}
}
