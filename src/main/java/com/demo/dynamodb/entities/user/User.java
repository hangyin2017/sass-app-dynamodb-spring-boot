package com.demo.dynamodb.entities.user;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.Set;

//@Data
@DynamoDBTable(tableName = "user")
public class User {

	@Id
	//@Getter(AccessLevel.NONE)
	//@Setter(AccessLevel.NONE)
	private UserId userKey;

	//@DynamoDBHashKey(attributeName = "userId")
	//private String userId;
	//
	//@DynamoDBRangeKey(attributeName = "updatedAt")
	//private Date updatedAt;

	//@DynamoDBAttribute(attributeName = "createdAt")
	//private Date createdAt;

	public User() {
	}

	public User(UserId userKey) {
		this.userKey = userKey;
	}

	@DynamoDBHashKey(attributeName = "userId")
	public String getUserId() {
		return userKey != null ? userKey.getUserId() : null;
	}

	public void setUserId(String userId) {
		if (userKey == null) {
			userKey = new UserId();
		}
		userKey.setUserId(userId);
	}

	@DynamoDBRangeKey(attributeName = "updatedAt")
	public Date getUpdatedAt() {
		return userKey != null ? userKey.getUpdatedAt() : null;
	}

	public void setUpdatedAt(Date updatedAt) {
		if (userKey == null) {
			userKey = new UserId();
		}
		userKey.setUpdatedAt(updatedAt);
	}

	//@DynamoDBAttribute(attributeName = "userName")
	//private String username;
	//
	//@DynamoDBAttribute(attributeName = "email")
	//private String email;
	//
	//@DynamoDBAttribute(attributeName = "verified")
	//private Boolean isVerified;
	//
	//@DynamoDBAttribute(attributeName = "role")
	//private Set<String> role;
	//
	//@DynamoDBAttribute(attributeName = "companyId")
	//private String companyId;
}
