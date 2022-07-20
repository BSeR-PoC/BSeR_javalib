package edu.gatech.chai.BSER.model;

import java.util.Date;

import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.StringType;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.BSER.model.util.BSERReferralActivityStatusUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ReferralActivityStatus")
public class BSERReferralActivityStatus extends Observation{


	public BSERReferralActivityStatus(Date dateTime,String value) {
		super();
		super.setStatus(ObservationStatus.FINAL);
		super.setCode(BSERReferralActivityStatusUtil.code);
		super.setEffective(new DateTimeType(dateTime));
		super.setValue(new StringType(value));
	}
	
}