package com.demo.dynamodb.repositories;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.demo.dynamodb.entities.user.User;
import lombok.RequiredArgsConstructor;
import org.socialsignin.spring.data.dynamodb.core.DynamoDBTemplate;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
public class MyCompanyRepositoryImpl implements MyCompanyRepository {

	private final DynamoDBTemplate dynamoDBTemplate;

	@Override
	public List<User> findUserByCompany(String companyId) {
		HashMap<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
		eav.put(":v1", new AttributeValue().withS(companyId));

		DynamoDBScanExpression scanExpression = new DynamoDBScanExpression()
				.withFilterExpression("companyId=:v1)")
				.withExpressionAttributeValues(eav);

		List<User> users =  dynamoDBTemplate.scan(User.class, scanExpression);
		return users;
	}
}
