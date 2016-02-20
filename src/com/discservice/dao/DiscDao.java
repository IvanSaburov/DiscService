package com.discservice.dao;

import java.util.List;

import com.discservice.model.Disc;

public interface DiscDao {

	public abstract List<Disc> getDiscsList();

	public abstract void addDisc(Disc disc);

	public abstract void removeDisc(Integer discId);
        
	public abstract Disc getDisc(Integer discId);
        
        public abstract List<Disc> getMyDisc(String username);
                    
        public abstract List<Disc> getFreeDiscsList();
       
        public abstract List<Disc> getMyTakenDiscsList();
        
        public abstract List<Disc> getTakenFromMeDiscs(String username);
        
	
}
