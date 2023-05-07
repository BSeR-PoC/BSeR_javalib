package edu.gatech.chai.BSER.model;

import java.util.Date;
import java.util.List;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Composition;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.BSER.model.util.BSERReferralFeedbackCompositionUtil;
import edu.gatech.chai.BSER.model.util.CommonUtil;

@ResourceDef(name = "Composition", profile = "http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ReferralFeedbackComposition")
public class BSERReferralFeedbackComposition extends Composition{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5596418485277827438L;

	public BSERReferralFeedbackComposition() {
		super();
	}
	
	public BSERReferralFeedbackComposition(Reference subject,
			Date date, Reference author, String title,
			SectionComponent referralServiceRequestFeedbackSummary,
			List<SectionComponent> obesityReferralFeedbackSupportingInformations,
			List<SectionComponent> arthritisReferralFeedbackSupportingInformations,
			List<SectionComponent> hypertensionReferralFeedbackSupportingInformations,
			List<SectionComponent> earlyChildhoodNutritionReferralFeedbackSupportingInformations,
			List<SectionComponent> diabetesPreventionReferralFeedbackSupportingInformations,
			List<SectionComponent> tobaccoUseCessationReferralFeedbackSupportingInformations) {
		super();
		
		if (referralServiceRequestFeedbackSummary == null || referralServiceRequestFeedbackSummary.isEmpty()) {
			throw new FHIRException("Referral Service Request Feedback Summary is required.");
		}

		CommonUtil.isValidReference(subject, "Patient");
		CommonUtil.isValidReference(author, "PractitionerRole");

		super.addSection(referralServiceRequestFeedbackSummary);

		if (obesityReferralFeedbackSupportingInformations != null && !obesityReferralFeedbackSupportingInformations.isEmpty()) {
			super.getSection().addAll(obesityReferralFeedbackSupportingInformations);
		}
		if (arthritisReferralFeedbackSupportingInformations != null && !arthritisReferralFeedbackSupportingInformations.isEmpty()) {
			super.getSection().addAll(arthritisReferralFeedbackSupportingInformations);
		}
		if (hypertensionReferralFeedbackSupportingInformations != null && !hypertensionReferralFeedbackSupportingInformations.isEmpty()) {
			super.getSection().addAll(hypertensionReferralFeedbackSupportingInformations);
		}
		if (earlyChildhoodNutritionReferralFeedbackSupportingInformations != null && !earlyChildhoodNutritionReferralFeedbackSupportingInformations.isEmpty()) {
			super.getSection().addAll(earlyChildhoodNutritionReferralFeedbackSupportingInformations);
		}
		if (diabetesPreventionReferralFeedbackSupportingInformations != null && !diabetesPreventionReferralFeedbackSupportingInformations.isEmpty()) {
			super.getSection().addAll(diabetesPreventionReferralFeedbackSupportingInformations);
		}
		if (tobaccoUseCessationReferralFeedbackSupportingInformations != null && !tobaccoUseCessationReferralFeedbackSupportingInformations.isEmpty()) {
			super.getSection().addAll(tobaccoUseCessationReferralFeedbackSupportingInformations);
		}
	}
	
	public static SectionComponent createReferralServiceRequestFeedbackSummary(BSERReferralFeedbackComposition comp, Reference bserReferralServiceRequest, List<Reference> bserReferralActivityStatus, String text) {
		SectionComponent section = null;
		if (comp != null && !comp.isEmpty()) {
			section = CommonUtil.findSectionWithCode(comp, BSERReferralFeedbackCompositionUtil.referralFeedbackRequestFeedbackSummarySectionCode);
		}

		if (section != null) {
			// We are updating this. Delete all the entries and reinsert.
			section.getEntry().clear();
		} else {
			section = new SectionComponent();
		}

		if (bserReferralServiceRequest != null && !bserReferralServiceRequest.isEmpty()) {
			section.setFocus(bserReferralServiceRequest);
		} else {
			throw new FHIRException("Referral Service Request Feedback Summary is required in the feedback composition section.");
		}
		if (bserReferralActivityStatus != null && !bserReferralActivityStatus.isEmpty()) {
			section.getEntry().addAll(bserReferralActivityStatus);
		}

		return section;
	}
	
