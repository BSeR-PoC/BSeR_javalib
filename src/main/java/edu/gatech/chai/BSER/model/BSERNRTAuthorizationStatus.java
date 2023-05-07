/*
 * Filename: /Users/mc142/Documents/workspace/BSeR/BSeR_javalib/src/main/java/edu/gatech/chai/BSER/model/BSERHA1CObservation copy.java
 * Path: /Users/mc142/Documents/workspace/BSeR/BSeR_javalib/src/main/java/edu/gatech/chai/BSER/model
 * Created Date: Thursday, April 27th 2023, 10:38:00 am
 * Author: Myung Choi
 * 
 * Copyright (c) 2023 GTRI - Health Emerging and Advanced Technologies (HEAT)
 */
package edu.gatech.chai.BSER.model;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.BSER.model.util.BSERNRTAuthorizationStatusUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-NRT-AuthorizationStatus")
public class BSERNRTAuthorizationStatus extends Observation{

    public BSERNRTAuthorizationStatus() {
        super();
        super.setStatus(ObservationStatus.FINAL);
        super.setCode(BSERNRTAuthorizationStatusUtil.nicotinReplTherapy);
    }
    
    public BSERNRTAuthorizationStatus(Reference subject, CodeableConcept value){
        super();
        super.setStatus(ObservationStatus.FINAL);
        super.setCode(BSERNRTAuthorizationStatusUtil.nicotinReplTherapy);
        super.setSubject(subject);
        super.setValue(value);
    }
}
