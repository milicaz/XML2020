package com.rentacar.auth_service.security.auth;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import com.rentacar.auth_service.security.TokenHelper;

/*The JWT token filer, configured in WebSecurityConfig*/
/*Filter koji ce presretati svaki zahtev klijenta ka serveru.
 * Sem na putanjama navedenim u WebSecurityConfig.configure(WebSecurity web)*/
public class TokenAuthenticationFilter extends OncePerRequestFilter {

	private TokenHelper tokenHelper;
	private UserDetailsService userDetailsService;

	public TokenAuthenticationFilter(TokenHelper tokenHelper, UserDetailsService userDetailsService) {
		super();
		this.tokenHelper = tokenHelper;
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String username;
		//izvuci token iz request-a
		String authToken = tokenHelper.getToken(request);
		if (authToken != null) {
			//uzmi username iz tokena
			username = tokenHelper.getUsernameFromToken(authToken);
			if (username != null) {
				//uzmi user-a na osnovu username-a
				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				//proveri da li je prosledjeni token validan
				if (tokenHelper.validateToken(authToken, userDetails)) {
					// create authentication
					TokenBasedAuthentication authentication = new TokenBasedAuthentication(userDetails);
					authentication.setToken(authToken);
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			}
		}
		filterChain.doFilter(request, response);
	}

}
