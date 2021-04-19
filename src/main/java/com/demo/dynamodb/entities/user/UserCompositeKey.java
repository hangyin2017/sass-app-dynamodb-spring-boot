package com.demo.dynamodb.entities.user;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserCompositeKey implements Serializable {
	private static final long serialVersionUID = 1L;

	@DynamoDBHashKey(attributeName = "userId")
	private String userId;

	@DynamoDBRangeKey(attributeName = "createdAt")
	private Date createdAt;
}

