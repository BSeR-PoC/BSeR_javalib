package edu.gatech.chai.BSER.model;

import org.hl7.fhir.r4.model.Observation;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

@ResourceDef(name = "Bundle", profile = "http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-DiabetesPreventionReferralSupportingInformation")
public class BSERDiabetesPreventionReferralSupportingInformation extends BSERSupportingInfoBundleAbstract {
    
    public BSERDiabetesPreventionReferralSupportingInformation() {
        super();
    }

    public BSERDiabetesPreventionReferralSupportingInformation(Observation observation) {
        super.addEntry(new BundleEntryComponent().setFullUrl(observation.getIdElement().toVersionless().getValue()).setResource(observation));
    }
}
