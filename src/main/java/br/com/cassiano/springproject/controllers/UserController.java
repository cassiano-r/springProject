package br.com.cassiano.springproject.controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cassiano.springproject.entity.User;
import br.com.cassiano.springproject.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	private AtomicInteger incrementId = new AtomicInteger();
		
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView users(ModelMap map){
		
		ModelAndView model = new ModelAndView("user");
		User user = new User();
		List<User> users = userService.findAll();
		
		map.addAttribute("user",user);
		map.addAttribute("users",users);
		
		return model;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String save(User user, ModelMap map){
				
		userService.save(user);		
		user = new User();
		user.setId(incrementId.incrementAndGet());
		map.addAttribute("user", user);
		map.addAttribute("users",userService.findAll());
		
		return "user";
	}
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.PUT)
	public ModelAndView update(@PathVariable("userId") Integer userId, User user)
	{
		ModelAndView view = new ModelAndView("user");
		user = userService.update(userId, user);
		view.addObject("user",user);
		
		return view;
	}
	
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public String getById(@PathVariable("userId") Integer userId, ModelMap map)
	{
		User found = new User();
		found.setId(userId);
		
		List<User> list = userService.findAll();
		if(list.contains(found))
		{
			found = list.get(list.indexOf(found));
		}
		map.addAttribute("user", found);
		map.addAttribute("user", list);
		return "user";
	}
	

}
