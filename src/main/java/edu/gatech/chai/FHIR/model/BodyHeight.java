package edu.gatech.chai.FHIR.model;

import java.math.BigDecimal;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.DecimalType;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Quantity;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.FHIR.model.util.BodyHeightUtil;
import edu.gatech.chai.FHIR.model.util.CommonUtil;

@ResourceDef(name = "Observation", profile = "http://hl7.org/fhir/StructureDefinition/bodyheight")
public class BodyHeight extends Observation{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7846812983446018041L;
	
	public BodyHeight(Quantity quantity) {
		super();
		commonConstructor(quantity);
	}
	
	public BodyHeight(float value, String unitCode, String unitFullname) {
		super();
		Quantity quantity = new Quantity();
		quantity.setValue(new BigDecimal(value));
		quantity.setSystem(CommonUtil.ucumSystemUrl);
		quantity.setCode(unitCode);
		quantity.setUnit(unitFullname);
		commonConstructor(quantity);
	}
	
	public BodyHeight commonConstructor(Quantity quantity) {
		super.setCode(BodyHeightUtil.code);
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
		if(quantity.getSystem() != CommonUtil.ucumSystemUrl) {
			throw new FHIRException("quantity requires a system url of: http://unitsofmeasure.org");
		}
		if(!BodyHeightUtil.valueCodes.contains(quantity.getCode())) {
			throw new FHIRException("quantity code must be one of:"+String.join(",", BodyHeightUtil.valueCodes)+", found:"+quantity.getCode());
		}
		super.setValue(quantity);
		return this;
	}
}