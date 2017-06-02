package br.com.cassiano.springproject.controllers;




import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cassiano.springproject.entity.User;

@Controller
public class UserController {
	
	private List<User> users = new ArrayList<>();
	
	@RequestMapping("/users")
	public ModelAndView users(ModelMap map){
		ModelAndView model = new ModelAndView("user");
		User user = new User();		
		map.addAttribute("user",user);
		map.addAttribute("users",users);
		return model;
	}
	
	@RequestMapping("/user/save")
	public String save(User user, ModelMap map){
		
		System.out.println("First Name: " + user.getfirstName());
		System.out.println("Last Name: " + user.getLastName());
		System.out.println("CPF: " + user.getCpf());
		users.add(user);
		
		user = new User();
		map.addAttribute("user", user);
		map.addAttribute("users",users);
		return "user";
	}

}
