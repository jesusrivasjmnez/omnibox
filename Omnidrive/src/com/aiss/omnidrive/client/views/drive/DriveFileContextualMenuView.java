package com.aiss.omnidrive.client.views.drive;

import com.aiss.omnidrive.client.rpc.DriveService;
import com.aiss.omnidrive.client.rpc.DriveServiceAsync;
import com.aiss.omnidrive.client.rpc.OAuthService;
import com.aiss.omnidrive.client.rpc.OAuthServiceAsync;
import com.aiss.omnidrive.shared.drive.files.DriveFile;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ContextMenuEvent;
import com.google.gwt.user.client.Cookies;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.PopupPanel;

public class DriveFileContextualMenuView extends Composite {

	private final OAuthServiceAsync oauthService = GWT.create(OAuthService.class);
	private final DriveServiceAsync driveService = GWT.create(DriveService.class);
	
	
	public DriveFileContextualMenuView(final DriveFile file, ContextMenuEvent event){
		int positionX, positionY;
		PopupPanel menuContextual = new PopupPanel(true);
		FlowPanel opcionesMenu = new FlowPanel();
		HTML opcionDescarga;
		
		positionX = event.getNativeEvent().getClientX();
		positionY = event.getNativeEvent().getClientY();
		menuContextual.addStyleName("menuContextual");
		menuContextual.setPopupPosition(positionX, positionY);
		
			opcionDescarga = new HTML("Descargar");
			opcionDescarga.addClickHandler(new ClickHandler() {
				
				@Override
				public void onClick(ClickEvent event) {
					// TODO Auto-generated method stub
					driveService.downloadFile(Cookies.getCookie("driveAccessToken"), file.getId(), new AsyncCallback<String>() {
						
						@Override
						public void onSuccess(String downloadFile) {
							// TODO Auto-generated method stub
							Window.open(file.getWebViewLink(), "", "");
						}
						
						@Override
						public void onFailure(Throwable caught) {
							// TODO Auto-generated method stub
							
						}
					});
				}
			});
			opcionesMenu.add(opcionDescarga);
		menuContextual.add(opcionesMenu);
		menuContextual.show();
	}
	
}
