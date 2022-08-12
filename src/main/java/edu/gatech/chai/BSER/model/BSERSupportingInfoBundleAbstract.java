package edu.gatech.chai.BSER.model;

import java.util.UUID;

import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.IdType;

public abstract class BSERSupportingInfoBundleAbstract extends Bundle{
	public BSERSupportingInfoBundleAbstract() {
		super.setId(new IdType(fhirType(), UUID.randomUUID().toString()));
		super.setType(BundleType.COLLECTION);
	}
}
