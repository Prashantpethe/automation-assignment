package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;

public class JSONUtility {

	public static Environment readJson(Env env) {
		Gson gson = new Gson(); // to read json used third party lib
//		Note its user.dir not User.dir
		File jsonFile = new File(System.getProperty("user.dir") + "\\config\\config.json");// env related info stored in
																							// json file
		// File jsonFile = new File(System.getProperty("user.dir") + "\\config\\" + env
		// + ".properties");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Config config = gson.fromJson(fileReader, Config.class);
		Environment environment = config.getEnvironments().get("QA");
		System.out.println(environment.getUrl());
		return environment;

	}

}
