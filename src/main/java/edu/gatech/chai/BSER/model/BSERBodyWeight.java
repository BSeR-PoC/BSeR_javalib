package edu.gatech.chai.BSER.model;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Observation;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/StructureDefinition/bodyweight")
public class BSERBodyWeight extends Observation{

    public BSERBodyWeight() {
        super();
        super.setCode(new CodeableConcept(new Coding("http://loinc.org", "29463-7","Body weight")));
    }
}
