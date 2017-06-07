package br.com.cassiano.springproject.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
		
		map.addAttribute("user", user);
		map.addAttribute("users",userService.findAll());
		
		return "user";
	}

}
