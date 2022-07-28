package edu.gatech.chai.BSER.model;

import java.util.Date;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Quantity;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.BSER.model.util.BSERParticipantFeedbackObservationUtil;
import edu.gatech.chai.BSER.model.util.CommonUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ParticipationFeedbackObservation")
public class BSERParticipationFeedbackObservation extends Observation{

	public BSERParticipationFeedbackObservation() {
		super();
	}

	public BSERParticipationFeedbackObservation(CodeableConcept code, Date dateTime,Reference subject,Quantity value) {
		super();
		CommonUtil.isValidReference(subject, "Patient");
		if(!BSERParticipantFeedbackObservationUtil.codes.contains(code)) {
			throw new FHIRException("BSERParticipationFeedbackObservation: invalid code found for code field");
		}
		super.setStatus(ObservationStatus.FINAL);
		super.setValue(value);
	}
	
}