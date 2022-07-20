package edu.gatech.chai.BSER.model.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;

public class BSERArthritusReferralFeedbackObservationUtil {
	
	public static List<CodeableConcept> codeVS = new ArrayList<CodeableConcept>(Arrays.asList(
			new CodeableConcept().addCoding(new Coding("http://loinc.org/","10160-0","History of Medication use Narrative")),
			new CodeableConcept().addCoding(new Coding("http://snomed.info/sct","22253000","Pain (finding)")),
			new CodeableConcept().addCoding(new Coding("http://snomed.info/sct","224973000","Feeling frustrated (finding)")),
			new CodeableConcept().addCoding(new Coding("http://snomed.info/sct","278414003","Pain management (procedure)")),
			new CodeableConcept().addCoding(new Coding("http://snomed.info/sct","307048004","Feeling isolated (finding)")),
			new CodeableConcept().addCoding(new Coding("http://snomed.info/sct","364564000","Range of joint movement (observable entity)")),
			new CodeableConcept().addCoding(new Coding("http://snomed.info/sct","406203001","Endurance (observable entity)")),
			new CodeableConcept().addCoding(new Coding("http://snomed.info/sct","435771000124106","General healthful diet (regime/therapy)")),
			new CodeableConcept().addCoding(new Coding("http://loinc.org/","80322-1","Muscle strength")),
			new CodeableConcept().addCoding(new Coding("http://snomed.info/sct","84229001","Fatigue (finding)"))
			));
	
	public static List<CodeableConcept> valueVS = new ArrayList<CodeableConcept>(Arrays.asList(
			new CodeableConcept().addCoding(new Coding("http://snomed.info/sct","268910001","Patient's condition improved (finding)")),
			new CodeableConcept().addCoding(new Coding("http://snomed.info/sct","271299001","Patient's condition worsened (finding)")),
			new CodeableConcept().addCoding(new Coding("http://snomed.info/sct","359748005","Patient condition unchanged (finding)"))
			));
}
