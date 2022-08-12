package edu.gatech.chai.BSER.model;

import org.hl7.fhir.r4.model.Resource;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

@ResourceDef(name = "Bundle", profile = "http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ArthritisReferralSupportingInformation")
public class BSERArthritusReferralSupportingInformation extends BSERSupportingInfoBundleAbstract {
    public BSERArthritusReferralSupportingInformation() {
        super();
    }

    public BSERArthritusReferralSupportingInformation(Resource entry){
        super();
        super.addEntry(new BundleEntryComponent().setFullUrl(entry.getIdElement().toVersionless().getValue()).setResource(entry));
    }
}