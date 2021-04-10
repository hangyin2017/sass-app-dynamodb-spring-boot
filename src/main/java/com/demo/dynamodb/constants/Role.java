package com.demo.dynamodb.constants;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Role {

	ADMIN,
	STAFF,
	USER;

	@Override
	@JsonValue
	public String toString() {
		return this.name().toLowerCase();
	}
}
