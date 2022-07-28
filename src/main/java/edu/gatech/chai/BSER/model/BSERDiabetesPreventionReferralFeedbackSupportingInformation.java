package edu.gatech.chai.BSER.model;

import org.hl7.fhir.r4.model.Observation;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

@ResourceDef(name = "Bundle", profile = "tp://hl7.org/fhir/us/bser/StructureDefinition/BSeR-DiabetesPreventionReferralFeedbackSupportingInformation")
public class BSERDiabetesPreventionReferralFeedbackSupportingInformation extends BSERSupportingInfoBundleAbstract{

    public BSERDiabetesPreventionReferralFeedbackSupportingInformation() {
        super();
    }

    public BSERDiabetesPreventionReferralFeedbackSupportingInformation(Observation entry) {
        super.addEntry(new BundleEntryComponent().setResource(entry));
    }
}
