package com.aiss.omnidrive.client.controllers;

import java.util.HashMap;
import java.util.Map;

public class MainController {
	
	public static void go(String action){
		go(action, new HashMap<String, String>());
	}
	
	public static void go(String action, Map<String, String> params){
				
		if (action == "index") {
			IndexController.show(params);
		}
	}

}
