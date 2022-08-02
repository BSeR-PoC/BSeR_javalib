package edu.gatech.chai.BSER.context;

import java.util.HashMap;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.dstu2.resource.MessageHeader;
import edu.gatech.chai.BSER.model.BSERArthritusFeedbackObservation;
import edu.gatech.chai.BSER.model.BSERArthritusReferralFeedbackSupportingInfo;
import edu.gatech.chai.BSER.model.BSERConsent;
import edu.gatech.chai.BSER.model.BSERCoverage;
import edu.gatech.chai.BSER.model.BSERDiabetesPreventionReferralFeedbackSupportingInformation;
import edu.gatech.chai.BSER.model.BSEREducationLevel;
import edu.gatech.chai.BSER.model.BSERHA1CObservation;
import edu.gatech.chai.BSER.model.BSEROrganization;
import edu.gatech.chai.BSER.model.BSERPractitioner;
import edu.gatech.chai.BSER.model.BSERReferralFeedbackComposition;
import edu.gatech.chai.BSER.model.BSERReferralFeedbackDocument;
import edu.gatech.chai.BSER.model.BSERReferralInitiatorPractitionerRole;
import edu.gatech.chai.BSER.model.BSERReferralMessageBundle;
import edu.gatech.chai.BSER.model.BSERReferralMessageHeader;
import edu.gatech.chai.BSER.model.BSERReferralRecipientPractitionerRole;
import edu.gatech.chai.BSER.model.BSERReferralRequestDocumentBundle;
import edu.gatech.chai.BSER.model.BSERReferralServiceRequest;
import edu.gatech.chai.BSER.model.BSERReferralTask;
import edu.gatech.chai.BSER.model.BSERServiceDeliveryLocation;
import edu.gatech.chai.BSER.model.ODHEmploymentStatus;
import edu.gatech.chai.USCore.context.USCoreContext;

public class BSERFhirContext extends FhirContext{
	
	public BSERFhirContext() {
		this.getRestfulClientFactory();
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ArthritusFeedbackObservation", BSERArthritusFeedbackObservation.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ArthritusFeedbackSupportingInfo", BSERArthritusReferralFeedbackSupportingInfo.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-Consent", BSERConsent.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-Coverage", BSERCoverage.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-DiabetesPreventionReferralFeedbackSupportingInformation", BSERDiabetesPreventionReferralFeedbackSupportingInformation.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-DiabetesPreventionReferralFeedbackSupportingInformation", BSERDiabetesPreventionReferralFeedbackSupportingInformation.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-EducationLevel", BSEREducationLevel.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-HA1CObservation", BSERHA1CObservation.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-Organization", BSEROrganization.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-Practitioner", BSERPractitioner.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ReferralFeedbackComposition", BSERReferralFeedbackComposition.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ReferralFeedbackDocument", BSERReferralFeedbackDocument.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ReferralInitiatorPractitionerRole", BSERReferralInitiatorPractitionerRole.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ReferralMessageBundle", BSERReferralMessageBundle.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ReferralMessageHeader", BSERReferralMessageHeader.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ReferralRecipientPractitionerRole", BSERReferralRecipientPractitionerRole.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ReferralRequestDocumentBundle", BSERReferralRequestDocumentBundle.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ReferralServiceRequest", BSERReferralServiceRequest.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ReferralTask", BSERReferralTask.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ServiceDeliveryLocation", BSERServiceDeliveryLocation.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/odh/StructureDefinition/odh-EmploymentStatus", ODHEmploymentStatus.class);
	}
}
