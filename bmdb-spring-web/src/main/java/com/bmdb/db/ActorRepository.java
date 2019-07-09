package com.bmdb.db;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.bmdb.business.Actor;

public interface ActorRepository extends CrudRepository<Actor, Integer> {
	
	Optional<Actor> findByBirthDate(String birthDate);

}
