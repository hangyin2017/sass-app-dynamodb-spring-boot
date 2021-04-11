package com.demo.dynamodb.entities.user;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@DynamoDBTable(tableName = "user")
public class User {

	@DynamoDBHashKey(attributeName = "userId")
	@DynamoDBAutoGeneratedKey
	private String userId;

	@DynamoDBAttribute(attributeName = "userName")
	private String username;

	@DynamoDBAttribute(attributeName = "email")
	private String email;

	@DynamoDBAttribute(attributeName = "verified")
	private Boolean isVerified;

	@DynamoDBAttribute(attributeName = "role")
	private Set<String> role;

	@DynamoDBAttribute(attributeName = "companyId")
	private String companyId;
}
