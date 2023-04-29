package edu.gatech.chai.BSER.model.util;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

public class BSERReferralFeedbackCompositionUtil {

	public static CodeableConcept referralFeedbackRequestFeedbackSummarySectionCode = 
		new CodeableConcept().addCoding(new Coding(CommonUtil.bserCodeSystemUrl, "RSRFS", null));
	public static CodeableConcept obesityReferralFeedbackSupportingInformationSectionCode = 
		new CodeableConcept().addCoding(new Coding(CommonUtil.bserCodeSystemUrl,"ORFSI","Obesity Referral Feedback Supporting Information"));
	public static CodeableConcept arthritisReferralFeedbackSupportingInformationSectionCode = 
		new CodeableConcept().addCoding(new Coding(CommonUtil.bserCodeSystemUrl,"ARFSI","Arthritis Referral Feedback Supporting Information"));
	public static CodeableConcept hypertensionReferralFeedbackSupportingInformationSectionCode = 
		new CodeableConcept().addCoding(new Coding(CommonUtil.bserCodeSystemUrl,"HRFSI","Hypertension Referral Feedback Supporting Information"));
	public static CodeableConcept earlyChildhoodNutritionReferralFeedbackSupportingInformationSectionCode = 
		new CodeableConcept().addCoding(new Coding(CommonUtil.bserCodeSystemUrl,"ECNRFSI","Early Childhood Nutrition Referral Feedback Supporting Information"));
	public static CodeableConcept diabetesPreventionReferralFeedbackSupportingInformationSectionCode = 
		new CodeableConcept().addCoding(new Coding(CommonUtil.bserCodeSystemUrl,"DPRFSI","Diabetes Prevention Referral Feedback Supporting Information"));
	public static CodeableConcept tobaccoUseCessationReferralFeedbackSupportingInformationSectionCode = 
		new CodeableConcept().addCoding(new Coding(CommonUtil.bserCodeSystemUrl,"TUCRFSI","Tobacco Use Cessation Referral Feedback Supporting Information"));

}
