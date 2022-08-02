package edu.gatech.chai.BSER.model;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coverage;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.BSER.model.util.CommonUtil;

@ResourceDef(name = "Coverage", profile = "http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-Coverage")
public class BSERCoverage extends Coverage{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3457938695594722128L;
	
	public BSERCoverage() {
		super();
	}

	public BSERCoverage(CoverageStatus status, CodeableConcept type,
			Reference subscriber, Reference beneficiary, Reference payor) {
		super();
	}
	
	private BSERCoverage commonConstructor(CoverageStatus status, CodeableConcept type,
			Reference subscriber, Reference beneficiary, Reference payor) {
		CommonUtil.isValidReference(subscriber, "RelatedPerson");
		CommonUtil.isValidReference(beneficiary, "Patient");
		CommonUtil.isValidReference(payor, "Organization");
		
		super.setStatus(status);
		super.setType(type);
		super.setSubscriber(subscriber);
		super.setBeneficiary(beneficiary);
		super.addPayor(payor);
		return this;
	}
}
