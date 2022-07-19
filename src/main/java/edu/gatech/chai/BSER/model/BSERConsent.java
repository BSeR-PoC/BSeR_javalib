package edu.gatech.chai.BSER.model;

import java.util.Date;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Consent;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.BSER.model.util.CommonUtil;

@ResourceDef(name = "Consent", profile = "http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-Consent")
public class BSERConsent extends Consent{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2744782990117835263L;

	public BSERConsent(ConsentState status, CodeableConcept scope,
			CodeableConcept category, Reference patient, Date dateTime,
			Reference performer, ConsentProvisionType provisionType) {
		CommonUtil.isValidReference(patient, "Patient");
		CommonUtil.isValidReference(performer, "RelatedPerson");
		super.setStatus(status);
		super.setScope(scope);
		super.addCategory(category);
		super.setPatient(patient);
		super.setDateTime(dateTime);
		super.addPerformer(performer);
		super.setProvision(new provisionComponent().setType(provisionType));
	}
}
