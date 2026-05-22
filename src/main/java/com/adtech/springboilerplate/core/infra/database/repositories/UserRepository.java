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
	<S extends UsersModel> S save(S entity);

	Optional<UsersModel> findById(UUID id);

	UsersModel findByFullName(String fullName);

	<S extends UsersModel, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	<S extends UsersModel> Optional<S> findOne(Example<S> example);

	LinkedList<UsersModel> findAll();

	long count();

	<S extends UsersModel> long count(Example<S> example);

	void delete(UsersModel entity);

	void deleteById(UUID id);
}
