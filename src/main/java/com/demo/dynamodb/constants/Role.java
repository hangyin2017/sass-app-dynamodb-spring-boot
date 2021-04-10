package com.demo.dynamodb.constants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Role {

	ADMIN,
	MANAGER,
	SALES,
	INTERN;

	@Override
	@JsonValue
	public String toString() {
		return this.name().toLowerCase();
	}
}
