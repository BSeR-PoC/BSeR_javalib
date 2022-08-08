package edu.gatech.chai.BSER.model;

import java.util.Date;

import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Composition;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.BSER.model.util.BSERReferralRequestCompositionUtil;
import edu.gatech.chai.BSER.model.util.CommonUtil;

@ResourceDef(name = "Composition", profile = "http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ReferralRequestComposition")
public class BSERReferralRequestComposition extends Composition{


	/**
	 * 
	 */
	private static final long serialVersionUID = -7888507606333842386L;

	public BSERReferralRequestComposition(CompositionStatus status,
			CodeableConcept type,Reference subject, Date dateTime,
			Reference author, String title, Reference supportingInfo) {
		CommonUtil.isValidReference(subject, "Patient");
		CommonUtil.isValidReference(author, "PractitionerRole");
		CommonUtil.isValidReference(supportingInfo, "Bundle");
		super.setStatus(status);
		super.setType(type);
		super.setSubject(subject);
		super.setDate(dateTime);
		super.addAuthor(author);
		super.setTitle(title);
		SectionComponent supportingIntoSection = new SectionComponent();
		supportingIntoSection.setCode(BSERReferralRequestCompositionUtil.referralFeedbackRequestFeedbackSummarySectionCode);
		supportingIntoSection.addEntry(supportingInfo);
		super.addSection(supportingIntoSection);
	}
	
	public BSERReferralRequestComposition addSupportingInfo(Reference supportingInfo) {
		CommonUtil.findSectionWithCode(this,BSERReferralRequestCompositionUtil.referralFeedbackRequestFeedbackSummarySectionCode)
			.addEntry(supportingInfo);
		return this;
	}
	
	public BSERReferralRequestComposition addSupportingInfo(BSERSupportingInfoBundleAbstract supportingInfo) {
		Reference reference = new Reference("Bundle/"+supportingInfo.getId());
		return addSupportingInfo(reference);
	}
}
