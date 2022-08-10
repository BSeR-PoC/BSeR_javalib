package edu.gatech.chai.BSER.model;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Quantity;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-HA1C-Observation")
public class BSERHA1CObservation extends Observation{

    public BSERHA1CObservation() {
        super();
        super.setStatus(ObservationStatus.FINAL);
    }
    
    public BSERHA1CObservation(CodeableConcept code, Quantity quantity){
        super();
        super.setStatus(ObservationStatus.FINAL);
        super.setCode(code);
        super.setValue(quantity);
    }
}
