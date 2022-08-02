package edu.gatech.chai.BSER.model;

import java.util.Date;

import org.hl7.fhir.r4.model.CodeType;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.Task;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.BSER.model.util.BSERReferralTaskUtil;
import edu.gatech.chai.BSER.model.util.CommonUtil;

@ResourceDef(name = "Task", profile = "http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ReferralTask")
public class BSERReferralTask extends Task{
	public BSERReferralTask(String referralInitatorIdentifier,
			String referralRecipientIdentifier, Reference organization,
			TaskStatus status, CodeableConcept businessStatus,
			Reference serviceRequest, Date authoredOn,
			Reference referralInitiatorReference,
			Reference referralRecipientReference) {
		super();
		commonConstructor(referralInitatorIdentifier,
				referralRecipientIdentifier, organization, status,
				businessStatus, serviceRequest, authoredOn,
				referralInitiatorReference, referralRecipientReference);
	}
	
	private BSERReferralTask commonConstructor(String referralInitatorIdentifier,
			String referralRecipientIdentifier, Reference organization,
			TaskStatus status, CodeableConcept businessStatus,
			Reference serviceRequest, Date authoredOn,
			Reference referralInitiatorReference,
			Reference referralRecipientReference) {
		CommonUtil.isValidReference(serviceRequest, "ServiceRequest");
		CommonUtil.isValidReference(organization, "Organization");
		CommonUtil.isValidReference(referralInitiatorReference,
				"PractitionerRole");
		CommonUtil.isValidReference(referralRecipientReference,
				"PractitionerRole");
		
		Identifier referralIntiatorTypeIdentifier = new Identifier();
		referralIntiatorTypeIdentifier.setType(new CodeableConcept().addCoding(
				new Coding(BSERReferralTaskUtil.taskIdentifierTypesSystemUrl,
						BSERReferralTaskUtil.refferalIntitatorType,"")));
		referralIntiatorTypeIdentifier.setValue(referralInitatorIdentifier);
		referralIntiatorTypeIdentifier.setAssigner(organization);
		
		Identifier referralRecipentTypeIdentifier = new Identifier();
		referralRecipentTypeIdentifier.setType(new CodeableConcept().addCoding(
				new Coding(BSERReferralTaskUtil.taskIdentifierTypesSystemUrl,
						BSERReferralTaskUtil.refferalRecipientType,"")));
		referralRecipentTypeIdentifier.setValue(referralInitatorIdentifier);
		referralRecipentTypeIdentifier.setAssigner(organization);
		
		super.addIdentifier(referralIntiatorTypeIdentifier);
		super.addIdentifier(referralRecipentTypeIdentifier);
		super.setStatus(status);
		super.setBusinessStatus(businessStatus);
		super.setFocus(serviceRequest);
		super.setAuthoredOn(authoredOn);
		super.setRequester(referralInitiatorReference);
		super.setOwner(referralRecipientReference);
		return this;
	}
	
	public BSERReferralTask addOutput(Reference refferalFeedbackDocument) {
		super.addOutput(new TaskOutputComponent()
				.setValue(refferalFeedbackDocument));
		return this;
	}
	
	public BSERReferralTask addOutput(BSERReferralFeedbackDocument refferalFeedbackDocument) {
		Reference reference = new Reference("Bundle/"+refferalFeedbackDocument.getId());
		return this.addOutput(reference);
	}
}