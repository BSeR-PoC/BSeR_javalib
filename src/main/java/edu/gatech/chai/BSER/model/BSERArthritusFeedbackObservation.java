package edu.gatech.chai.BSER.model;

import org.hl7.fhir.r4.model.BooleanType;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.r4.model.Type;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.BSER.model.util.CommonUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ArthritisFeedbackObservation")
public class BSERArthritusFeedbackObservation extends Observation{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2744782990117835263L;

	public BSERArthritusFeedbackObservation() {
		super();
	}
	public BSERArthritusFeedbackObservation(CodeableConcept code, Reference subject, boolean valueBoolean) {
		super();
		commonConstructor(code, subject, new BooleanType(valueBoolean));
	}
	
	public BSERArthritusFeedbackObservation(CodeableConcept code, Reference subject, CodeableConcept valueCodeableConcept) {
		super();
		commonConstructor(code, subject, valueCodeableConcept);
	}
	
	public BSERArthritusFeedbackObservation(CodeableConcept code, Reference subject, String valueString) {
		super();
		commonConstructor(code, subject, new StringType(valueString));
	}
	
	private BSERArthritusFeedbackObservation commonConstructor(CodeableConcept code, Reference subject,
			Type value) {
		CommonUtil.isValidReference(subject, "Patient");
		super.setCode(code);
		super.setSubject(subject);
		super.setValue(value);
		return this;
	}
}