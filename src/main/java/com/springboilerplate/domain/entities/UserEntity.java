package com.springboilerplate.domain.entities;

import java.util.HashMap;
import java.util.UUID;

import com.springboilerplate.app.user.api.dto.CreateUserDto;
import com.springboilerplate.core.infra.database.models.UsersModel;

public class UserEntity {
	private UUID id;
	private String fullName;

	public UserEntity(CreateUserDto dataValues) {
		if (dataValues != null) {
			this.fullName = dataValues.fullName();
		}
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public void fromModel(UsersModel model) {
		if (model == null)
			return;

		this.setId((UUID) model.getId());
		this.setFullName((String) model.getFullName());
	}

	public UsersModel toModel() {
		UsersModel model = new UsersModel();

		model.setFullName(this.getFullName());

		return model;
	}

	public void fromHashMap(HashMap<String, Object> map) {
		if (map == null)
			return;

		this.setFullName((String) map.get("fullName"));
	}

	public HashMap<String, Object> toHashMap() {
		HashMap<String, Object> map = new HashMap<String, Object>();

		map.put("fullName", this.getFullName());

		return map;
	}
}
