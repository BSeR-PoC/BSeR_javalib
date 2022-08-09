package edu.gatech.chai.BSER.model;

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

	public BSERReferralMessageHeader(Reference receiver, Reference sender,
			Reference focus) {
		super();
		
		CommonUtil.isValidReference(receiver, "PractitionerRole");
		CommonUtil.isValidReference(sender, "PractitionerRole");
		CommonUtil.isValidReference(focus, "Task");
		
		super.setEvent(BSERReferralMessageHeaderUtil.eventCoding);
		super.addDestination(new MessageDestinationComponent()
				.setReceiver(receiver));
		super.setSender(sender);
		super.addFocus(focus);
	}

	public BSERReferralMessageHeader() {
		super();
	}
}