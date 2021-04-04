package com.demo.dynamodb.utils;

import com.demo.dynamodb.constants.Env;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class EnvUtils {

	private Env env;

	@Value("${spring.profiles.active}")
	public void setEnv(String activeEnv) {
		try {
			this.env = Env.valueOf(activeEnv.toUpperCase());
		} catch (Exception e) {
			this.env = Env.DEV;
		}
	}

	public boolean isDev() {
		return this.env.equals(Env.DEV);
	}

	public boolean isUat() {
		return this.env.equals(Env.UAT);
	}

	public boolean isProd() {
		return this.env.equals(Env.PROD);
	}
}
