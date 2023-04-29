package edu.gatech.chai.BSER.model;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.BSER.model.util.CommonUtil;
import edu.gatech.chai.USCore.model.USCoreConditionProblemsAndHealthConcerns;

@ResourceDef(name = "Organization", profile = "http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-Diagnosis")
public class BSERDiagnosis extends USCoreConditionProblemsAndHealthConcerns{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3292925445691732367L;
	public BSERDiagnosis(){
		super();
		setCategory();
	}
	
	public BSERDiagnosis(CodeableConcept code, Reference subject) {
		super(CommonUtil.problemListItemCategory(), code, subject);
		setCategory();
	}

	protected void setCategory() {
		super.addCategory(new CodeableConcept(new Coding("http://terminology.hl7.org/CodeSystem/condition-category", "problem-list-item", "Problem List Item")));
	}
}
