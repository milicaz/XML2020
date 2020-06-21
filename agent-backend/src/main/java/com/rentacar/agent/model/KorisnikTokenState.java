package com.rentacar.agent.model;

/*JWT model*/
public class KorisnikTokenState {

	private String accessToken;
	private Long expiresIn;

	public KorisnikTokenState() {
		this.accessToken = null;
		this.expiresIn = null;
	}

	public KorisnikTokenState(String accessToken, long expiresIn) {
		super();
		this.accessToken = accessToken;
		this.expiresIn = expiresIn;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}

}
