package edu.gatech.chai.BSER.model;

import org.hl7.fhir.r4.model.Location;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

@ResourceDef(name = "Location", profile = "http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ServiceDeliveryLocation")
public class BSERServiceDeliveryLocation extends Location{
    private static final long serialVersionUID = -1161543706572844710L;
    
    public BSERServiceDeliveryLocation(){
        super();
    }

}