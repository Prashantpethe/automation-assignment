package com.ui.pojo;

import java.util.Map;

public class Config {
	//config.java depicts config.json
	//Environment.java depicts env which are inconfig.json
	//Map used to store configurational info
	Map<String,Environment> environments;

	public Map<String, Environment> getEnvironments() {
		return environments;
	}

	public void setEnvironments(Map<String, Environment> environments) {
		this.environments = environments;
	}

}
