package tn.com.abt.smw.template;

public class ResourceAccessPermission {

	private boolean isAuthorized;
	private String resultCode;
	private String resultMessage;
	private Long idAccessClient;
	private Long idMicroserviceMethod;
	private boolean withChecksumControl;
	private String checksumPassword;

	public ResourceAccessPermission() {

	}

	public boolean isAuthorized() {
		return isAuthorized;
	}

	public String getResultCode() {
		return resultCode;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public Long getIdAccessClient() {
		return idAccessClient;
	}

	public Long getIdMicroserviceMethod() {
		return idMicroserviceMethod;
	}

	public boolean isWithChecksumControl() {
		return withChecksumControl;
	}

	public String getChecksumPassword() {
		return checksumPassword;
	}

	public void setAuthorized(boolean isAuthorized) {
		this.isAuthorized = isAuthorized;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public void setIdAccessClient(Long idAccessClient) {
		this.idAccessClient = idAccessClient;
	}

	public void setIdMicroserviceMethod(Long idMicroserviceMethod) {
		this.idMicroserviceMethod = idMicroserviceMethod;
	}

	public void setWithChecksumControl(boolean withChecksumControl) {
		this.withChecksumControl = withChecksumControl;
	}

	public void setChecksumPassword(String checksumPassword) {
		this.checksumPassword = checksumPassword;
	}

}
