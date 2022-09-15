package edu.gatech.chai.BSER.model.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Composition;
import org.hl7.fhir.r4.model.Composition.SectionComponent;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.Resource;

public class CommonUtil {
	public static String bserCodeSystemUrl = "http://hl7.org/fhir/us/bser/CodeSystem/bser";
	
	public static Resource assignUUID(Resource resource) {
		return (Resource)resource.setId(new IdType(UUID.randomUUID().toString()));
	}
	
	public static SectionComponent findSectionWithCode(Composition composition, CodeableConcept code) {
		for(Coding coding:code.getCoding()) {
			SectionComponent returnSection = findSectionWithCode(composition,coding);  
			if(returnSection != null) {
				return returnSection;
			}
		}
		return null;
	}
	
	public static SectionComponent findSectionWithCode(Composition composition, Coding coding) {
		for(SectionComponent section: composition.getSection()) {
			for(Coding sourceCoding:section.getCode().getCoding()) {
				if(sourceCoding.equalsShallow(coding)) {
					return section;
				}
			}
		}
		return null;
	}
	
	public static SectionComponent findSectionWithCode(Composition composition, String code) {
		for(SectionComponent section: composition.getSection()) {
			for(Coding sourceCoding:section.getCode().getCoding()) {
				if(sourceCoding.getCode().equalsIgnoreCase(code) || sourceCoding.getDisplay().equalsIgnoreCase(code)) {
					return section;
				}
			}
		}
		return null;
	}
	
	public static boolean isValidReference(Reference reference,String sourceType) {
		if (sourceType.equals(reference.getReferenceElement().getResourceType())) {
			return true;
		} else {
			throw new FHIRException("Tried to create reference '"+reference.getReference()+"', which is not " + sourceType);
		}
		// String[] referenceComponents = reference.getReference().split("/");
		// if(referenceComponents.length < 2) {
		// 	throw new FHIRException("Tried to create reference from the string '"+reference.getReference()+"'but did not find"
		// 			+ " any forward slashes.");
		// }
		// String targetId = referenceComponents[referenceComponents.length - 1];
		// String targetType = referenceComponents[referenceComponents.length - 2];
		// if(!targetType.equals(sourceType)) {
		// 	throw new FHIRException("Tried to create reference from the string '"+reference.getReference()+"'expected"
		// 			+ " a resource type of '"+sourceType+"' but instead found '"+targetType+"'.");
		// }
		// if(referenceComponents.length > 2) {
		// 	String[] urlComponents = Arrays.copyOfRange(referenceComponents, 0, referenceComponents.length - 2);
		// 	String urlFull = String.join("", urlComponents);
		// 	try {
		// 		URL url = new URL(urlFull);
		// 	} catch (MalformedURLException e) {
		// 		throw new FHIRException("Validating Base Url of reference and found issue.", e);
		// 	}
			
		// }
		// return true;
	}

	public static CodeableConcept findConceptFromCollectionUsingSimpleString(String key,Collection<CodeableConcept> collection) {
		for(CodeableConcept conceptIter:collection) {
			for (Coding codingIter: conceptIter.getCoding())
			if(codingIter.getCode().equalsIgnoreCase(key) || codingIter.getDisplay().equalsIgnoreCase(key)) {
				return conceptIter;
			}
		}
		return null;
	}

	public static CodeableConcept initiatorIdentifierType() {
		return new CodeableConcept(new Coding("http://terminology.hl7.org/CodeSystem/v2-0203", "PLAC", null));
	}

	public static CodeableConcept recipientIdentifierType() {
		return new CodeableConcept(new Coding("http://terminology.hl7.org/CodeSystem/v2-0203", "FILL", null));
	}
}
