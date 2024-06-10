package com.springboilerplate.core.infra.database.models;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class UsersModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	@Column(name = "fullName", unique = false, length = 100, nullable = false)
	private String fullName;

	public UsersModel() {
	}

	public UUID getId() {
		return this.id;
	};

	public void setId(UUID id) {
		this.id = id;
	};

	public String getFullName() {
		return this.fullName;
	};

	public void setFullName(String fullName) {
		this.fullName = fullName;
	};
}
