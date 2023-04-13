package tn.com.abt.smw.template;

public class Header {
 
	//Format : dd/MM/yyyy HH:mm:ss
	private String receiveTime;
	//Format : dd/MM/yyyy HH:mm:ss
	private String sendTime; 
	//0000	SUCCESS			
	//1111	SUCCESS (Not Found)	
	//ET00	End transaction : Message sp�cifique 	
	//P000	Parameter Error
	//AD00	Access Denied
	//NA00	Service Not Available
	//A000	Application Error			
	//R000	Remote System Error			
	//N000	Network, Timeout Error			
	//E000	Etc System Error
	//Autres code messages///////////////////////
	//AC00  Account Closed
	//RIP0  Request in process
	//IEA0  Ineligible Account
	private String resultCode;
	private String resultMessage;

	
	public Header(){}
	
	public void setReceiveTime(String receiveTime) {
		this.receiveTime = receiveTime;
	}
	
	public String getReceiveTime() {
		return receiveTime;
	}
	
	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	
	public String getResultCode() {
		return resultCode;
	}
	
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	
	public String getResultMessage() {
		return resultMessage;
	}

	
	
}
