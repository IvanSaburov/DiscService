package com.discservice.service;

import java.util.List;
import com.discservice.model.Disc;



public interface DiscsService {
	public void addDisc(Disc disc);
	public void removeDisc(Integer discId);
	public List<Disc> listFreeDiscs();
	public List<Disc> listDiscs();
        public List<Disc> MyDiscsList(String username);
        public List<Disc> MyTakenDiscsList();
        public List<Disc> TakenFromMeDiscsList(String username);
}
