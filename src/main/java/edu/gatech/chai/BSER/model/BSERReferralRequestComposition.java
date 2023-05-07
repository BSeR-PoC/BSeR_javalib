package edu.gatech.chai.BSER.model;

import java.util.Date;
import java.util.List;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Composition;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.BSER.model.util.BSERReferralRequestCompositionUtil;
import edu.gatech.chai.BSER.model.util.CommonUtil;

@ResourceDef(name = "Composition", profile = "http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ReferralRequestComposition")
public class BSERReferralRequestComposition extends Composition{


	/**
	 * 
	 */
	private static final long serialVersionUID = -7888507606333842386L;

	public BSERReferralRequestComposition() {
		super();
	}

	public BSERReferralRequestComposition(CompositionStatus status, CodeableConcept type,
		Reference subject, Date dateTime, Reference author, String title, 
		List<SectionComponent> obesityReferralSupportingInformations,
		List<SectionComponent> arthritisReferralSupportingInformations,
		List<SectionComponent> hypertensionReferralSupportingInformations,
		List<SectionComponent> earlyChildhoodNutritionReferralSupportingInformations,
		List<SectionComponent> diabetesPreventionReferralSupportingInformations,
		List<SectionComponent> tobaccoUseCessationReferralSupportingInformations) {
		super();
		
		CommonUtil.isValidReference(subject, "Patient");
		CommonUtil.isValidReference(author, "PractitionerRole");

		super.setStatus(status);
		super.setType(type);
		super.setSubject(subject);
		super.setDate(dateTime);
		super.addAuthor(author);
		super.setTitle(title);
		
		if (obesityReferralSupportingInformations != null && !obesityReferralSupportingInformations.isEmpty()) {
			super.getSection().addAll(obesityReferralSupportingInformations);
		}
		if (arthritisReferralSupportingInformations != null && !arthritisReferralSupportingInformations.isEmpty()) {
			super.getSection().addAll(arthritisReferralSupportingInformations);
		}
		if (hypertensionReferralSupportingInformations != null && !hypertensionReferralSupportingInformations.isEmpty()) {
			super.getSection().addAll(hypertensionReferralSupportingInformations);
		}
		if (earlyChildhoodNutritionReferralSupportingInformations != null && !earlyChildhoodNutritionReferralSupportingInformations.isEmpty()) {
			super.getSection().addAll(earlyChildhoodNutritionReferralSupportingInformations);
		}
		if (diabetesPreventionReferralSupportingInformations != null && !diabetesPreventionReferralSupportingInformations.isEmpty()) {
			super.getSection().addAll(diabetesPreventionReferralSupportingInformations);
		}
		if (tobaccoUseCessationReferralSupportingInformations != null && !tobaccoUseCessationReferralSupportingInformations.isEmpty()) {
			super.getSection().addAll(tobaccoUseCessationReferralSupportingInformations);
		}

	}
	
	public static SectionComponent createObesityReferralSupportingInformation(BSERReferralRequestComposition comp, List<Reference> allergies, Reference bp, Reference bodyHeight, Reference bodyWeight, Reference bmi) {
		SectionComponent section = null;
		if (comp != null && !comp.isEmpty()) {
			section = CommonUtil.findSectionWithCode(comp, BSERReferralRequestCompositionUtil.obesityReferralSupportingInfoSectionCode);
		}

		if (section != null) {
			// We are updating this. Delete all the entries and reinsert.
			section.getEntry().clear();
		} else {
			section = new SectionComponent();
		}

		section.setCode(BSERReferralRequestCompositionUtil.obesityReferralSupportingInfoSectionCode);

		if (allergies != null && !allergies.isEmpty()) {
			section.getEntry().addAll(allergies);
		}
		if (bp != null && !bp.isEmpty()) {
			section.addEntry(bp);
		}
		if (bodyHeight != null && !bodyHeight.isEmpty()) {
			section.addEntry(bodyHeight);
		}
		if (bodyWeight != null && !bodyWeight.isEmpty()) {
			section.addEntry(bodyWeight);
		}
		if (bmi != null && !bmi.isEmpty()) {
			section.addEntry(bmi);
		}

		return section;
	}
	
	public static SectionComponent createArthritisReferralSupportingInformation(BSERReferralRequestComposition comp, List<Reference> allergies, List<Reference> meds, Reference bp, Reference bodyHeight, Reference bodyWeight, Reference bmi) {
		SectionComponent section = null;
		if (comp != null && !comp.isEmpty()) {
			section = CommonUtil.findSectionWithCode(comp, BSERReferralRequestCompositionUtil.arthritisReferralSupportingInfoSectionCode);
		}

		if (section != null) {
			// We are updating this. Delete all the entries and reinsert.
			section.getEntry().clear();
		} else {
			section = new SectionComponent();
		}

		section.setCode(BSERReferralRequestCompositionUtil.arthritisReferralSupportingInfoSectionCode);

		if (allergies != null && !allergies.isEmpty()) {
			section.getEntry().addAll(allergies);
		}
		if (meds != null && !meds.isEmpty()) {
			section.getEntry().addAll(meds);
		}
		if (bp != null && !bp.isEmpty()) {
			section.addEntry(bp);
		}
		if (bodyHeight != null && !bodyHeight.isEmpty()) {
			section.addEntry(bodyHeight);
		}
		if (bodyWeight != null && !bodyWeight.isEmpty()) {
			section.addEntry(bodyWeight);
		}
		if (bmi != null && !bmi.isEmpty()) {
			section.addEntry(bmi);
		}

		return section;
	}
	
