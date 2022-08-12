package edu.gatech.chai.FHIR.model;

import java.math.BigDecimal;
import java.util.UUID;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Quantity;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.FHIR.model.util.BMIUtil;
import edu.gatech.chai.FHIR.model.util.CommonUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/StructureDefinition/bmi")
public class BMI extends Observation{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4593284857605640137L;

	public BMI() {
		super();
		super.setId(new IdType(fhirType(), UUID.randomUUID().toString()));
		super.setCode(BMIUtil.code);
	}

	public BMI(Quantity quantity) {
		super();
		super.setId(new IdType(fhirType(), UUID.randomUUID().toString()));
		commonConstructor(quantity);
	}
	
	public BMI(float value) {
		super();
		super.setId(new IdType(fhirType(), UUID.randomUUID().toString()));

		Quantity quantity = new Quantity();
		quantity.setValue(new BigDecimal(value));
		quantity.setSystem(CommonUtil.ucumSystemUrl);
		quantity.setCode("kg/m2");
		quantity.setUnit("KiloGramsPerSquareMeter");
		commonConstructor(quantity);
	}
	
	public BMI(float value, String unitCode, String unitFullname) {
		super();
		super.setId(new IdType(fhirType(), UUID.randomUUID().toString()));

		Quantity quantity = new Quantity();
		quantity.setValue(new BigDecimal(value));
		quantity.setSystem(CommonUtil.ucumSystemUrl);
		quantity.setCode(unitCode);
		quantity.setUnit(unitFullname);
		commonConstructor(quantity);
	}
	
	public BMI commonConstructor(Quantity quantity) {
		super.setCode(BMIUtil.code);
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
		if (!CommonUtil.ucumSystemUrl.equals((quantity.getSystem()))) {
			throw new FHIRException("quantity requires a system url of: http://unitsofmeasure.org");
		}
		if(!BMIUtil.valueCodes.contains(quantity.getCode())) {
			throw new FHIRException("quantity code must be one of:"+String.join(",", BMIUtil.valueCodes)+", found:"+quantity.getCode());
		}
		super.setValue(quantity);
		return this;
	}
}