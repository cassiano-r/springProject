package br.com.cassiano.springproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import br.com.cassiano.springproject.entity.User;

@Service
public class UserServiceImpl implements UserService{
	
	List<User> users = new ArrayList<>();

	@Override
	public User findById(Integer id) {
		User found = new User();
		found.setId(id);
		
		List<User> list = findAll();
		if(list.contains(found))
		{
			found = list.get(list.indexOf(found));
		}
		return found;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return users;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		users.add(user);
	}

	@Override
	public User update(Integer userId, User user) {
		// TODO Auto-generated method stub
		User foundUser = findById(userId);
		BeanUtils.copyProperties(user, foundUser, "id");
		return foundUser;
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

}
