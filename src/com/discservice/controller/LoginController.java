package com.discservice.controller;
 
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
@RequestMapping("/login")
public class LoginController {
 
	@RequestMapping(method = RequestMethod.GET)
	public String success(ModelMap map) {
                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                String name = auth.getName(); //get username
		
                map.addAttribute("username", name);

		return "freediscs";
 
	}
 
}