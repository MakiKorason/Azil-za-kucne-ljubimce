package com.ftninformatika.jwd.test.service.impl;

import com.ftninformatika.jwd.test.model.Korisnik;
import com.ftninformatika.jwd.test.service.KorisnikService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private KorisnikService korisnikService;


	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Korisnik korisnik = korisnikService.findbyKorisnickoIme(username).orElse(null);

		if (korisnik == null) {
			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
		} else {
			List<GrantedAuthority> grantedAuthorities = new ArrayList<>();


			String role = "ROLE_" + korisnik.getUloga().toString();

			grantedAuthorities.add(new SimpleGrantedAuthority(role));

			return new org.springframework.security.core.userdetails.User(
					korisnik.getKorisnickoIme().trim(),
					korisnik.getLozinka().trim(),
					grantedAuthorities);
		}
	}
}
