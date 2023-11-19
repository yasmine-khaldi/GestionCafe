package com.example.JWT;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repository.UserRep;
/*
@Service
public class CustomerUsersDetailsService implements UserDetailsService {

	
	@Autowired
	UserRep userRep;

	private com.example.model.User userDetails;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("Inside loadUserByUsername {}", username);
		userDetails = userRep.findByEmailId(username);
		if (!Objects.isNull(userDetails))
			return new User(userDetails.getEmail(), userDetails.getPassword(), new ArrayList<>());
		else
			throw new UsernameNotFoundException("User Not Found.");
	}

	public com.example.model.User getUserDetail() {

		com.example.model.User user = userDetails;
		user.setPassword(null);
		return userDetails;

	}
}*/
