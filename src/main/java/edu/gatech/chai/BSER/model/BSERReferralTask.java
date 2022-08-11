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

	private static final long serialVersionUID = -1161543706572844709L;

	public BSERReferralTask() {
		super();
	}
	
	public BSERReferralTask(String referralInitatorIdentifier,
			String referralRecipientIdentifier, Reference PLACorganization, Reference FILLOrganization,
			TaskStatus status, CodeableConcept businessStatus,
			Reference serviceRequest, Date authoredOn,
			Reference referralInitiatorReference,
			Reference referralRecipientReference) {
		super();
		commonConstructor(referralInitatorIdentifier,
				referralRecipientIdentifier, PLACorganization, FILLOrganization,
				status, businessStatus, serviceRequest, authoredOn,
				referralInitiatorReference, referralRecipientReference);
	}
	
	private BSERReferralTask commonConstructor(String referralInitatorIdentifier,
			String referralRecipientIdentifier, Reference PLACorganization,
			Reference FILLorganization, TaskStatus status, CodeableConcept businessStatus,
			Reference serviceRequest, Date authoredOn,
			Reference referralInitiatorReference,
			Reference referralRecipientReference) {
		CommonUtil.isValidReference(serviceRequest, "ServiceRequest");
		CommonUtil.isValidReference(PLACorganization, "Organization");
		if(FILLorganization != null){
			CommonUtil.isValidReference(FILLorganization, "Organization");
		}
		CommonUtil.isValidReference(referralInitiatorReference,
				"PractitionerRole");
		CommonUtil.isValidReference(referralRecipientReference,
				"PractitionerRole");
		
		Identifier referralRecipentTypeIdentifier = new Identifier();
		referralRecipentTypeIdentifier.setType(new CodeableConcept().addCoding(
				new Coding(BSERReferralTaskUtil.taskIdentifierTypesSystemUrl,
					BSERReferralTaskUtil.refferalRecipientType,"")));
		referralRecipentTypeIdentifier.setValue(referralInitatorIdentifier);
		referralRecipentTypeIdentifier.setAssigner(PLACorganization);
		super.addIdentifier(referralRecipentTypeIdentifier);

		//NOTE: FILLOrginzation may not be required, but PLACOrganization is
		if(FILLorganization != null){
			Identifier referralIntiatorTypeIdentifier = new Identifier();
			referralIntiatorTypeIdentifier.setType(new CodeableConcept().addCoding(
					new Coding(BSERReferralTaskUtil.taskIdentifierTypesSystemUrl,
							BSERReferralTaskUtil.refferalIntitatorType,"")));
			referralIntiatorTypeIdentifier.setValue(referralInitatorIdentifier);
			referralIntiatorTypeIdentifier.setAssigner(FILLorganization);
			super.addIdentifier(referralIntiatorTypeIdentifier);
		}

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