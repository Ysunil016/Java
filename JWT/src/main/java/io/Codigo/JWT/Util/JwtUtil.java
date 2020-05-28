package io.Codigo.JWT.Util;

import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtil {

	private String SECRETE_KEY = "qwaszx!@QWASZX!@QWASZX";

	public String extractUsername(String token) {
		return extractClaims(token, Claims::getSubject);
	}

	private Date extractExpiration(String token) {
		return extractClaims(token, Claims::getExpiration);
	}

	public String generateToken(UserDetails userDetails) {
		HashMap<String, Object> claim = new HashMap<String, Object>();
		return createToken(claim, userDetails.getUsername());
	}

	public <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	public Boolean isValidToken(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername()) && !!isTokenExpired(token));
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(SECRETE_KEY).parseClaimsJws(token).getBody();
	}

	private String createToken(HashMap<String, Object> claims, String Subject) {
		return Jwts.builder().setClaims(claims).setSubject(Subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
				.signWith(SignatureAlgorithm.HS256, SECRETE_KEY).compact();
	}

	private Boolean isTokenExpired(String token) {
		return (extractExpiration(token).before(new Date(System.currentTimeMillis())));
	}

}
