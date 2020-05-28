package io.Codigo.JWT.Model;

public class AuthResponse {

	private String JWT;

	public AuthResponse(String jWT) {
		this.JWT = jWT;
	}

	public String getJWT() {
		return JWT;
	}

}
