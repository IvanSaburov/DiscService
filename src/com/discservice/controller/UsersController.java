package com.discservice.controller;

import java.util.List;

import com.discservice.model.Users;
import com.discservice.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UsersController {

	@Autowired
	private UsersService usersService;

	@RequestMapping("/users")
	public String listUsers(ModelMap model){
		model.addAttribute("user",new Users());
		List<Users> users = usersService.listUsers();
		model.addAttribute("usersList",users);
                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                String name = auth.getName(); //get username
                model.addAttribute("username", name);
                Users us = usersService.loadUserByUsername(name);
                int uid = us.getUserId();
                model.addAttribute("usId", uid);
                
		return "users";
	}
	
 	@RequestMapping(value = "/addusers", method = RequestMethod.POST)
        public String addUsers(@ModelAttribute("user")
                Users user, BindingResult result) {
                usersService.addUsers(user);
                
                return "redirect:/users";
        }
 
    @RequestMapping("/delete/{userId}")
    public String deleteUsers(@PathVariable("userId")Integer userId) {
                usersService.removeUsers(userId);
                
                return "redirect:/users";
        }
	
}
