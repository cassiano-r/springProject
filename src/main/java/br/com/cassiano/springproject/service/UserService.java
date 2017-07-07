package br.com.cassiano.springproject.service;
import java.util.List;

import br.com.cassiano.springproject.entity.User;
import br.com.cassiano.springproject.generic.JPAGenreric;

public interface UserService extends JPAGenreric<User>{
		
	User findByCpf(String cpf);

	List<User> findBy(String lastName, String firstName, String cpf);

	User findUsername(String username);
		
}
