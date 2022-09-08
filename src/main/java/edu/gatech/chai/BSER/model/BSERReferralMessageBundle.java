package edu.gatech.chai.BSER.model;

import org.hl7.fhir.r4.model.Bundle;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

@ResourceDef(name = "Bundle", profile = "http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ReferralMessageBundle")
public class BSERReferralMessageBundle extends Bundle{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1239582961165743311L;

	public BSERReferralMessageBundle() {
		super();
	}

	public BSERReferralMessageBundle(BSERReferralMessageHeader header) {
		super();
		this.setType(BundleType.MESSAGE);
		this.addEntry(new BundleEntryComponent().setFullUrl(header.getIdElement().getValue()).setResource(header));
	}
	
	public BSERReferralMessageBundle addEmploymentStatus(ODHEmploymentStatus employmentStatus) {
		this.addEntry(new BundleEntryComponent().setFullUrl(employmentStatus.getIdElement().getValue()).setResource(employmentStatus));
		return this;
		
	}
	
	public BSERReferralMessageBundle addPatientConsent(BSERConsent consent) {
		this.addEntry(new BundleEntryComponent().setFullUrl(consent.getIdElement().getValue()).setResource(consent));
		return this;
	}
	
	public BSERReferralMessageBundle addEducationLevel(BSEREducationLevel educationLevel) {
		this.addEntry(new BundleEntryComponent().setFullUrl(educationLevel.getIdElement().getValue()).setResource(educationLevel));
		return this;
	}
}
