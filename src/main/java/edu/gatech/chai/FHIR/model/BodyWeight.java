package edu.gatech.chai.FHIR.model;

import java.math.BigDecimal;
import java.util.Date;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Quantity;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.FHIR.model.util.BodyWeightUtil;
import edu.gatech.chai.FHIR.model.util.CommonUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/StructureDefinition/bodyweight")
public class BodyWeight extends Observation{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4970033045994485529L;

	public BodyWeight() {
		super();
		super.setCode(BodyWeightUtil.code);
	}

	public BodyWeight(Quantity quantity) {
		super();
		commonConstructor(quantity);
	}
	
	public BodyWeight(float value, String unitCode, String unitFullname) {
		super();
		Quantity quantity = new Quantity();
		quantity.setValue(new BigDecimal(value));
		quantity.setSystem(CommonUtil.ucumSystemUrl);
		quantity.setUnit(unitFullname);
		commonConstructor(quantity);
	}
	
	public BodyWeight commonConstructor(Quantity quantity) {
		super.setCode(BodyWeightUtil.code);
		super.addCategory(CommonUtil.getVitalSignsCategory());
        super.setEffective(new DateTimeType(new Date()));

		if(quantity.getValue() == null) {
			throw new FHIRException("quantity requires a value");
		}
		if(quantity.getSystem() == null) {
			throw new FHIRException("quantity requires a system url of: http://unitsofmeasure.org");
		}
		if(quantity.getCode() == null) {
			throw new FHIRException("quantity requires a code");
		}
		if(quantity.getUnit() == null) {
			throw new FHIRException("quantity requires a unit string");
		}
		if(!CommonUtil.ucumSystemUrl.equals(quantity.getSystem())) {
			throw new FHIRException("quantity requires a system url of: http://unitsofmeasure.org");
		}
		if(!BodyWeightUtil.valueCodes.contains(quantity.getCode())) {
			throw new FHIRException("quantity code must be one of:"+String.join(",", BodyWeightUtil.valueCodes)+", found:"+quantity.getCode());
		}
		super.setValue(quantity);
		return this;
	}
}