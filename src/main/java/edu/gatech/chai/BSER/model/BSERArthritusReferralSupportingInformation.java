package edu.gatech.chai.BSER.model;

import org.hl7.fhir.r4.model.Resource;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

@ResourceDef(name = "Bundle", profile = "http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ArthritisReferralFeedbackSupportingInformation")
public class BSERArthritusReferralSupportingInformation extends BSERSupportingInfoBundleAbstract {
    public BSERArthritusReferralSupportingInformation() {
        super();
    }

    public BSERArthritusReferralSupportingInformation(Resource entry){
        super();
        super.addEntry(new BundleEntryComponent().setResource(entry));
    }
}