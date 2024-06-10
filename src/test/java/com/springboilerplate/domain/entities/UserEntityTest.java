package com.springboilerplate.domain.entities;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserEntityTest {
	private UserEntity airport = new UserEntity(null);

	@Test
	public void testInstantiation() {
		assertEquals("", this.airport.getId());
		assertEquals("Name", this.airport.getFullName());
	}
}
