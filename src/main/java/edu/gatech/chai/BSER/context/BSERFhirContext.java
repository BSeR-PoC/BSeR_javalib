package edu.gatech.chai.BSER.context;

import ca.uhn.fhir.context.FhirContext;
import edu.gatech.chai.BSER.model.BSERConsent;
import edu.gatech.chai.BSER.model.BSERCoverage;
import edu.gatech.chai.BSER.model.BSEREducationLevel;
import edu.gatech.chai.BSER.model.BSEROrganization;
import edu.gatech.chai.BSER.model.BSERPractitioner;
import edu.gatech.chai.BSER.model.BSERReferralFeedbackComposition;
import edu.gatech.chai.BSER.model.BSERReferralFeedbackDocument;
import edu.gatech.chai.BSER.model.BSERReferralInitiatorPractitionerRole;
import edu.gatech.chai.BSER.model.BSERReferralRecipientPractitionerRole;
import edu.gatech.chai.BSER.model.BSERReferralRequestDocumentBundle;
import edu.gatech.chai.BSER.model.BSERReferralServiceRequest;
import edu.gatech.chai.BSER.model.BSERReferralTask;
import edu.gatech.chai.BSER.model.BSERServiceDeliveryLocation;
import edu.gatech.chai.BSER.model.ODHEmploymentStatus;

public class BSERFhirContext extends FhirContext{
	
	public BSERFhirContext() {
		this.getRestfulClientFactory();
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-Consent", BSERConsent.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-Coverage", BSERCoverage.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-EducationLevel", BSEREducationLevel.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-Organization", BSEROrganization.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-Practitioner", BSERPractitioner.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ReferralFeedbackComposition", BSERReferralFeedbackComposition.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ReferralFeedbackDocument", BSERReferralFeedbackDocument.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ReferralInitiatorPractitionerRole", BSERReferralInitiatorPractitionerRole.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ReferralRecipientPractitionerRole", BSERReferralRecipientPractitionerRole.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ReferralRequestDocumentBundle", BSERReferralRequestDocumentBundle.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ReferralServiceRequest", BSERReferralServiceRequest.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ReferralTask", BSERReferralTask.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ServiceDeliveryLocation", BSERServiceDeliveryLocation.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/odh/StructureDefinition/odh-EmploymentStatus", ODHEmploymentStatus.class);
	}
}
