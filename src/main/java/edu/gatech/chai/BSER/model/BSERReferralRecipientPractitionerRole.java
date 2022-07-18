package edu.gatech.chai.BSER.model;

import org.hl7.fhir.r4.model.PractitionerRole;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.BSER.model.util.CommonUtil;

@ResourceDef(name = "PractitionerRole", profile = "http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ReferralRecipientPractitionerRole")
public class BSERReferralRecipientPractitionerRole extends PractitionerRole{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8021608999126593262L;
	
	public BSERReferralRecipientPractitionerRole() {
		super();
	}
	
	public BSERReferralRecipientPractitionerRole(Reference practitionerReference, Reference organizationReference, Reference locationReference) {
		super();
		commonConstructor(practitionerReference,organizationReference,locationReference);
	}
	
	
	public BSERReferralRecipientPractitionerRole(BSERPractitioner practitioner, BSEROrganization organization, BSERServiceDeliveryLocation location) {
		super();
		Reference practitionerReference = new Reference("Practitioner/"+practitioner.getId());
		Reference organizationReference = new Reference("Organization/"+organization.getId());
		Reference locationReference = new Reference("Location/"+location.getId());
		commonConstructor(practitionerReference,organizationReference,locationReference);
	}
	
	private BSERReferralRecipientPractitionerRole commonConstructor(Reference practitionerReference, Reference organizationReference,Reference locationReference) {
		CommonUtil.isValidReference(practitionerReference, "Practitioner");
		CommonUtil.isValidReference(organizationReference, "Organization");
		CommonUtil.isValidReference(locationReference, "Location");
		super.setPractitioner(practitionerReference);
		super.setOrganization(organizationReference);
		super.addLocation(locationReference);
		return this;
	}

	public BSERReferralRecipientPractitionerRole setPractitioner(Reference practitionerReference) {
		CommonUtil.isValidReference(practitionerReference, "Practitioner");
		super.setPractitioner(practitionerReference);
		return this;
	}

	public BSERReferralRecipientPractitionerRole setPractitioner(BSERPractitioner practitioner) 
	{
		Reference practitionerReference = new Reference("Practitioner/"+practitioner.getId());
		return setPractitioner(practitionerReference);
	}
	
	public BSERReferralRecipientPractitionerRole setOrganization(Reference organizationReference) {
		CommonUtil.isValidReference(organizationReference, "Organization");
		super.setOrganization(organizationReference);
		return this;
	}

	public BSERReferralRecipientPractitionerRole setOrganization(BSEROrganization organization) 
	{
		Reference organizationReference = new Reference("Organization/"+organization.getId());
		return setOrganization(organizationReference);
	}
	
	public BSERReferralRecipientPractitionerRole addLocation(Reference locationReference) {
		CommonUtil.isValidReference(locationReference, "Location");
		this.addLocation(locationReference);
		return this;
	}

	public BSERReferralRecipientPractitionerRole addLocation(BSERServiceDeliveryLocation location) 
	{
		Reference locationReference = new Reference("Location/"+location.getId());
		return addLocation(locationReference);
	}
			
}
