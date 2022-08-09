package edu.gatech.chai.BSER.model;

import org.hl7.fhir.r4.model.Bundle;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

@ResourceDef(name = "Bundle", profile = "http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ReferralFeedbackDocumentBundle")
public class BSERReferralFeedbackDocument extends Bundle{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5596418485277827438L;
	
	public BSERReferralFeedbackDocument() {
		super();
	}
	
	public BSERReferralFeedbackDocument(BSERReferralFeedbackComposition composition) {
		super();
		this.addEntry(new BundleEntryComponent().setFullUrl(composition.getIdElement().toVersionless().getValue()).setResource(composition));
	}
}
