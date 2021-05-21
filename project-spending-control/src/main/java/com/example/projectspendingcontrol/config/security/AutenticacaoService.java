package com.example.projectspendingcontrol.config.security;

import com.example.projectspendingcontrol.entity.User;
import com.example.projectspendingcontrol.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Profile(value = {"prod", "dev"})
public class AutenticacaoService implements UserDetailsService {
	
	@Autowired
	private UserRepo repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> usuario = repository.findByEmail(username);
		if (usuario.isPresent()) {
			return usuario.get();
		}
		
		throw new UsernameNotFoundException("Dados inválidos!");
	}

}
