package com.aiss.omnidrive.client.views;

import java.util.Map;

import com.aiss.omnidrive.client.views.drive.DriveMenuView;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class SidenavView extends Composite {
	
	public SidenavView(Map<String, String> params){
		Panel sidenav,  sidenavFooter; 
		StackLayoutPanel sidenavMenu;
		Widget driveHeader, onedriveHeader, dropboxHeader, disconnectHeader;
		
		sidenav = new FlowPanel();
		
		initWidget(sidenav);
		sidenav.getElement().setId("sidenav");
		sidenav.addStyleName("sidenav");
		
		sidenavMenu = new StackLayoutPanel(Unit.PC);
		sidenavMenu.addStyleName("sidenavMenu");
		
		driveHeader = createHeader("Google Drive");
		disconnectHeader = createHeader("Desconectar");
		disconnectHeader.addStyleName("disconnectHeader");
		
		sidenavMenu.add(new DriveMenuView(params), driveHeader, 3.0);
		sidenavMenu.add(new SimplePanel(), disconnectHeader, 3.0);
		
		sidenav.add(sidenavMenu);
	}

	private Widget createHeader(String text) {
	    // Add the image and text to a horizontal panel
	    HorizontalPanel hPanel = new HorizontalPanel();
	    hPanel.setHeight("100%");
	    hPanel.setSpacing(0);
	    hPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
	    hPanel.addStyleName("sidenavMenuHeader");
	    HTML headerText = new HTML(text);
	    hPanel.add(headerText);
	    return new SimplePanel(hPanel);
	  }
	
}
