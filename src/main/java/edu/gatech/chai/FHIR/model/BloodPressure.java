package edu.gatech.chai.FHIR.model;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Quantity;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.FHIR.model.util.BloodPressureUtil;
import edu.gatech.chai.FHIR.model.util.CommonUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/StructureDefinition/bp")
public class BloodPressure extends Observation{
    public BloodPressure(){
        super();
        super.setCode(BloodPressureUtil.code);
    }

    public BloodPressure(Quantity systolicBP, Quantity diastolicBP) {
        super();
        super.setCode(BloodPressureUtil.code);
        ObservationComponentComponent systolicComponent = new ObservationComponentComponent();
        systolicComponent.setCode(BloodPressureUtil.systolicBPComponentCode);
        ObservationComponentComponent diastolicComponent = new ObservationComponentComponent();
        diastolicComponent.setCode(BloodPressureUtil.diastolicBPComponentCode);
        if(systolicBP != null){
            if(systolicBP.getValue() == null) {
                throw new FHIRException("quantity requires a value");
            }
            if(systolicBP.getSystem() == null) {
                throw new FHIRException("quantity requires a system url of: http://unitsofmeasure.org");
            }
            if(systolicBP.getCode() == null) {
                throw new FHIRException("quantity requires a code");
            }
            if(systolicBP.getUnit() == null) {
                throw new FHIRException("quantity requires a unit string");
            }
            if(systolicBP.getSystem() != CommonUtil.ucumSystemUrl) {
                throw new FHIRException("quantity requires a system url of: http://unitsofmeasure.org");
            }
            if(!BloodPressureUtil.valueCodes.contains(systolicBP.getCode())) {
                throw new FHIRException("quantity code must be one of:"+String.join(",", BodyHeightUtil.valueCodes)+", found:"+quantity.getCode());
            }
            systolicComponent.setValue(systolicBP);
        }
        if(diastolicBP != null){
            if(diastolicBP.getValue() == null) {
                throw new FHIRException("quantity requires a value");
            }
            if(diastolicBP.getSystem() == null) {
                throw new FHIRException("quantity requires a system url of: http://unitsofmeasure.org");
            }
            if(diastolicBP.getCode() == null) {
                throw new FHIRException("quantity requires a code");
            }
            if(diastolicBP.getUnit() == null) {
                throw new FHIRException("quantity requires a unit string");
            }
            if(diastolicBP.getSystem() != CommonUtil.ucumSystemUrl) {
                throw new FHIRException("quantity requires a system url of: http://unitsofmeasure.org");
            }
            if(!BloodPressureUtil.valueCodes.contains(diastolicBP.getCode())) {
                throw new FHIRException("quantity code must be one of:"+String.join(",", BodyHeightUtil.valueCodes)+", found:"+quantity.getCode());
            }
            systolicComponent.setValue(diastolicBP);
        }
        super.addComponent(systolicComponent);
        super.addComponent(diastolicComponent);
    }
}
