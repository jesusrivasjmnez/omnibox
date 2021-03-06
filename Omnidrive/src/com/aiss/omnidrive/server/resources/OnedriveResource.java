package com.aiss.omnidrive.server.resources;

import java.io.File;
import java.io.IOException;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

import com.aiss.omnidrive.shared.drive.files.DriveFile;
import com.aiss.omnidrive.shared.onedrive.files.OnedriveFile;
import com.aiss.omnidrive.shared.onedrive.files.OnedriveFilesList;
import com.aiss.omnidrive.shared.onedrive.user.OnedriveUserInfo;

public class OnedriveResource {

	private static final String BASE_URL = "https://api.onedrive.com/v1.0";
	private static final String TYPE_TOKEN = "Bearer";

	public static OnedriveUserInfo getUserInfo(String token) {
		OnedriveUserInfo userInfo;
		ClientResource connection;
		ChallengeResponse authorization;

		connection = new ClientResource(BASE_URL + "/drive");
		authorization = new ChallengeResponse(new ChallengeScheme("OAuth2", TYPE_TOKEN));
		authorization.setRawValue(token);
		connection.setChallengeResponse(authorization);

		userInfo = connection.get(OnedriveUserInfo.class);

		
		return userInfo;
	}

	public static OnedriveFilesList getFiles(String token, String parent) {
		OnedriveFilesList files;
		ClientResource connection;
		ChallengeResponse authorization;

		connection = new ClientResource(BASE_URL + "/drive/items/" + parent + "/children");
		authorization = new ChallengeResponse(new ChallengeScheme("OAuth2",TYPE_TOKEN));
		authorization.setRawValue(token);
		connection.setChallengeResponse(authorization);

		files = connection.get(OnedriveFilesList.class);

		return files;
	}

	public static OnedriveFile getFile(String token, String idFile) {
		OnedriveFile file;
		ClientResource connection;
		ChallengeResponse authorization;

		connection = new ClientResource(BASE_URL + "/drive/items/" + idFile);
		authorization = new ChallengeResponse(new ChallengeScheme("OAuth2",TYPE_TOKEN));
		authorization.setRawValue(token);
		connection.setChallengeResponse(authorization);

		file = connection.get(OnedriveFile.class);

		return file;
	}
	
	public static String downloadFile(String token, String idFile) {
		File file;
		Representation downloadContent;
		String content = "";
		ClientResource connection;
		ChallengeResponse authorization;
		String q;

		connection = new ClientResource(BASE_URL + "/files/" + idFile + "?alt=media");
		authorization = new ChallengeResponse(new ChallengeScheme("OAuth2",TYPE_TOKEN));
		authorization.setRawValue(token);
		connection.setChallengeResponse(authorization);
		try {
		downloadContent = connection.get();
		content = downloadContent.getText();
		} catch (IOException e) {
			
		}
		return content;
	}
}
