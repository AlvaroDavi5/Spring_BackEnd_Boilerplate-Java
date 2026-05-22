package com.adtech.springboilerplate.core.infra.database.repositories;

import java.util.LinkedList;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Repository;

import com.adtech.springboilerplate.core.infra.database.models.UsersModel;

@Repository
public interface UserRepository extends JpaRepository<UsersModel, UUID> {
	@SuppressWarnings("null")
	<S extends UsersModel> S save(S entity);

	@SuppressWarnings("null")
	Optional<UsersModel> findById(UUID id);

	UsersModel findByFullName(String fullName);

	@SuppressWarnings("null")
	<S extends UsersModel, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	@SuppressWarnings("null")
	<S extends UsersModel> Optional<S> findOne(Example<S> example);

	@SuppressWarnings("null")
	LinkedList<UsersModel> findAll();

	long count();

	@SuppressWarnings("null")
	<S extends UsersModel> long count(Example<S> example);

	@SuppressWarnings("null")
	void delete(UsersModel entity);

	@SuppressWarnings("null")
	void deleteById(UUID id);
}
