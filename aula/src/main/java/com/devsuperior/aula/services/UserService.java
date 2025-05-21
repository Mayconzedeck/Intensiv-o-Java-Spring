package com.devsuperior.aula.services;

import java.util.Optional;

import com.devsuperior.aula.dto.UserDTO;
import com.devsuperior.aula.entities.User;
import com.devsuperior.aula.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public UserDTO findById(long id) {
		Optional<User> result = repository.findById(id);
		User entity = result
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
		return new UserDTO(entity);
	}
}
