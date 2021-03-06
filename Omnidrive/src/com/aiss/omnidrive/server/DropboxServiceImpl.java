package com.aiss.omnidrive.server;

import com.aiss.omnidrive.client.rpc.DropboxService;
import com.aiss.omnidrive.server.resources.DropboxResource;
import com.aiss.omnidrive.shared.dropbox.files.DropboxFile;
import com.aiss.omnidrive.shared.dropbox.files.DropboxFilesList;
import com.aiss.omnidrive.shared.dropbox.user.DropboxUserInfo;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class DropboxServiceImpl extends RemoteServiceServlet implements DropboxService{
	
	public DropboxUserInfo getUserInfo(String token){
		DropboxUserInfo userInfo;
		
		userInfo = DropboxResource.getUserInfo(token);
		userInfo.clearAdditionalProperties();
		userInfo.getQuotaInfo().clearAdditionalProperties();
		
		return userInfo;
	}
	
	public DropboxFilesList getFiles(String token, String parent){
		DropboxFilesList files;
		
		
		files = DropboxResource.getFiles(token, parent);
		files.clearAdditionalProperties();
		for (DropboxFile file : files.getEntries()) {
			file.clearAdditionalProperties();
		}
		
		return files;
	}
	
	public DropboxFile getFile(String token, String path){
		DropboxFile file;
				
		file = DropboxResource.getFile(token, path);
		file.clearAdditionalProperties();
		
		return file;
	}
}
