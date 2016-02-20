package com.discservice.dao;

import java.util.List;


import com.discservice.model.Disc;
import com.discservice.model.Users;

public interface UsersDao {

	  public void addUsers(Users user);

	  public List<Users> listUsers();

	  public void removeUsers(Integer userId);

	  public Users getUsers(Integer userId);

	  public List<Disc> getFollows(Integer userId);
	  
	  public void updateUsers(Users user);
          
         public Users findByUserName(String username);
         
         public List<Disc> getMyTakenDiscs(Integer userId);
}
