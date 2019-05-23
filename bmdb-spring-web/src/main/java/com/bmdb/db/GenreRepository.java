package com.bmdb.db;

import org.springframework.data.repository.CrudRepository;

import com.bmdb.business.Genre;

public interface GenreRepository extends CrudRepository<Genre, Integer> {

}
