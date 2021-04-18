package com.demo.dynamodb.entities.user;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class UserId implements Serializable {
	private static final long serialVersionUID = 1L;

	@DynamoDBHashKey(attributeName = "userId")
	private String userId;

	@DynamoDBRangeKey(attributeName = "updatedAt")
	private Date updatedAt;
}

