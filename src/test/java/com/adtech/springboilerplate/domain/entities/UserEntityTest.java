package com.adtech.springboilerplate.domain.entities;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserEntityTest {
	private UserEntity user = new UserEntity(null, "My Name");

	@Test
	public void testInstantiation() {
		assertEquals(null, this.user.getId());
		assertEquals("My Name", this.user.getFullName());
	}
}
