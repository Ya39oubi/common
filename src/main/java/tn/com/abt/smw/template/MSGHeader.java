package tn.com.abt.smw.template;

public class MSGHeader {

	public static String getResultMessage(String resultCode) {
		String result = "";
		if (resultCode.equals("0000")) {
			result = "SUCCESS";
		} else if (resultCode.equals("1111")) {
			result = "SUCCESS (Not Found)";
		} else if (resultCode.equals("OK00")) {
			result = "OK";
		} else if (resultCode.equals("KO00")) {
			result = "Not OK";
		} else if (resultCode.equals("TR00")) {
			result = "Transaction Rejected";
		} else if (resultCode.equals("ET00")) {
			result = "End Transaction : Specific Message";
		} else if (resultCode.equals("P000")) {
			result = "Parameter Error";
		} else if (resultCode.equals("AD00")) {
			result = "Access Denied";
		} else if (resultCode.equals("NA00")) {
			result = "Service Not Available";
		} else if (resultCode.equals("A000")) {
			result = "Application Error";
		} else if (resultCode.equals("R000")) {
			result = "Remote System Error";
		} else if (resultCode.equals("N000")) {
			result = "Network, Timeout Error";
		} else if (resultCode.equals("E000")) {
			result = "Etc System Error";
		} else if (resultCode.equals("AC00")) {
			result = "Account Closed";
		} else if (resultCode.equals("AE00")) {
			result = "Account Already Exists";
		} else if (resultCode.equals("RIP0")) {
			result = "Request In Process";
		} else if (resultCode.equals("IEA0")) {
			result = "Ineligible Account";
		} else if (resultCode.equals("ADI0")) {
			result = "Account Disabled";
		} else if (resultCode.equals("AF00")) {
			result = "Authentication Failed";
		} else if (resultCode.equals("AR00")) {
			result = "Authentication Rejected";
		} else if (resultCode.equals("OL00")) {
			result = "Overflow Limit";
		} else if (resultCode.equals("TE00")) {
			result = "Token Expired";
		} else if (resultCode.equals("UD00")) {
			result = "User Disabled";
		} else if (resultCode.equals("PNF0")) {
			result = "Profile not found";
		} else if (resultCode.equals("RNF0")) {
			result = "Row Not Found";
		} else if (resultCode.equals("CNF0")) {
			result = "Customer Not Found";
		} else if (resultCode.equals("XXXX")) {
			result = "XXXX";
		} else if (resultCode.equals("XXXX")) {
			result = "XXXX";
		} else if (resultCode.equals("XXXX")) {
			result = "XXXX";
		} else if (resultCode.equals("XXXX")) {
			result = "XXXX";
		} else if (resultCode.equals("XXXX")) {
			result = "XXXX";
		} else if (resultCode.equals("XXXX")) {
			result = "XXXX";
		} else if (resultCode.equals("XXXX")) {
			result = "XXXX";
		} else if (resultCode.equals("XXXX")) {
			result = "XXXX";
		} else if (resultCode.equals("XXXX")) {
			result = "XXXX";
		} else if (resultCode.equals("XXXX")) {
			result = "XXXX";
		}

		return result;
	}
}
