package com.rentacar.auth_service.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rentacar.auth_service.model.Korisnik;
import com.rentacar.auth_service.model.Privilege;
import com.rentacar.auth_service.model.Role;
import com.rentacar.auth_service.repository.KorisnikRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private KorisnikRepository kr;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Korisnik korisnik = kr.findOneByUsername(username);
		if (korisnik == null) {
			throw new UsernameNotFoundException(String.format("Korisnik sa username: '%s' nije pronadjen.", username));
		} else {
			return korisnik;
		}
	}

	private Collection<? extends GrantedAuthority> getAuthorities(Role uloga) {
		return getGrantedAuthorities(getPrivilegije(uloga));
	}

	private Collection<Privilege> getPrivilegije(Role uloga) {
		return uloga.getPrivilegije();
	}

	private List<GrantedAuthority> getGrantedAuthorities(Collection<Privilege> privilegije) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (Privilege p : privilegije) {
			authorities.add(new SimpleGrantedAuthority(p.getName()));
		}
		return authorities;
	}

}
