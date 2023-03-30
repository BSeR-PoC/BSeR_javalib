package edu.gatech.chai.BSER.context;

import java.util.HashMap;

import ca.uhn.fhir.context.FhirContext;
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
import edu.gatech.chai.USCore.model.USCoreAllergyIntolerance;
import edu.gatech.chai.USCore.model.USCoreCarePlan;
import edu.gatech.chai.USCore.model.USCoreCareTeam;
import edu.gatech.chai.USCore.model.USCoreCondition;
import edu.gatech.chai.USCore.model.USCoreDiagnosticReportLab;
import edu.gatech.chai.USCore.model.USCoreDiagnosticReportNote;
import edu.gatech.chai.USCore.model.USCoreOrganization;
import edu.gatech.chai.USCore.model.USCorePractitioner;
import edu.gatech.chai.USCore.model.USCoreVitalSigns;

public class BSERFhirContext extends FhirContext{
	
	public BSERFhirContext() {
		//BSER IG
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ArthritusFeedbackObservation", BSERArthritusFeedbackObservation.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ArthritusFeedbackSupportingInfo", BSERArthritusReferralFeedbackSupportingInfo.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-Consent", BSERConsent.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-Coverage", BSERCoverage.class);
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
		//ODH IG
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/odh/StructureDefinition/odh-EmploymentStatus", ODHEmploymentStatus.class);
		//USCore IG
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/core/StructureDefinition/us-core-allergyintolerance", USCoreAllergyIntolerance.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/core/StructureDefinition/us-core-careplan", USCoreCarePlan.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/core/StructureDefinition/us-core-careteam", USCoreCareTeam.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/core/StructureDefinition/us-core-condition", USCoreCondition.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/core/StructureDefinition/us-core-diagnosticreport-lab", USCoreDiagnosticReportLab.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/core/StructureDefinition/us-core-diagnosticreport-note", USCoreDiagnosticReportNote.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/core/StructureDefinition/us-core-organization", USCoreOrganization.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/core/StructureDefinition/us-core-practitioner", USCorePractitioner.class);
		this.setDefaultTypeForProfile("http://hl7.org/fhir/us/core/StructureDefinition/us-core-vital-signs", USCoreVitalSigns.class);
	}
}
