package com.demo.dynamodb.repositories;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.demo.dynamodb.constants.Role;
import com.demo.dynamodb.entities.user.User;
import lombok.RequiredArgsConstructor;
import org.socialsignin.spring.data.dynamodb.core.DynamoDBTemplate;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
public class MyUserRepositoryImpl implements MyUserRepository {

	private final DynamoDBTemplate dynamoDBTemplate;

	@Override
	public List<User> findByRole(Role role) {
		HashMap<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
		eav.put(":v1", new AttributeValue().withS(role.toString()));

		// To resolve the conflict with reserved keyword 'role'.
		HashMap<String, String> ean = new HashMap<String, String>();
		ean.put("#role", "role");

		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
				.withFilterExpression("contains(#role, :v1)")
				.withExpressionAttributeValues(eav)
				.withExpressionAttributeNames(ean);

		List<User> users =  dynamoDBTemplate.scan(User.class, scanExpression);
		return users;
	}

	@Override
	public List<User> findByCompanyId(String companyId) {
		HashMap<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
		eav.put(":v1", new AttributeValue().withS(companyId));

		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
				.withFilterExpression("companyId=:v1")
				.withExpressionAttributeValues(eav);

		List<User> users =  dynamoDBTemplate.scan(User.class, scanExpression);
		return users;
	}
}
