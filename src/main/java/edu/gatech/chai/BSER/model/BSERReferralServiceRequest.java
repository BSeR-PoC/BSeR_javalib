package edu.gatech.chai.BSER.model;

import java.util.Date;
import java.util.List;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.PractitionerRole;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.ServiceRequest;

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
			String referralRecipientIdentifier, Reference initiatorOrganization, Reference recipientOrganization,
			ServiceRequestStatus status, CodeableConcept code,
			Reference subject, Date occurrence,
			Reference referralInitiatorReference,
			Reference referralRecipientReference,
			Reference supportingInfo) {
		super();
		commonConstructor(referralInitatorIdentifier,
				referralRecipientIdentifier, initiatorOrganization, recipientOrganization, status, code, subject,
				occurrence, referralInitiatorReference,
				referralRecipientReference, supportingInfo);
	}
	
	private BSERReferralServiceRequest commonConstructor(String referralInitatorIdentifier,
			String referralRecipientIdentifier, Reference initiatorOrganization, Reference recipientOrganization,
			ServiceRequestStatus status, CodeableConcept code,
			Reference subject, Date occurrence,
			Reference referralInitiatorReference,
			Reference referralRecipientReference,
			Reference supportingInfo) {

		if (initiatorOrganization != null)
			CommonUtil.isValidReference(initiatorOrganization, "Organization");
		if (recipientOrganization != null)
			CommonUtil.isValidReference(recipientOrganization, "Organization");

		CommonUtil.isValidReference(subject, "Patient");
		CommonUtil.isValidReference(referralInitiatorReference,
				"PractitionerRole");
		if (referralRecipientReference != null && !referralRecipientReference.isEmpty()) {
			CommonUtil.isValidReference(referralRecipientReference,
				"PractitionerRole");
		}
		CommonUtil.isValidReference(supportingInfo,
				"Bundle");
		
		Identifier referralIntiatorTypeIdentifier = new Identifier();
		referralIntiatorTypeIdentifier.setType(new CodeableConcept().addCoding(
				new Coding(BSERReferralTaskUtil.taskIdentifierTypesSystemUrl,
						BSERReferralTaskUtil.referralIntitatorType,"")));
		referralIntiatorTypeIdentifier.setValue(referralInitatorIdentifier);
		referralIntiatorTypeIdentifier.setAssigner(initiatorOrganization);
		
		if (referralRecipientReference != null && !referralRecipientReference.isEmpty()) {
			Identifier referralRecipentTypeIdentifier = new Identifier();
			referralRecipentTypeIdentifier.setType(new CodeableConcept().addCoding(
				new Coding(BSERReferralTaskUtil.taskIdentifierTypesSystemUrl,
					BSERReferralTaskUtil.referralRecipientType,"")));
			referralRecipentTypeIdentifier.setValue(referralRecipientIdentifier);
			referralRecipentTypeIdentifier.setAssigner(recipientOrganization);
			super.addIdentifier(referralRecipentTypeIdentifier);
		}
		
		super.addIdentifier(referralIntiatorTypeIdentifier);
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

	// TODO: Need to review IG. The ServiceRequest Identifiers do not seem to be PractitionerRoles. 
	//       They seem to be something that identifies the service request, which is not necessarily Practitioners.
	//
	// public List<Identifier> addIdentifiers(PractitionerRole initiator, PractitionerRole recipient) {
	// 	Identifier referralIntiatorTypeIdentifier = new Identifier();
	// 	referralIntiatorTypeIdentifier.setType(new CodeableConcept().addCoding(
	// 			new Coding(BSERReferralTaskUtil.taskIdentifierTypesSystemUrl,
	// 					BSERReferralTaskUtil.referralIntitatorType,"")));
		
	// 	Identifier initiatorIdentifier = initiator.getIdentifierFirstRep();
	// 	if (initiatorIdentifier != null && !initiatorIdentifier.isEmpty()) {
	// 		referralIntiatorTypeIdentifier.setValue(initiatorIdentifier.getValue());
	// 		referralIntiatorTypeIdentifier.setSystem(initiatorIdentifier.getSystem());
	// 	}
	// 	referralIntiatorTypeIdentifier.setAssigner(initiator.getOrganization());
		
	// 	Identifier referralRecipentTypeIdentifier = new Identifier();
	// 	referralRecipentTypeIdentifier.setType(new CodeableConcept().addCoding(
	// 			new Coding(BSERReferralTaskUtil.taskIdentifierTypesSystemUrl,
	// 					BSERReferralTaskUtil.referralRecipientType,"")));

	// 	Identifier recipientIdentifier = recipient.getIdentifierFirstRep();
	// 	if (recipientIdentifier != null && !recipientIdentifier.isEmpty()) {
	// 		referralRecipentTypeIdentifier.setValue(recipientIdentifier.getValue());
	// 		referralRecipentTypeIdentifier.setSystem(recipientIdentifier.getSystem());
	// 	}
	// 	referralRecipentTypeIdentifier.setAssigner(recipient.getOrganization());

	// 	super.addIdentifier(initiatorIdentifier);
	// 	super.addIdentifier(recipientIdentifier);

	// 	return this.getIdentifier();
	// }

	public List<Identifier> setInitiatorIdentifier(String system, String value, Reference assigner) {
		CodeableConcept initiatorIdentifierType = CommonUtil.initiatorIdentifierType();

		for (Identifier identifier : this.getIdentifier()) {
			CodeableConcept type = identifier.getType();
			if (type.equalsDeep(initiatorIdentifierType)) {
				identifier.setSystem(system);
				identifier.setValue(value);
				identifier.setAssigner(assigner);
				return this.getIdentifier();
			}			
		}

		// If we get here, it means we do not have the initiator identifier.
		Identifier identifier = new Identifier();
		identifier.setType(initiatorIdentifierType);
		identifier.setSystem(system);
		identifier.setValue(value);
		identifier.setAssigner(assigner);
		this.addIdentifier(identifier);

		return this.getIdentifier();
	}

	public List<Identifier> setRecipientIdentifier(String system, String value, Reference assigner) {
		CodeableConcept recipientIdentifierType = CommonUtil.recipientIdentifierType();

		for (Identifier identifier : this.getIdentifier()) {
			CodeableConcept type = identifier.getType();
			if (type.equalsDeep(recipientIdentifierType)) {
				identifier.setSystem(system);
				identifier.setValue(value);
				identifier.setAssigner(assigner);
				return this.getIdentifier();
			}			
		}

		// If we get here, it means we do not have the initiator identifier.
		Identifier identifier = new Identifier();
		identifier.setType(recipientIdentifierType);
		identifier.setSystem(system);
		identifier.setValue(value);
		identifier.setAssigner(assigner);
		this.addIdentifier(identifier);

		return this.getIdentifier();
	}
}