	public static SectionComponent createObesityReferralFeedbackSupportingInformation(BSERReferralFeedbackComposition comp, List<Reference> participationFeedbackObs, 
		Reference bp, Reference bodyHeight, Reference bodyWeight, Reference bmi ) {
		SectionComponent section = null;
		if (comp != null && !comp.isEmpty()) {
			section = CommonUtil.findSectionWithCode(comp, BSERReferralFeedbackCompositionUtil.obesityReferralFeedbackSupportingInformationSectionCode);
		}
	
		if (section != null) {
			// We are updating this. Delete all the entries and reinsert.
			section.getEntry().clear();
		} else {
			section = new SectionComponent();
		}

		if (participationFeedbackObs != null && !participationFeedbackObs.isEmpty()) {
			section.getEntry().addAll(participationFeedbackObs);
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

	public static SectionComponent createArthritisReferralFeedbackSupportingInformation(BSERReferralFeedbackComposition comp, List<Reference> arthritisFeedbackObs) {
		SectionComponent section = null;
		if (comp != null && !comp.isEmpty()) {
			section = CommonUtil.findSectionWithCode(comp, BSERReferralFeedbackCompositionUtil.arthritisReferralFeedbackSupportingInformationSectionCode);
		}

		if (section != null) {
			// We are updating this. Delete all the entries and reinsert.
			section.getEntry().clear();
		} else {
			section = new SectionComponent();
		}

		if (arthritisFeedbackObs != null && !arthritisFeedbackObs.isEmpty()) {
			section.getEntry().addAll(arthritisFeedbackObs);
		}

		return section;
	}

	public static SectionComponent createHypertensionReferralFeedbackSupportingInformation(BSERReferralFeedbackComposition comp, Reference bp, Reference bodyHeight, Reference bodyWeight, Reference bmi) {
		SectionComponent section = null;
		if (comp != null && !comp.isEmpty()) {
			section = CommonUtil.findSectionWithCode(comp, BSERReferralFeedbackCompositionUtil.hypertensionReferralFeedbackSupportingInformationSectionCode);
		}

		if (section != null) {
			// We are updating this. Delete all the entries and reinsert.
			section.getEntry().clear();
		} else {
			section = new SectionComponent();
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

	public static SectionComponent createEarlyChildhoodNutritionReferralFeedbackSupportingInformation(BSERReferralFeedbackComposition comp, List<Reference> earlyChildhoodNutritionFeedbackObs, 
		List<Reference> medicationHistores, List<Reference> participationFeedbackObs) {
		SectionComponent section = null;
		if (comp != null && !comp.isEmpty()) {
			section = CommonUtil.findSectionWithCode(comp, BSERReferralFeedbackCompositionUtil.earlyChildhoodNutritionReferralFeedbackSupportingInformationSectionCode);
		}
	
		if (section != null) {
			// We are updating this. Delete all the entries and reinsert.
			section.getEntry().clear();
		} else {
			section = new SectionComponent();
		}

		if (earlyChildhoodNutritionFeedbackObs != null && !earlyChildhoodNutritionFeedbackObs.isEmpty()) {
			section.getEntry().addAll(earlyChildhoodNutritionFeedbackObs);
		}
		if (medicationHistores != null && !medicationHistores.isEmpty()) {
			section.getEntry().addAll(medicationHistores);
		}
		if (participationFeedbackObs != null && !participationFeedbackObs.isEmpty()) {
			section.getEntry().addAll(participationFeedbackObs);
		}

		return section;
	}

	public static SectionComponent createDiabetesPreventionReferralFeedbackSupportingInformation(BSERReferralFeedbackComposition comp, List<Reference> participationFeedbackObs, 
		Reference bodyHeight, Reference bodyWeight, Reference bmi ) {
		SectionComponent section = null;
		if (comp != null && !comp.isEmpty()) {
			section = CommonUtil.findSectionWithCode(comp, BSERReferralFeedbackCompositionUtil.diabetesPreventionReferralFeedbackSupportingInformationSectionCode);
		}

		if (section != null) {
			// We are updating this. Delete all the entries and reinsert.
			section.getEntry().clear();
		} else {
			section = new SectionComponent();
		}

		if (participationFeedbackObs != null && !participationFeedbackObs.isEmpty()) {
			section.getEntry().addAll(participationFeedbackObs);
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

	public static SectionComponent createTobaccoUseCessationReferralFeedbackSupportingInformation(BSERReferralFeedbackComposition comp, List<Reference> tobaccoUseCessationFeedbackMeds, 
		List<Reference> tobaccoUseCessationFeedbackObs) {
		SectionComponent section = null;
		if (comp != null && !comp.isEmpty()) {
			section = CommonUtil.findSectionWithCode(comp, BSERReferralFeedbackCompositionUtil.tobaccoUseCessationReferralFeedbackSupportingInformationSectionCode);
		}
	
		if (section != null) {
			// We are updating this. Delete all the entries and reinsert.
			section.getEntry().clear();
		} else {
			section = new SectionComponent();
		}

		if (tobaccoUseCessationFeedbackMeds != null && !tobaccoUseCessationFeedbackMeds.isEmpty()) {
			section.getEntry().addAll(tobaccoUseCessationFeedbackMeds);
		}
		if (tobaccoUseCessationFeedbackObs != null && !tobaccoUseCessationFeedbackObs.isEmpty()) {
			section.getEntry().addAll(tobaccoUseCessationFeedbackObs);
		}

		return section;
	}
}
