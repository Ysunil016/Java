package io.Codigo.JWT.Filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.Codigo.JWT.Service.PersonalUserDetailsService;
import io.Codigo.JWT.Util.JwtUtil;

@Component
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	private PersonalUserDetailsService userDetailService;
	@Autowired
	private JwtUtil jwtUtils;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		System.out.println("In JWT Filter");

		final String authHeader = request.getHeader("Authorization");
		String username = null;
		String JWT = null;

		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			JWT = authHeader.substring(7);
			username = jwtUtils.extractUsername(JWT);
			System.out.println("Username " + username);
		}

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = userDetailService.loadUserByUsername(username);
			jwtUtils.isValidToken(JWT, userDetails);

			UsernamePasswordAuthenticationToken userToken = new UsernamePasswordAuthenticationToken(userDetails, null,
					userDetails.getAuthorities());
			userToken.setDetails(new WebAuthenticationDetails(request));
			SecurityContextHolder.getContext().setAuthentication(userToken);
		}
		filterChain.doFilter(request, response);
	}

}
