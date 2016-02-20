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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DiscsController {

	@Autowired
	private DiscsService discsService;
        @Autowired
	private UsersService usersService;
	
	@RequestMapping("/discs")
	public String listDiscs(Map<String, Object> map, ModelMap model){
		map.put("disc",new Disc());
		List<Disc> disc = discsService.listDiscs();
		map.put("discsList",disc);
                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                String name = auth.getName(); //get username
		model.addAttribute("username", name); 
                
		return "discs";
              	}
	
	@RequestMapping(value = "/adddisc", method = RequestMethod.POST)
	public String addDisc(@ModelAttribute("disc")
                Disc disc, BindingResult result) {
                discsService.addDisc(disc);
            
                return "redirect:/discs";
                }
        
        @RequestMapping("/discs/delete/{discId}")
        public String deleteDiscs(@PathVariable("discId")Integer discId) {
                discsService.removeDisc(discId);
                
                return "redirect:/discs";
                }
        
	@RequestMapping("/freediscs")
	public String listFreeDiscs(Map<String, Object> map, ModelMap model){
		map.put("disc",new Disc());
		List<Disc> disc = discsService.listFreeDiscs();
		map.put("discsList",disc);
                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                String name = auth.getName(); //get username
                model.addAttribute("username", name);
                Users us = usersService.loadUserByUsername(name);
                
		return "freediscs";
            }
}
