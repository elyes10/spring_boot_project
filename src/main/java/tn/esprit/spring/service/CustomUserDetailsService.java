package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Client;
import tn.esprit.spring.repository.ClientRepository;
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private ClientRepository repository;

	@Override
	public UserDetails loadUserByUsername(String nom) throws UsernameNotFoundException {
		Client user = repository.findByNom(nom);
		CustomUserDetails userDetails = null;
		if (user != null) {
			userDetails = new CustomUserDetails();
			userDetails.setUser(user);
		} else {
			throw new UsernameNotFoundException("User not found with name :" + nom);
		}
		return userDetails;
	}

}
