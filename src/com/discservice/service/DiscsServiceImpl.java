package com.discservice.service;

import java.util.List;

import com.discservice.dao.DiscDao;
import com.discservice.model.Disc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DiscsServiceImpl implements DiscsService {

	@Autowired
	DiscDao discDao;
	
	@Transactional	
	@Override
	public void addDisc(Disc disc) {
		discDao.addDisc(disc);
		
	}
	@Transactional	
	@Override
	public void removeDisc(Integer discId) {
		discDao.removeDisc(discId);
		
	}
	@Transactional	
	@Override
	public List<Disc> listDiscs() {
		return discDao.getDiscsList();
	}
        @Transactional
        @Override
        public List<Disc> listFreeDiscs() {
        return discDao.getFreeDiscsList();
        }
        @Transactional
        @Override
        public List<Disc> MyTakenDiscsList() {
            return discDao.getMyTakenDiscsList();
        }

        @Override
        public List<Disc> TakenFromMeDiscsList(String username) {
            return discDao.getTakenFromMeDiscs(username);
        }

        @Override
        public List<Disc> MyDiscsList(String username) {
            return discDao.getMyDisc(username);
        }


}
