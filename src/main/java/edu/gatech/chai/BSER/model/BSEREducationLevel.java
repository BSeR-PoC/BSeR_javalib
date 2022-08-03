package edu.gatech.chai.BSER.model;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Observation;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.BSER.model.util.BSEREducationLevelUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-EducationLevel")
public class BSEREducationLevel extends Observation{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3521086429728477845L;

	public enum VSEducationLevel {
		ASSOC("ASSOC", "Associate's or technical degree complete"),
		BD("BD", "College or baccalaureate degree complete"),
		ELEM("ELEM", "Elementary School"),
		GD("GD", "Graduate or professional Degree complete"),
		HS("HS", "High School or secondary school degree complete"),
		PB("PB", "Some post-baccalaureate education"),
		POSTG("POSTG", "Doctoral or post graduate education"),
		SCOL("SCOL", "Some College education"),
		SEC("BD", "Some secondary or high school education");

		private String code;
		private String display;

		VSEducationLevel(String code, String display) {
			this.code = code;
			this.display = display;
		}

		public String getCode() {
			return this.code;
		}

		public String getDisplay() {
			return this.display;
		}

		public String getSystem() {
			return "http://terminology.hl7.org/CodeSystem/v3-EducationLevel";
		}

		public CodeableConcept getCodeableConcept() {
			return new CodeableConcept(new Coding(getSystem(), getCode(), getDisplay()));
		}
	}

	public static VSEducationLevel find(String codeString) {

		if (VSEducationLevel.ASSOC.getCode().equals(codeString)) {
			return VSEducationLevel.ASSOC;
		}

		if (VSEducationLevel.BD.getCode().equals(codeString)) {
			return VSEducationLevel.BD;
		}

		if (VSEducationLevel.ELEM.getCode().equals(codeString)) {
			return VSEducationLevel.ELEM;
		}

		if (VSEducationLevel.GD.getCode().equals(codeString)) {
			return VSEducationLevel.GD;
		}

		if (VSEducationLevel.HS.getCode().equals(codeString)) {
			return VSEducationLevel.HS;
		}

		if (VSEducationLevel.PB.getCode().equals(codeString)) {
			return VSEducationLevel.PB;
		}

		if (VSEducationLevel.POSTG.getCode().equals(codeString)) {
			return VSEducationLevel.POSTG;
		}

		if (VSEducationLevel.SCOL.getCode().equals(codeString)) {
			return VSEducationLevel.SCOL;
		}

		if (VSEducationLevel.SEC.getCode().equals(codeString)) {
			return VSEducationLevel.SEC;
		}

		return null;
	}
	
	public BSEREducationLevel() {
		super();
	}
	
	public BSEREducationLevel(CodeableConcept value) {
		super.setStatus(ObservationStatus.FINAL);
		super.setCode(BSEREducationLevelUtil.code);
		super.setValue(value);
	}
}