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
@Table(name="users")
public class Users {

	@Id
	@GeneratedValue
	private Integer userId;
	
	@ManyToMany
	@JoinTable(name="takenItem"
		,joinColumns=@JoinColumn(name="userId")
		,inverseJoinColumns=@JoinColumn(name="discId"))
	private List<Disc> follows;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String firstname;
	
	@Column
	private String lastname;
	
        @Column
	private boolean enabled=true;
        
        @Column
	private String authority="ROLE_USER";
        
	@Column
	private String email;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<Disc> getFollows() {
		return follows;
	}

	public void setFollows(List<Disc> follows) {
		this.follows = follows;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
        public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

        public String getAuthority() {
            return authority;
        }

        public void setAuthority(String authority) {
            this.authority = authority;
        }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
