package edu.gatech.chai.BSER.model;

import org.hl7.fhir.r4.model.Bundle;

public abstract class BSERSupportingInfoBundleAbstract extends Bundle{
	public BSERSupportingInfoBundleAbstract() {
		super.setType(BundleType.COLLECTION);
	}
}
