package com.aiss.omnidrive.client.views.onedrive;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.aiss.omnidrive.client.controllers.DriveController;
import com.aiss.omnidrive.client.controllers.MainController;
import com.aiss.omnidrive.client.rpc.OAuthService;
import com.aiss.omnidrive.client.rpc.OAuthServiceAsync;
import com.aiss.omnidrive.client.rpc.OnedriveService;
import com.aiss.omnidrive.client.rpc.OnedriveServiceAsync;
import com.aiss.omnidrive.shared.OAuthToken;
import com.aiss.omnidrive.shared.drive.files.DriveFile;
import com.aiss.omnidrive.shared.onedrive.files.OnedriveFile;
import com.aiss.omnidrive.shared.onedrive.files.OnedriveFilesList;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Panel;

public class OnedriveFilesListView extends Composite {

	private final OAuthServiceAsync oauthService = GWT.create(OAuthService.class);
	private final OnedriveServiceAsync onedriveService = GWT.create(OnedriveService.class);
	
	public OnedriveFilesListView(){
		new OnedriveFilesListView(new HashMap<String, String>());
	}
	
	public OnedriveFilesListView(final Map<String, String> params){
		final Panel content, infoBar;
		final String parent;
		final DriveFile parentFile;
		final Panel directorioAnterior;
		if (DriveController.isConnect()) {
			content = new FlowPanel();
			if (!DriveController.hasToken()) {
				oauthService.refreshToken("onedrive", Cookies.getCookie("onedriveToken"), new AsyncCallback<OAuthToken>() {
					@Override
					public void onSuccess(OAuthToken token) {
						// TODO Auto-generated method stub
						if (token.isCorrect()){
							Date tokenAccessExpireIn = new Date(new Date().getTime() + (token.getExpiresIn() * 1000));
							Cookies.setCookie("onedriveAccessToken", token.getAccessToken(), tokenAccessExpireIn);
						} else {
							Cookies.removeCookie("onedriveToken");
							Window.Location.replace(GWT.getHostPageBaseURL());
						}
					}
					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}
				});
			}
			if (params.containsKey("parent")) {
				parent = params.get("parent");
			} else {
				parent = "root";
			}
			infoBar = new FlowPanel();
			infoBar.addStyleName("infobar");
			onedriveService.getFile(Cookies.getCookie("onedriveAccessToken"), parent, new AsyncCallback<OnedriveFile>() {
				@Override
				public void onSuccess(final OnedriveFile file) {
					// TODO Auto-generated method stub
					if (file.getParentReference() != null) {
						Anchor botonVolver = new Anchor("<");
						botonVolver.removeStyleName("gwt-Anchor");
						botonVolver.addClickHandler(new ClickHandler() {
							
							@Override
							public void onClick(ClickEvent event) {
								// TODO Auto-generated method stub
								params.put("parent", file.getParentReference().getId());
								MainController.go("onedrive", params);
							}
						});
						infoBar.add(botonVolver);
						infoBar.add(new HTML(file.getName()));
					} else {
						infoBar.add(new HTML("Mis archivos"));
					}
					//infoBar.add(directorioAnterior);
					content.add(infoBar);
				}
				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					
				}
			});
				
			onedriveService.getFiles(Cookies.getCookie("onedriveAccessToken"), parent, new AsyncCallback<OnedriveFilesList>() {
				
				@Override
				public void onSuccess(OnedriveFilesList files) {
					// TODO Auto-generated method stub
					for(OnedriveFile file : files.getFiles()){
						content.add(new OnedriveFileView(params, file));
					}
				}
				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					
				}
			});
			content.addStyleName("paddingContent");
			initWidget(content);
		} else {
			Window.Location.replace(GWT.getHostPageBaseURL());
		}
	}
}
