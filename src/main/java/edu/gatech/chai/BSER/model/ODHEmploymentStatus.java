package edu.gatech.chai.BSER.model;

import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.codesystems.ObservationCategory;
import org.hl7.fhir.r4.model.codesystems.ObservationCategoryEnumFactory;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

/**
 * 
 * NOTE: Leaving a foreign resource in the BSER IG for now for ease of use
 *
 */

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/odh/StructureDefinition/odh-EmploymentStatus")
public class ODHEmploymentStatus extends Observation{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4010359680028283864L;

	public ODHEmploymentStatus(Reference subjectReference) {
		CodeableConcept socialHistoryCC = new CodeableConcept(
			new Coding(ObservationCategory.SOCIALHISTORY.getSystem(), ObservationCategory.SOCIALHISTORY.toCode(), ObservationCategory.SOCIALHISTORY.getDisplay())
		);

		CodeableConcept nioshHistoryEmpCC = new CodeableConcept(
			new Coding("http://loinc.org", "74165-2", "History of employment status NIOSH")
		);

		List<CodeableConcept> observationCategories = new ArrayList<CodeableConcept>();
		observationCategories.add(socialHistoryCC);
		observationCategories.add(nioshHistoryEmpCC);

		this.setCategory(observationCategories);
		this.setSubject(subjectReference);
	}
}
