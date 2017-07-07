package br.com.cassiano.springproject.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cassiano.springproject.dao.UserDAO;
import br.com.cassiano.springproject.entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public User findById(Integer id) {
		
		return userDAO.findById(id);
		
	}

	@Override
	public List<User> findAll() {
		
		return userDAO.findAll();
	}

	@Override
	public void save(User user) {
		
		userDAO.save(user);
		
	}

	@Override
	public User update(User user) {		
		User foundUser = findById(user.getId());
		BeanUtils.copyProperties(user, foundUser, "id");
		userDAO.update(foundUser);
		return foundUser;
		
	}

	@Override
	public void delete(User user) {
		
		userDAO.delete(user);
		
	}

	@Override
	public User findByCpf(String cpf) {
		
		return userDAO.findByCpf(cpf);
	}

	@Override
	public List<User> findBy(String lastName, String firstName, String cpf) {
				
		return userDAO.findBy(lastName,firstName,cpf);
	}
	
	@Override
	public User findUsername(String username){
		return userDAO.findUsername(username);
	}

}
