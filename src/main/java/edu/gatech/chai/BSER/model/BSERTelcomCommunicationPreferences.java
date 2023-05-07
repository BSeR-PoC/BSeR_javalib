/*
 * Filename: /Users/mc142/Documents/workspace/BSeR/BSeR_javalib/src/main/java/edu/gatech/chai/BSER/model/BSERHA1CObservation copy.java
 * Path: /Users/mc142/Documents/workspace/BSeR/BSeR_javalib/src/main/java/edu/gatech/chai/BSER/model
 * Created Date: Friday, April 28th 2023, 11:55:56 am
 * Author: Myung Choi
 * 
 * Copyright (c) 2023 GTRI - Health Emerging and Advanced Technologies (HEAT)
 */
package edu.gatech.chai.BSER.model;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.StringType;

import ca.uhn.fhir.model.api.annotation.ResourceDef;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-TelcomCommunicationPreferences")
public class BSERTelcomCommunicationPreferences extends Observation{

    public BSERTelcomCommunicationPreferences() {
        super();
        super.setStatus(ObservationStatus.FINAL);
    }
    
    public BSERTelcomCommunicationPreferences(CodeableConcept code, StringType value){
        super();
        super.setStatus(ObservationStatus.FINAL);
        super.setCode(code);
        super.setValue(value);
    }
}
