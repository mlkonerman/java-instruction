package com.bmdb.db;

import org.springframework.data.repository.CrudRepository;

import com.bmdb.business.MovieGenre;

public interface MovieGenreRepository extends CrudRepository<MovieGenre, Integer> {

}
