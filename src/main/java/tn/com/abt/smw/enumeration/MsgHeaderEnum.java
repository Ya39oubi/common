package tn.com.abt.smw.enumeration;

public enum MsgHeaderEnum {

	MSG_0000("0000", "SUCCESS"),
	MSG_1111("1111", "SUCCESS (Not Found)"),
	MSG_OK00("OK00", "OK"),
	MSG_KO00("KO00", "Not OK"),
	MSG_TR00("TR00", "Transaction Rejected"),
	MSG_ET00("ET00", "End Transaction : Specific Message"),
	MSG_P000("P000", "Parameter Error"),
	MSG_AD00("AD00", "Access Denied"),
	MSG_NA00("NA00", "Service Not Available"),
	MSG_A000("A000", "Application Error"),
	MSG_R000("R000", "Remote System Error"),
	MSG_N000("N000", "Network, Timeout Error"),
	MSG_E000("E000", "Etc System Error"),
	MSG_AC00("AC00", "Account Closed"),
	MSG_AE00("AE00", "Account Already Exists"),
	MSG_RIP0("RIP0", "Request In Process"),
	MSG_IEA0("IEA0", "Ineligible Account"),
	MSG_ADI0("ADI0", "Account Disabled"),
	MSG_AF00("AF00", "Authentication Failed"),
	MSG_AR00("AR00", "Authentication Rejected"),
	MSG_OL00("OL00", "Overflow Limit"),
	MSG_TE00("TE00", "Token Expired"),
	MSG_UD00("UD00", "User Disabled"),
	MSG_PNF0("PNF0", "Profile not found"),
	MSG_RNF0("RNF0", "Row Not Found"),
	MSG_CPNF("CPNF", "Configuration Parameter Not Found"),
	MSG_CNF0("CNF0", "Customer Not Found");

	private final String id;
	private final String message;

	private MsgHeaderEnum(String id, String message) {
		this.id = id;
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

}
