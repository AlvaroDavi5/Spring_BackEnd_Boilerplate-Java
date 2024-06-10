package com.springboilerplate.core.infra.database.repositories;

import java.util.LinkedList;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboilerplate.core.infra.database.models.UsersModel;

@Repository
public interface UserRepository extends JpaRepository<UsersModel, UUID> {
	@SuppressWarnings("null")
	<UM extends UsersModel> UM save(UM entity);

	@SuppressWarnings("null")
	Optional<UsersModel> findById(UUID id);

	UsersModel findByFullName(String fullName);

	@SuppressWarnings("null")
	LinkedList<UsersModel> findAll();

	long count();

	@SuppressWarnings("null")
	void delete(UsersModel entity);
}
