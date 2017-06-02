package br.com.cassiano.springproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cassiano.springproject.entity.User;

@Controller
public class UserController {
	
	@RequestMapping("/users")
	public String users(ModelMap map){
		User user = new User();
		
		map.addAttribute("user",user);
		return "user";
	}
	
	@RequestMapping("/user/save")
	public String save(User user, ModelMap map){
		
		System.out.println("First Name: " + user.getfirstName());
		System.out.println("Last Name: " + user.getLastName());
		System.out.println("CPF: " + user.getCpf());
		
		user = new User();
		map.addAttribute("user", user);
		return "user";
	}

}
