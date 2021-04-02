package com.demo.dynamodb.constants;

public enum Role {

	ADMIN,
	STAFF,
	USER;

	@Override
	public String toString() {
		return this.name().toLowerCase();
	}
}
