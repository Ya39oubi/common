package tn.com.abt.smw.security;

public class AccessTokenMapper {

	private String accessToken;
	private Long idAccessClient;
	private String id;
	private String userName;
	private String name;

	public AccessTokenMapper() {
		
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Long getIdAccessClient() {
		return idAccessClient;
	}

	public void setIdAccessClient(Long idAccessClient) {
		this.idAccessClient = idAccessClient;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}