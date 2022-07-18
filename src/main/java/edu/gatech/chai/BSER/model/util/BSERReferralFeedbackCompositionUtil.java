package edu.gatech.chai.BSER.model.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

public class BSERReferralFeedbackCompositionUtil {

	public static CodeableConcept referralFeedbackRequestFeedbackSummarySectionCode = 
			new CodeableConcept().addCoding(
					new Coding(CommonUtil.bserCodeSystemUrl,"RSRFS","CompositionSectionReferralServiceRequestFeedbackSummary"));
	public static CodeableConcept referralFeedbackSupportingInformationSectionCode = 
			new CodeableConcept().addCoding(
					new Coding(CommonUtil.bserCodeSystemUrl,"RSRFSI","CompositionSectionReferralServiceRequestFeedbackSupportingInformation"));
	
}
