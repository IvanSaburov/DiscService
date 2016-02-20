package com.discservice.service;

import java.util.List;

import com.discservice.model.Disc;
import com.discservice.model.Users;



public interface UsersService {
	
public void addUsers(Users user);
	
	public Users getUsers(Integer userId);
	
	public void removeUsers(Integer userId);
	
	public void updateUsers(Users user);
	
	public List<Users> listUsers();
	
	public List<Disc> listFollows(Integer usesrId);
	
	public void addDiscToUsers(Integer userId,Integer discId);
        
        public void delDiscFromUsers(Integer userId,Integer discId);
        
        public Users loadUserByUsername(String username);
	
        public List<Disc> listMyTakenDiscs(Integer usesrId);
}