	public static SectionComponent createHypertensionReferralSupportingInformation(BSERReferralRequestComposition comp, List<Reference> diagnosis, Reference bp, Reference bodyHeight, Reference bodyWeight, Reference bmi) {
		SectionComponent section = null;
		if (comp != null && !comp.isEmpty()) {
			section = CommonUtil.findSectionWithCode(comp, BSERReferralRequestCompositionUtil.hypertensionReferralSupportingInfoSectionCode);
		}
	
		if (section != null) {
			// We are updating this. Delete all the entries and reinsert.
			section.getEntry().clear();
		} else {
			section = new SectionComponent();
		}

		section.setCode(BSERReferralRequestCompositionUtil.hypertensionReferralSupportingInfoSectionCode);

		if (diagnosis != null && !diagnosis.isEmpty()) {
			section.getEntry().addAll(diagnosis);
		}
		if (bp != null && !bp.isEmpty()) {
			section.addEntry(bp);
		}
		if (bodyHeight != null && !bodyHeight.isEmpty()) {
			section.addEntry(bodyHeight);
		}
		if (bodyWeight != null && !bodyWeight.isEmpty()) {
			section.addEntry(bodyWeight);
		}
		if (bmi != null && !bmi.isEmpty()) {
			section.addEntry(bmi);
		}

		return section;
	}
	
	public static SectionComponent createEarlyChildhoodNutritionReferralSupportingInformation(BSERReferralRequestComposition comp, List<Reference> earlyChildhoodNutritionObs, Reference bp, Reference bodyHeight, Reference bodyWeight) {
		SectionComponent section = null;
		if (comp != null && !comp.isEmpty()) {
			section = CommonUtil.findSectionWithCode(comp, BSERReferralRequestCompositionUtil.earlyChildhoodNutritionReferralSupportingInfoSectionCode);
		}
	
		if (section != null) {
			// We are updating this. Delete all the entries and reinsert.
			section.getEntry().clear();
		} else {
			section = new SectionComponent();
		}

		section.setCode(BSERReferralRequestCompositionUtil.earlyChildhoodNutritionReferralSupportingInfoSectionCode);

		if (earlyChildhoodNutritionObs != null && !earlyChildhoodNutritionObs.isEmpty()) {
			section.getEntry().addAll(earlyChildhoodNutritionObs);
		}
		if (bp != null && !bp.isEmpty()) {
			section.addEntry(bp);
		}
		if (bodyHeight != null && !bodyHeight.isEmpty()) {
			section.addEntry(bodyHeight);
		}
		if (bodyWeight != null && !bodyWeight.isEmpty()) {
			section.addEntry(bodyWeight);
		}

		return section;
	}

	public static SectionComponent createDiabetesPreventionReferralSupportingInformation(BSERReferralRequestComposition comp, Reference hA1cObservation, Reference bp, Reference bodyHeight, Reference bodyWeight, Reference bmi) {
		SectionComponent section = null;
		if (comp != null && !comp.isEmpty()) {
			section = CommonUtil.findSectionWithCode(comp, BSERReferralRequestCompositionUtil.diabetesPreventionReferralSupportingInfoSectionCode);
		}

		if (section != null) {
			// We are updating this. Delete all the entries and reinsert.
			section.getEntry().clear();
		} else {
			section = new SectionComponent();
		}

		section.setCode(BSERReferralRequestCompositionUtil.diabetesPreventionReferralSupportingInfoSectionCode);

		if (hA1cObservation != null && !hA1cObservation.isEmpty()) {
			section.addEntry(hA1cObservation);
		}
		if (bp != null && !bp.isEmpty()) {
			section.addEntry(bp);
		}
		if (bodyHeight != null && !bodyHeight.isEmpty()) {
			section.addEntry(bodyHeight);
		}
		if (bodyWeight != null && !bodyWeight.isEmpty()) {
			section.addEntry(bodyWeight);
		}
		if (bmi != null && !bmi.isEmpty()) {
			section.addEntry(bmi);
		}

		return section;
	}

	public static SectionComponent createTobaccoUseCessationReferralSupportingInformation(BSERReferralRequestComposition comp, List<Reference> nrtAuthorizationStatus, Reference smokingStatus, List<Reference> telcomCommunicationPreferences) {
		SectionComponent section = null;
		if (comp != null && !comp.isEmpty()) {
			section = CommonUtil.findSectionWithCode(comp, BSERReferralRequestCompositionUtil.tobaccoUseCessationReferralSupportingInfoSectionCode);
		}

		if (section != null) {
			// We are updating this. Delete all the entries and reinsert.
			section.getEntry().clear();
		} else {
			section = new SectionComponent();
		}

		section.setCode(BSERReferralRequestCompositionUtil.tobaccoUseCessationReferralSupportingInfoSectionCode);

		if (nrtAuthorizationStatus != null && !nrtAuthorizationStatus.isEmpty()) {
			section.getEntry().addAll(nrtAuthorizationStatus);
		}
		if (smokingStatus != null && !smokingStatus.isEmpty()) {
			section.addEntry(smokingStatus);
		}
		if (telcomCommunicationPreferences != null && !telcomCommunicationPreferences.isEmpty()) {
			section.getEntry().addAll(telcomCommunicationPreferences);
		}

		return section;
	}
}
