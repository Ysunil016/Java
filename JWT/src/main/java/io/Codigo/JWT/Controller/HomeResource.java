package io.Codigo.JWT.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.Codigo.JWT.Model.AuthRequest;
import io.Codigo.JWT.Model.AuthResponse;
import io.Codigo.JWT.Util.JwtUtil;

@RestController
public class HomeResource {

	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	private JwtUtil jwtUtil;

	@GetMapping(value = "/home")
	public String homeRoute() {
		return "Welcome to Home";
	}

	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> AuthRoute(@RequestBody AuthRequest authReq) throws Exception {
		try {
			authManager.authenticate(
					new UsernamePasswordAuthenticationToken(authReq.getUsername(), authReq.getPassword()));
		} catch (Exception e) {
			throw new Exception("Error In Username and Password");
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authReq.getUsername());
		final String jwtKey = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthResponse(jwtKey));
	}

}
