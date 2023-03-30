package edu.gatech.chai.BSER.model;

import org.hl7.fhir.r4.model.Bundle;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

@ResourceDef(name = "Bundle", profile = "http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ReferralRequestDocumentBundle")
public class BSERReferralRequestDocumentBundle extends Bundle{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1161543706572844707L;

	public BSERReferralRequestDocumentBundle() {
		super();
		this.setType(BundleType.DOCUMENT);
	}

	public BSERReferralRequestDocumentBundle(BSERReferralRequestComposition composition) {
		super();
		this.setType(BundleType.DOCUMENT);
		this.addEntry(new BundleEntryComponent().setFullUrl(composition.getIdElement().toVersionless().getValue()).setResource(composition));
	}
}
