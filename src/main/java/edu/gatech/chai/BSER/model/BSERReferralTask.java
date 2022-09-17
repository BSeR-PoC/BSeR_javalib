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
	
	public BSERReferralTask(String initatorIdentifierSystem, String initatorIdentifierValue,
			String recipientIdentifierSystem, String recipientIdentifierValue, 
			Reference PLACorganization, Reference FILLOrganization,
			TaskStatus status, CodeableConcept businessStatus,
			Reference serviceRequest, Date authoredOn,
			Reference referralInitiatorReference,
			Reference referralRecipientReference) {
		super();
		commonConstructor(initatorIdentifierSystem, initatorIdentifierValue,
			recipientIdentifierSystem, recipientIdentifierValue, PLACorganization, 
			FILLOrganization, status, businessStatus, serviceRequest, authoredOn, 
			referralInitiatorReference, referralRecipientReference);
	}
	
	private BSERReferralTask commonConstructor(String initatorIdentifierSystem,
		String initatorIdentifierValue, String recipientIdentifierSystem, 
		String recipientIdentifierValue, Reference PLACorganization,
			Reference FILLorganization, TaskStatus status, CodeableConcept businessStatus,
			Reference serviceRequest, Date authoredOn,
			Reference referralInitiatorReference,
			Reference referralRecipientReference) {
		CommonUtil.isValidReference(serviceRequest, "ServiceRequest");
		if(PLACorganization != null){
			CommonUtil.isValidReference(PLACorganization, "Organization");
		}
		CommonUtil.isValidReference(FILLorganization, "Organization");
		CommonUtil.isValidReference(referralInitiatorReference, "PractitionerRole");
		CommonUtil.isValidReference(referralRecipientReference, "PractitionerRole");
		
		Identifier referralIntiatorTypeIdentifier = new Identifier();
		referralIntiatorTypeIdentifier.setType(new CodeableConcept().addCoding(
			new Coding(BSERReferralTaskUtil.taskIdentifierTypesSystemUrl,
					BSERReferralTaskUtil.referralIntitatorType,"")));
		referralIntiatorTypeIdentifier.setSystem(initatorIdentifierSystem);
		referralIntiatorTypeIdentifier.setValue(initatorIdentifierValue);
		referralIntiatorTypeIdentifier.setAssigner(PLACorganization);
		super.addIdentifier(referralIntiatorTypeIdentifier);
	
		//NOTE: FILLOrginzation may not be required, but PLACOrganization is
		Identifier referralRecipientTypeIdentifier = new Identifier();
		referralRecipientTypeIdentifier.setType(new CodeableConcept().addCoding(
			new Coding(BSERReferralTaskUtil.taskIdentifierTypesSystemUrl,
				BSERReferralTaskUtil.referralRecipientType,"")));
		referralRecipientTypeIdentifier.setSystem(recipientIdentifierSystem);
		referralRecipientTypeIdentifier.setValue(recipientIdentifierValue);
		if(FILLorganization != null){
			referralRecipientTypeIdentifier.setAssigner(FILLorganization);
		}
		super.addIdentifier(referralRecipientTypeIdentifier);

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