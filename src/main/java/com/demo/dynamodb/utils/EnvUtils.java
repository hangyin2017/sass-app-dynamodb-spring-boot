package com.demo.dynamodb.utils;

import com.demo.dynamodb.constants.Env;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EnvUtils {

	private String env;

	@Value("${spring.profiles.active}")
	public void setEnv(String activeEnv) {
		this.env = activeEnv.toUpperCase();
	}

	public Env getEnv() {
		try {
			return Env.valueOf(env);
		} catch (Exception e) {
			return Env.DEV;
		}
	}
}
