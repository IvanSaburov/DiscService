package com.discservice.controller;

import java.util.List;
import java.util.Map;


import com.discservice.model.Disc;
import com.discservice.model.Users;
import com.discservice.service.DiscsService;
import com.discservice.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsersDiscsController {

	@Autowired
	UsersService usersService;
	
	@Autowired
	DiscsService discsService;
	
	@ModelAttribute("offeredDiscs")
	public List<Disc> populateOfferedDiscs(){
		return discsService.listDiscs();
	}

	@RequestMapping("/mydiscs")
	public String listMyDiscs(ModelMap model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                String name = auth.getName(); //get username
                
		model.addAttribute("discsList", discsService.MyDiscsList(name));
                
		return "mydiscs";
              	}
        
        @RequestMapping("/mydiscs/delete/{discId}")
        public String deleteDiscs(@PathVariable("discId")Integer discId) {
                discsService.removeDisc(discId);
                return "redirect:/mydiscs";
                }
        
        @RequestMapping(value = "freediscs/take/{discId}")
        public String addUserDiscs(Map<String, Object> map,ModelMap model,@PathVariable("discId")Integer discId) {
                map.put("disc",new Disc());
 		List<Disc> disc = discsService.listFreeDiscs();
                model.addAttribute("discsList", disc);
                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                
                String name = auth.getName(); //get username
                Users us = usersService.loadUserByUsername(name);
                int userId = us.getUserId();
                
		usersService.addDiscToUsers(userId, discId);
                
                return "redirect:/freediscs";
                }
        
        @RequestMapping("freediscs/mytakendiscs")
	public String listMyTakenDiscs(ModelMap model){
                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                String name = auth.getName(); //get username
                Users us = usersService.loadUserByUsername(name);
                int userId = us.getUserId();
		model.addAttribute("discsList", usersService.listMyTakenDiscs(userId));
		Users user = usersService.getUsers(userId);
		model.addAttribute("user",user);
                model.addAttribute("usId",userId);
		
		return "mytakendiscs";
                }
    
        @RequestMapping(value = "freediscs/mytakendiscs/returndisc/{discId}")
        public String delUserDiscs(ModelMap model,@PathVariable("discId")Integer discId) {
                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                String name = auth.getName(); //get username
                Users us = usersService.loadUserByUsername(name);
                int userId = us.getUserId();
                
		usersService.delDiscFromUsers(userId, discId);
                
                model.addAttribute("usId", userId);
                return "redirect:/freediscs/mytakendiscs";
               }
	
        @RequestMapping("discsfromme")
	public String TakenFromMeDiscsList(ModelMap model){
                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                String name = auth.getName(); //get username
                List<Disc> disc = discsService.TakenFromMeDiscsList(name);
                model.addAttribute("discsList", disc);
		
		
		return "discsfromme";
                }
}
