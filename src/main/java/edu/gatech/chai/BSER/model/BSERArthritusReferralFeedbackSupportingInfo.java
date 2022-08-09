package edu.gatech.chai.BSER.model;

import java.util.Date;

import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.StringType;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.BSER.model.util.BSERReferralActivityStatusUtil;

@ResourceDef(name = "Bundle", profile = "http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ArthritisReferralFeedbackSupportingInformation")
public class BSERArthritusReferralFeedbackSupportingInfo extends BSERSupportingInfoBundleAbstract{


	/**
	 * 
	 */
	private static final long serialVersionUID = -4276118205934026310L;

	public BSERArthritusReferralFeedbackSupportingInfo() {
		super();
	}

	public BSERArthritusReferralFeedbackSupportingInfo(BSERArthritusFeedbackObservation	observation) {
		super();
		super.addEntry(new BundleEntryComponent().setFullUrl(observation.getIdElement().toVersionless().getValue()).setResource(observation));
	}
	
}