package edu.gatech.chai.BSER.model;

import java.util.Date;

import org.hl7.fhir.r4.model.BaseReference;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.StringType;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.BSER.model.util.BSERParticipantFeedbackObservationUtil;
import edu.gatech.chai.BSER.model.util.BSERReferralActivityStatusUtil;
import edu.gatech.chai.BSER.model.util.CommonUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ParticipationFeedbackObservation")
public class BSERParticipationFeedbackObservation extends Observation{


	public BSERParticipationFeedbackObservation(CodeableConcept code, Date dateTime,Reference subject,Quantity value) {
		super();
		CommonUtil.isValidReference(subject, "Patient");
		if(!BSERParticipantFeedbackObservationUtil.codes.contains(code)) {
			
		}
		super.setStatus(ObservationStatus.FINAL);
		super.setCode(BSERReferralActivityStatusUtil.code);
		super.setEffective(new DateTimeType(dateTime));
		super.setValue(new StringType(value));
	}
	
}