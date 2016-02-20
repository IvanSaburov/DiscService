package com.discservice.service;

import java.util.List;

import com.discservice.dao.DiscDao;
import com.discservice.dao.UsersDao;

import com.discservice.model.Disc;
import com.discservice.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersDao usersDao;

	@Autowired
	private DiscDao discDao;

	@Override
	@Transactional	
	public void addUsers(Users User) {
		usersDao.addUsers(User);
		
	}

	@Override
	@Transactional
	public Users getUsers(Integer userId) {
		return usersDao.getUsers(userId);
	}

	@Override
	@Transactional
	public void removeUsers(Integer userId) {
		usersDao.removeUsers(userId);
		
	}

	@Override
	public void updateUsers(Users user) {
		usersDao.updateUsers(user);
		
	}

	@Override
	@Transactional
	public List<Users> listUsers() {
		return usersDao.listUsers();
	}

	@Override
	@Transactional
	public List<Disc> listFollows(Integer userId) {
		
		usersDao.getFollows(userId).size();
		return usersDao.getFollows(userId);
	}

	@Override
	@Transactional
	public void addDiscToUsers(Integer userId, Integer discId) {
		
		Users Users = usersDao.getUsers(userId);
		Disc disc = discDao.getDisc(discId);
                disc.setDiscIsFree(false);
		Users.getFollows().add(disc);
		usersDao.updateUsers(Users);
		
	}
        
        @Override
	@Transactional
	public void delDiscFromUsers(Integer userId, Integer discId) {
		
		Users Users = usersDao.getUsers(userId);
		Disc disc = discDao.getDisc(discId);
                disc.setDiscIsFree(true);
		Users.getFollows().remove(disc);
               // disc.getFollowedBy().remove(Users);
		usersDao.updateUsers(Users);
		
	}

        @Override
        @Transactional
        public Users loadUserByUsername(String username) {
                    return usersDao.findByUserName(username);
            }

        @Override
        @Transactional
        public List<Disc> listMyTakenDiscs(Integer userId) {
            usersDao.getMyTakenDiscs(userId).size();
            return usersDao.getMyTakenDiscs(userId);
        }
        
   }
