package com.aiss.omnidrive.client.controllers;

import com.google.gwt.user.client.Cookies;

public class DriveController {

	public static Boolean isConnect(){
		Boolean connected;
		
		connected = false;
		if (Cookies.getCookie("driveToken") != null) {
			connected = true;
		}
		
		return connected;
	}
	
}
