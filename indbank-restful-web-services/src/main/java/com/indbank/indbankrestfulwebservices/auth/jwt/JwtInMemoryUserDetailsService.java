package com.indbank.indbankrestfulwebservices.auth.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

	static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

	static {
		inMemoryUserList.add(new JwtUserDetails(1L, "in28minutes",
				"$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e", "ROLE_USER_2"));
		inMemoryUserList.add(new JwtUserDetails(2L, "ranga",
				"$2a$10$IetbreuU5KihCkDB6/r1DOJO0VyU9lSiBcrMDT.biU7FOt2oqZDPm", "ROLE_USER_2"));
		inMemoryUserList.add(new JwtUserDetails(3L, "pushkar",
				"$2a$10$sEo1xipGYyNTEq0g3b1CxeR2XW6qTAnIo6tgkf6SG0NFfmb8d6aRy", "ROLE_USER_2"));
		
		
		// dummy
		//eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwdXNoa2FyIiwiZXhwIjoxNTk0MDM3MjQwLCJpYXQiOjE1OTM0MzI0NDB9.ptt6kF-u5olctHuQUREQIkeMvpmGuRddtTKNu6RJp5n_YMXh35mrzPpcTVopqmmPN0WyVL8bLK4rqonzL8icSw
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
				.filter(user -> user.getUsername().equals(username)).findFirst();

		if (!findFirst.isPresent()) {
			throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
		}

		return findFirst.get();
	}

}
