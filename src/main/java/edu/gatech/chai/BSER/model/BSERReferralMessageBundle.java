package edu.gatech.chai.BSER.model;

import org.hl7.fhir.r4.model.Bundle;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

@ResourceDef(name = "Bundle", profile = "http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ReferralMessageBundle")
public class BSERReferralMessageBundle extends Bundle{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1239582961165743311L;

	public BSERReferralMessageBundle(BSERReferralMessageHeader header) {
		super();
		super.setType(BundleType.MESSAGE);
		super.addEntry(new BundleEntryComponent().setResource(header));
	}
	
	public BSERReferralMessageBundle addEmploymentStatus(ODHEmploymentStatus employmentStatus) {
		super.addEntry(new BundleEntryComponent().setResource(employmentStatus));
		return this;
		
	}
	
	public BSERReferralMessageBundle addPatientConsent(BSERConsent consent) {
		super.addEntry(new BundleEntryComponent().setResource(consent));
		return this;
	}
	
	public BSERReferralMessageBundle addEducationLevel(BSEREducationLevel educationLevel) {
		super.addEntry(new BundleEntryComponent().setResource(educationLevel));
		return this;
	}
}
