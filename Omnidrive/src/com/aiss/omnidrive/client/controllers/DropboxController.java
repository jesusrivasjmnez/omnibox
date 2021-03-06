package com.aiss.omnidrive.client.controllers;

import java.util.Map;

import com.aiss.omnidrive.client.views.dropbox.DropboxContextualMenuView;
import com.aiss.omnidrive.client.views.dropbox.DropboxFileDetailsView;
import com.aiss.omnidrive.client.views.dropbox.DropboxFilesListView;
import com.google.gwt.event.dom.client.ContextMenuEvent;
import com.google.gwt.event.dom.client.ContextMenuHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;

public class DropboxController {

	private static final String DEFAULT_OPTION = "showFiles";
	
	public static Boolean isConnect(){
		Boolean connected;
		
		connected = false;
		if (Cookies.getCookie("dropboxToken") != null) {
			connected = true;
		}
		
		return connected;
	}

	public static void disconnect(){
		Cookies.removeCookie("dropboxToken");
	}
	
	public static void show(Map<String, String> params){
		String option;
		
		if (params.containsKey("option")) {
			option = params.get("option");
		} else {
			option = DEFAULT_OPTION;
		}
		
		if (option.equals("showFiles")) {
			DropboxController.showFiles(params);
		} else if (option.equals("showFileDetails")){
			DropboxController.showFileDetails(params);
		}
	}
	
	public static void showFiles(final Map<String, String> params){
		Panel container = RootPanel.get("container");
		DropboxFilesListView filesView = new DropboxFilesListView(params);
		container.clear();
		container.sinkEvents(Event.ONCONTEXTMENU);
		container.addHandler(new ContextMenuHandler() {
			
			@Override
			public void onContextMenu(ContextMenuEvent event) {
				// TODO Auto-generated method stub
				event.preventDefault();
				event.stopPropagation();
				String path = "";
				if (params.containsKey("parent")) {
					path = params.get("parent");
				}
				/*if (params.containsKey("parent")) {
					String[] pathParts = params.get("parent").split("/"); 
					if (pathParts.length > 0) {
						if (pathParts.length == 1) {
							path = "";
						} else if (pathParts.length > 1) {
							for (int i = 0; i < pathParts.length - 1; i++){
								if (!pathParts[i].isEmpty()){
									path += ("/" + pathParts[i]);
								}
							}
						}
					}
				}*/
				Window.alert(path);
				new DropboxContextualMenuView(path, event);
			}
		}, ContextMenuEvent.getType());
		container.add(filesView);
	}
	
	public static void showFileDetails(final Map<String, String> params){
		Panel container = RootPanel.get("container");
		DropboxFileDetailsView fileDetails = new DropboxFileDetailsView(params);
		container.add(fileDetails);
	}
	
}
