package com.aiss.omnidrive.client.rpc;

import com.aiss.omnidrive.shared.OAuthToken;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("oauth")
public interface OAuthService extends RemoteService {
	
	String getAuthUrl(String service); 
	
	OAuthToken getToken(String service, String code);
	
	OAuthToken refreshToken(String service, String refreshToken);
}
