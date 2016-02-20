package com.discservice.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.discservice.model.Disc;
import com.discservice.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsersDaoImpl implements UsersDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addUsers(Users user) {
		sessionFactory.getCurrentSession().save(user);
		
	}

	@Override
	public List<Users> listUsers() {
		return sessionFactory.getCurrentSession().createQuery("from Users").list();
	}

	@Override
	public void removeUsers(Integer userId) {
		Users user = (Users)sessionFactory.getCurrentSession().load(Users.class, userId);
		
		if(null!=user){
			sessionFactory.getCurrentSession().delete(user);
		}
	}

	@Override
	public Users getUsers(Integer userId) {
		Users user = (Users)sessionFactory.getCurrentSession().load(Users.class, userId);
		return user;
	}

	@Override
	public List<Disc> getFollows(Integer userId) {
		Session session =  sessionFactory.getCurrentSession();
		Users user = (Users)session.load(Users.class,userId);
		return user.getFollows();
	}

	@Override
	public void updateUsers(Users user) {
		sessionFactory.getCurrentSession().update(user);
		
	}

        @SuppressWarnings("unchecked")  
        public Users findByUserName(String username) {
                List<Users> users = new ArrayList<Users>();
                users = sessionFactory.getCurrentSession().createQuery("from Users where username=?").setParameter(0, username).list();
                if (users.size() > 0) {
                    return users.get(0);
                } else {
                    return null;
                }
        }

        @Override
        public List<Disc> getMyTakenDiscs(Integer userId) {
                Session session =  sessionFactory.getCurrentSession();
                Users user = (Users)session.load(Users.class,userId);
                return user.getFollows();
        }
}
