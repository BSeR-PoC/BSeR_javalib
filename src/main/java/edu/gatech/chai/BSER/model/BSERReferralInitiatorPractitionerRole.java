package edu.gatech.chai.BSER.model;

import org.hl7.fhir.r4.model.PractitionerRole;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.BSER.model.util.CommonUtil;

@ResourceDef(name = "PractitionerRole", profile = "http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ReferralInitiatorPractitionerRole")
public class BSERReferralInitiatorPractitionerRole extends PractitionerRole{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8021608999126593262L;
	
	public BSERReferralInitiatorPractitionerRole() {
		super();
	}
	
	public BSERReferralInitiatorPractitionerRole(Reference practitionerReference, Reference organizationReference) {
		super();
		commonConstructor(practitionerReference,organizationReference);
	}
	
	public BSERReferralInitiatorPractitionerRole(BSERPractitioner practitioner, BSEROrganization organization) {
		super();
		Reference practitionerReference = new Reference("Practitioner/"+practitioner.getId());
		Reference organizationReference = new Reference("Organization/"+organization.getId());
		commonConstructor(practitionerReference,organizationReference);
	}
	
	private BSERReferralInitiatorPractitionerRole commonConstructor(Reference practitionerReference, Reference organizationReference) {
		CommonUtil.isValidReference(practitionerReference, "Practitioner");
		CommonUtil.isValidReference(organizationReference, "Organization");
		super.setPractitioner(practitionerReference);
		super.setOrganization(organizationReference);
		return this;
	}

	public BSERReferralInitiatorPractitionerRole setPractitioner(Reference practitionerReference) {
		CommonUtil.isValidReference(practitionerReference, "Practitioner");
		super.setPractitioner(practitionerReference);
		return this;
	}

	public BSERReferralInitiatorPractitionerRole setPractitioner(BSERPractitioner practitioner) 
	{
		Reference practitionerReference = new Reference("Practitioner/"+practitioner.getId());
		return setPractitioner(practitionerReference);
	}
	
	public BSERReferralInitiatorPractitionerRole setOrganization(Reference organizationReference) {
		CommonUtil.isValidReference(organizationReference, "Organization");
		super.setOrganization(organizationReference);
		return this;
	}

	public BSERReferralInitiatorPractitionerRole setOrganization(BSEROrganization organization) 
	{
		Reference organizationReference = new Reference("Organization/"+organization.getId());
		return setOrganization(organizationReference);
	}
	
	public BSERReferralInitiatorPractitionerRole addLocation(Reference locationReference) {
		CommonUtil.isValidReference(locationReference, "Location");
		super.addLocation(locationReference);
		return this;
	}

	public BSERReferralInitiatorPractitionerRole addLocation(BSERServiceDeliveryLocation location) 
	{
		Reference locationReference = new Reference("Location/"+location.getId());
		return addLocation(locationReference);
	}
			
}
