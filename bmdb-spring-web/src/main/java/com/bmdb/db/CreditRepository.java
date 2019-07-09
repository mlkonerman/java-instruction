package com.bmdb.db;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.bmdb.business.Credit;

public interface CreditRepository extends CrudRepository<Credit, Integer> {

	Optional<Credit> findByRole(String role);

}
