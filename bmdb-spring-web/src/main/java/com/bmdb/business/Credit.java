package com.bmdb.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Credit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "movieId")
	private Movie movie;
	@ManyToOne
	@JoinColumn(name = "actorId")
	private Actor actor;
	private String role;
	
	public Credit(int id, Movie movie, Actor actor, String role) {
		super();
		this.id = id;
		this.movie = movie;
		this.actor = actor;
		this.role = role;
	}

	public Credit() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Credit [id=" + id + ", movie=" + movie + ", actor=" + actor + ", role=" + role + "]";
	}
}
