package com.facebook.timetogetmarried.controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

import com.facebook.timetogetmarried.model.FacebookUser;
import com.facebook.timetogetmarried.model.Friends;
import com.restfb.DefaultFacebookClient;

@Resource
public class UserController {

	private final Result result;

	private DefaultFacebookClient facebookClient;

	public UserController(final Result result) {
		this.result = result;

	}

	@Post("/should_I_get_married")
	public void userShouldGetMarried() {

		Friends friends = new Friends(facebookClient);
	}
	
	
	@Path("/login/{token}")
	public void login(String token)
	{
		facebookClient = new DefaultFacebookClient(token);
		FacebookUser facebookUser = new FacebookUser(facebookClient);
		result.include(facebookUser);
		
		
	}

}
