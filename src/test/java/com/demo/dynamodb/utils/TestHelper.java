package com.demo.dynamodb.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestHelper {

	@Autowired private ObjectMapper objectMapper;

	public String asJsonString(final Object obj) throws JsonProcessingException {
		return objectMapper.writeValueAsString(obj);
	}
}
