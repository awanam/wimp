package com.el.ally.wimp.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="actor")
public class Actor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(length=75, nullable=false)
	private String firstName;
	
	@Column(length=75, nullable=false)
	private String lastName;
	
	@Column(nullable=true)
	private long activeSinceYear;
	
	@Column(nullable=true)
	private Date birthdate;
	
	public Actor() {};
	
	public Actor(String firstName, String lastName, long year, Date date) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.activeSinceYear = year;
		this.birthdate= null;
	}
	
	@ManyToOne(cascade = CascadeType.PERSIST, targetEntity=Movie.class)
    private List<Movie> movie = new ArrayList<Movie>();

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getActiveSinceYear() {
		return activeSinceYear;
	}

	public void setActiveSinceYear(long activeSinceYear) {
		this.activeSinceYear = activeSinceYear;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

}
