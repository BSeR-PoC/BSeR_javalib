package edu.gatech.chai.BSER.model;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

@ResourceDef(name = "Bundle", profile = "http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ObesityReferralSupportingInformation")
public class BSERObesityReferralSupportingInformation extends BSERSupportingInfoBundleAbstract {
    public BSERObesityReferralSupportingInformation() {
        super();
    }
}