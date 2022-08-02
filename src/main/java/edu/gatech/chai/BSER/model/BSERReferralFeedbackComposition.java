package edu.gatech.chai.BSER.model;

import java.util.Date;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Composition;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.Task.TaskStatus;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.BSER.model.util.BSERReferralFeedbackCompositionUtil;
import edu.gatech.chai.BSER.model.util.BSERReferralTaskUtil;
import edu.gatech.chai.BSER.model.util.CommonUtil;

@ResourceDef(name = "Composition", profile = "http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ReferralFeedbackComposition")
public class BSERReferralFeedbackComposition extends Composition{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5596418485277827438L;
	
	public BSERReferralFeedbackComposition(Reference subject,
			Date date, Reference author, String title, Reference serviceRequest,
			Reference activityStatus, Reference supportingInfo) {
		super();
		commonConstructor(subject,date,author,title,serviceRequest,activityStatus,supportingInfo);
	}
	
	private BSERReferralFeedbackComposition commonConstructor(Reference subject,
			Date date, Reference author, String title, Reference serviceRequest,
			Reference activityStatus, Reference supportingInfo) {
		
		CommonUtil.isValidReference(subject, "Patient");
		CommonUtil.isValidReference(author, "PractitionerRole");
		CommonUtil.isValidReference(serviceRequest, "ServiceRequest");
		CommonUtil.isValidReference(activityStatus, "Observation");
		CommonUtil.isValidReference(supportingInfo, "Bundle");

		SectionComponent summarySection = new SectionComponent();
		summarySection.setCode(BSERReferralFeedbackCompositionUtil.referralFeedbackRequestFeedbackSummarySectionCode);
		summarySection.setFocus(serviceRequest);
		summarySection.addEntry(activityStatus);
		
		SectionComponent feedbackSupportInfoSection = new SectionComponent();
		feedbackSupportInfoSection.setCode(BSERReferralFeedbackCompositionUtil.referralFeedbackSupportingInformationSectionCode);
		feedbackSupportInfoSection.addEntry(supportingInfo);
		
		super.addSection(summarySection);
		super.addSection(feedbackSupportInfoSection);
		return this;
	}
	
	public BSERReferralFeedbackComposition addSupportingInfo(Reference reference) {
		CommonUtil.findSectionWithCode(this, BSERReferralFeedbackCompositionUtil.referralFeedbackSupportingInformationSectionCode)
			.addEntry(reference);
		return this;
	}
	
	public BSERReferralFeedbackComposition addSupportingInfo(BSERSupportingInfoBundleAbstract bundle) {
		Reference reference = new Reference("Bundle/"+bundle.getId());
		return addSupportingInfo(reference);
	}
}
