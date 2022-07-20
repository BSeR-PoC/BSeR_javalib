package edu.gatech.chai.BSER.model;

import org.hl7.fhir.r4.model.Bundle;

public abstract class BSERSupportingInfoBundle extends Bundle{
	public BSERSupportingInfoBundle() {
		super.setType(BundleType.COLLECTION);
	}
}
