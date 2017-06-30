package br.com.cassiano.springproject.service;
import br.com.cassiano.springproject.entity.User;
import br.com.cassiano.springproject.generic.JPAGenreric;

public interface UserService extends JPAGenreric<User>{
		
	User findByCpf(String cpf);
		
}
