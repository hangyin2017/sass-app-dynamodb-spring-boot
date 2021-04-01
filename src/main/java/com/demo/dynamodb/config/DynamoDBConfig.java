package com.demo.dynamodb.config;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.spring.dynamodb.sass.repositories")
public class DynamoDBConfig {

	@Value("${aws.dynamodb.region}")
	private String region;

	@Value("${aws.dynamodb.endpoint}")
	private String dynamoDBEndpoint;

	@Value("${aws.dynamodb.accesskey}")
	private String awsAccessKey;

	@Value("${aws.dynamodb.secretkey}")
	private String awsSecretKey;

	/**
	 * Instantiates Amazon DynamoDB.
	 * @return Amazon DynamoDB instance
	 */
	@Bean
	public AmazonDynamoDB amazonDynamoDB() {
		return AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(getEndpointConfiguration(dynamoDBEndpoint, region))
				.withCredentials(getCredentials(awsAccessKey, awsSecretKey))
				.build();
	}

	/**
	 * Get an AWSCredential Provider using explicit accessKey and secretKey.
	 * @param accessKey AWS access key
	 * @param secretKey AWS secret key
	 * @return A mew AWSCredentialsProvider
	 */
	public AWSCredentialsProvider getCredentials(String accessKey, String secretKey) {
		return new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey));
	}

	/**
	 * Get an AwsClientBuilder EndpointConfiguration using explicit endpoint and region.
	 * @return EndpointConfiguration
	 */
	public AwsClientBuilder.EndpointConfiguration getEndpointConfiguration(String dynamoDBEndpoint, String region) {
		return new AwsClientBuilder.EndpointConfiguration(dynamoDBEndpoint, region);
	}
}
