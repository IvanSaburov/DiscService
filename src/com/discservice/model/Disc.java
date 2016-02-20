package com.discservice.model;

import java.util.List;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="disc")
public class Disc {
	@Id
	@GeneratedValue
	private Integer discId;
	
	@ManyToMany
	@JoinTable(name="takenItem"
		,joinColumns=@JoinColumn(name="discId")
		,inverseJoinColumns=@JoinColumn(name="userId"))
	private List<Users> followedBy;
	@Column
	private String discName;
        @Column
	private String genre;
        @Column
	private Integer discyear;
        @Column
	private String discOwner;
        @Column
        private boolean discIsFree=true;

        public boolean isDiscIsFree() {
            return discIsFree;
        }

        public void setDiscIsFree(boolean discIsFree) {
            this.discIsFree = discIsFree;
        }

	public String getDiscName() {
		return discName;
	}

	public void setDiscName(String discName) {
		this.discName = discName;
	}
	
	
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Integer getDiscyear() {
		return discyear;
	}

	public void setDiscyear(Integer discyear) {
		this.discyear = discyear;
	}

	public Integer getDiscId() {
		return discId;
	}

	public void setDiscId(Integer discId) {
		this.discId = discId;
	}

	public List<Users> getFollowedBy() {
		return followedBy;
	}

	public void setFollowedBy(List<Users> followedBy) {
		this.followedBy = followedBy;
	}

	public String getDiscOwner() {
		return discOwner;
	}

	public void setDiscOwner(String discOwner) {
		this.discOwner = discOwner;
	}
}
