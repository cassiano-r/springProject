package br.com.cassiano.springproject.dao;

import java.util.List;

import br.com.cassiano.springproject.entity.User;

public interface UserDAO {
	
	User findById(Integer id);
	
	List<User> findAll();
	
	void save(User user);
	
	void update(User user);
	
	void delete(User user);

}
