package edu.gatech.chai.BSER.model;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

@ResourceDef(name = "Bundle", profile = "http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ChildhoodNutritionReferralFeedbackSupportingInformation")
public class BSEREarlyChildhoodNutritionReferralFeedbackSupportingInformation extends BSERSupportingInfoBundleAbstract{

    public BSEREarlyChildhoodNutritionReferralFeedbackSupportingInformation() {
        super();
    }
}
