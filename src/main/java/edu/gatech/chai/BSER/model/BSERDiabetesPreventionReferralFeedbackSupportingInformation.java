package edu.gatech.chai.BSER.model;

import org.hl7.fhir.r4.model.Observation;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

@ResourceDef(name = "Bundle", profile = "http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-DiabetesPreventionReferralFeedbackSupportingInformation")
public class BSERDiabetesPreventionReferralFeedbackSupportingInformation extends BSERSupportingInfoBundleAbstract{

    public BSERDiabetesPreventionReferralFeedbackSupportingInformation() {
        super();
    }

    public BSERDiabetesPreventionReferralFeedbackSupportingInformation(Observation observation) {
        super.addEntry(new BundleEntryComponent().setFullUrl(observation.getIdElement().toVersionless().getValue()).setResource(observation));
    }
}
