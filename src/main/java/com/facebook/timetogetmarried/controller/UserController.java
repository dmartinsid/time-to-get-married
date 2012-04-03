package com.facebook.timetogetmarried.controller;

import java.io.IOException;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

import com.facebook.timetogetmarried.model.FacebookProperties;
import com.facebook.timetogetmarried.model.FacebookUser;
import com.facebook.timetogetmarried.security.AccessToken;
import com.facebook.timetogetmarried.security.FacebookAuth;
import com.restfb.DefaultFacebookClient;

@Resource
public class UserController {

	private final Result result;
	private DefaultFacebookClient facebookClient;
	private AccessToken accessToken;
	private FacebookProperties facebookProperties;

	public UserController(final Result result, AccessToken accessToken, FacebookProperties facebookProperties) {
		this.result = result;
		this.accessToken = accessToken;
		this.facebookProperties = facebookProperties;
	}
	
	@Path("/")
	public void index() {
		result.include(facebookProperties);
		
	}


	@Path("/logged")
	public void logged() {
		facebookClient = new DefaultFacebookClient(accessToken.getToken());
		FacebookUser facebookUser = new FacebookUser(facebookClient);
		result.include(facebookUser);

	}

	@Path("/oauth2")
	public void oauth2(String state, String code)
			throws IOException
	{
		FacebookAuth facebookAuth = new FacebookAuth(code, facebookProperties);	
		accessToken.setToken(facebookAuth.requestAccessToken());
		
		result.redirectTo("/logged");
	}

	

}
