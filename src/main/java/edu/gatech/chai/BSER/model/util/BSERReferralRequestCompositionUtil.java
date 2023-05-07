package edu.gatech.chai.BSER.model.util;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

public class BSERReferralRequestCompositionUtil {

	public static CodeableConcept obesityReferralSupportingInfoSectionCode = new CodeableConcept().addCoding(
			new Coding(CommonUtil.bserCodeSystemUrl, "ORSI", "Obesity Referral Supporting Information"));

	public static CodeableConcept arthritisReferralSupportingInfoSectionCode = new CodeableConcept().addCoding(
			new Coding(CommonUtil.bserCodeSystemUrl, "ARSI", "Arthritis Referral Supporting Information"));

	public static CodeableConcept hypertensionReferralSupportingInfoSectionCode = new CodeableConcept().addCoding(
			new Coding(CommonUtil.bserCodeSystemUrl, "HRSI", "Hypertension Referral Supporting Information"));

	public static CodeableConcept earlyChildhoodNutritionReferralSupportingInfoSectionCode = new CodeableConcept().addCoding(
			new Coding(CommonUtil.bserCodeSystemUrl, "ECNRSI", "Early Childhood Nutrition Referral Supporting Information"));

	public static CodeableConcept diabetesPreventionReferralSupportingInfoSectionCode = new CodeableConcept().addCoding(
			new Coding(CommonUtil.bserCodeSystemUrl, "DPRSI", "Diabetes Prevention Referral Supporting Information"));

	public static CodeableConcept tobaccoUseCessationReferralSupportingInfoSectionCode = new CodeableConcept().addCoding(
			new Coding(CommonUtil.bserCodeSystemUrl, "TUCRSI", "Tobacco Use Cessation Referral Supporting Information"));

}
