package edu.gatech.chai.BSER.model;

import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.MessageHeader;
import org.hl7.fhir.r4.model.Reference;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import edu.gatech.chai.BSER.model.util.BSERReferralMessageHeaderUtil;
import edu.gatech.chai.BSER.model.util.CommonUtil;

@ResourceDef(name = "MessageHeader", profile = "http://hl7.org/fhir/us/bser/StructureDefinition/BSeR-ReferralMessageHeader")
public class BSERReferralMessageHeader extends MessageHeader{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8031909274044886353L;

	public BSERReferralMessageHeader(){
		super();
	}

	public BSERReferralMessageHeader(Reference receiver, Reference sender,
			Reference focus, String initiatorEndpoint, String recipientEndpoint) {
		super();
		
		CommonUtil.isValidReference(receiver, "PractitionerRole");
		CommonUtil.isValidReference(sender, "PractitionerRole");
		CommonUtil.isValidReference(focus, "Task");
		
		if (recipientEndpoint == null || recipientEndpoint.isEmpty()) {
			throw new FHIRException("BSeR-ReferralMessageHeader.destination.endpoint cannot be null or empty");
		}
		
		if (initiatorEndpoint == null || initiatorEndpoint.isEmpty()) {
			throw new FHIRException("BSeR-ReferralMessageHeader.source.endpoint cannot be null or empty");
		}

		super.setEvent(BSERReferralMessageHeaderUtil.eventCoding);
		super.addDestination(new MessageDestinationComponent()
				.setReceiver(receiver).setEndpoint(recipientEndpoint));
		super.setSource(new MessageSourceComponent().setEndpoint(initiatorEndpoint));
		super.setSender(sender);
		super.addFocus(focus);
	}

	public static boolean isBSERReferralMessageHeader(BSERReferralMessageHeader bserReferralMessageHeader) {
		return BSERReferralMessageHeaderUtil.eventCoding.equalsShallow(bserReferralMessageHeader.getEventCoding());
	}
}