package edu.gatech.chai.BSER.model.util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.UUID;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.Resource;

public class CommonUtil {
	public static String bserCodeSystemUrl = "http://hl7.org/fhir/us/bser/CodeSystem/bser";
	
	public Resource assignUUID(Resource resource) {
		return (Resource)resource.setId(new IdType(UUID.randomUUID().toString()));
	}
	
	public static boolean isValidReference(Reference reference,String sourceType) {
		String[] referenceComponents = reference.getReference().split("/");
		if(referenceComponents.length < 2) {
			throw new FHIRException("Tried to create reference from the string '"+reference.getReference()+"'but did not find"
					+ " any forward slashes.");
		}
		String targetId = referenceComponents[referenceComponents.length - 1];
		String targetType = referenceComponents[referenceComponents.length - 2];
		if(targetType != sourceType) {
			throw new FHIRException("Tried to create reference from the string '"+reference.getReference()+"'expected"
					+ " a resource type of '"+sourceType+"' but instead found '"+targetType+"'.");
		}
		if(referenceComponents.length > 2) {
			String[] urlComponents = Arrays.copyOfRange(referenceComponents, 0, referenceComponents.length - 2);
			String urlFull = String.join("", urlComponents);
			try {
				URL url = new URL(urlFull);
			} catch (MalformedURLException e) {
				throw new FHIRException("Validating Base Url of reference and found issue.", e);
			}
			
		}
		return true;
	}
}
