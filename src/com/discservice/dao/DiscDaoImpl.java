package com.discservice.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import com.discservice.model.Disc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DiscDaoImpl implements DiscDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Disc> getDiscsList() {
		return sessionFactory.getCurrentSession().createQuery("from Disc").list();// TODO Auto-generated method stub
		
	}

	@Override
	public void addDisc(Disc disc) {
		sessionFactory.getCurrentSession().save(disc);// TODO Auto-generated method stub
		
	}

	@Override
	public void removeDisc(Integer discId) {
		Disc disc = (Disc)sessionFactory.getCurrentSession().load(Disc.class, discId);
		
		if(null!=disc){
			sessionFactory.getCurrentSession().delete(disc);
		}
		
	}
	@Override
	public Disc getDisc(Integer discId) {
		return (Disc)sessionFactory.getCurrentSession().get(Disc.class, discId);
	}

        @Override
        public List<Disc> getFreeDiscsList() {
                return sessionFactory.getCurrentSession().createQuery("from Disc where discIsFree='1'").list();
        }

        @Override
        public List<Disc> getMyTakenDiscsList() {
                return sessionFactory.getCurrentSession().createQuery("from Disc where discIsFree='0'").list();
        }

        @Override
        public List<Disc> getTakenFromMeDiscs(String username) {
        return sessionFactory.getCurrentSession().createQuery("from Disc where discIsFree='0' and discOwner = '"+ username +"'").list();
        }

        @Override
        public List <Disc> getMyDisc(String username) {
        return sessionFactory.getCurrentSession().createQuery("from Disc where discOwner = '"+ username +"'").list();
        }
}
