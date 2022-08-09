package edu.gatech.chai.BSER.model;

import java.util.Date;

import org.hl7.fhir.r4.model.CodeType;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.ServiceRequest;
import org.hl7.fhir.r4.model.ServiceRequest.ServiceRequestStatus;
import org.hl7.fhir.r4.model.Task;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.BSER.model.util.BSERReferralTaskUtil;
import edu.gatech.chai.BSER.model.util.CommonUtil;

@ResourceDef(name = "ServiceRequest", profile = "http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ReferralServiceRequest")
public class BSERReferralServiceRequest extends ServiceRequest{
	
	private static final long serialVersionUID = -1161543706572844708L;

	public BSERReferralServiceRequest(){
		super();
	}

	public BSERReferralServiceRequest(String referralInitatorIdentifier,
			String referralRecipientIdentifier, Reference organization,
			ServiceRequestStatus status, CodeableConcept code,
			Reference subject, Date occurrence,
			Reference referralInitiatorReference,
			Reference referralRecipientReference,
			Reference supportingInfo) {
		super();
		commonConstructor(referralInitatorIdentifier,
				referralRecipientIdentifier, organization, status, code, subject,
				occurrence, referralInitiatorReference,
				referralRecipientReference, supportingInfo);
	}
	
	private BSERReferralServiceRequest commonConstructor(String referralInitatorIdentifier,
			String referralRecipientIdentifier, Reference organization,
			ServiceRequestStatus status, CodeableConcept code,
			Reference subject, Date occurrence,
			Reference referralInitiatorReference,
			Reference referralRecipientReference,
			Reference supportingInfo) {
		CommonUtil.isValidReference(organization, "Organization");
		CommonUtil.isValidReference(subject, "Patient");
		CommonUtil.isValidReference(referralInitiatorReference,
				"PractitionerRole");
		CommonUtil.isValidReference(referralRecipientReference,
				"PractitionerRole");
		CommonUtil.isValidReference(supportingInfo,
				"Bundle");
		
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
		super.setIntent(ServiceRequestIntent.ORDER);
		super.setCode(code);
		super.setSubject(subject);
		super.setOccurrence(new DateTimeType(occurrence));
		super.setRequester(referralInitiatorReference);
		super.addPerformer(referralRecipientReference);
		super.addSupportingInfo(supportingInfo);
		return this;
	}
	
	
	public BSERReferralServiceRequest addInsurance(BSERCoverage insurance) {
		Reference reference = new Reference("Coverage/"+insurance.getId());
		super.addInsurance(reference);
		return this;
	}
}
