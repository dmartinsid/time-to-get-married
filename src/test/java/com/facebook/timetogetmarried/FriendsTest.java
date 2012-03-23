package com.facebook.timetogetmarried;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Before;
import org.junit.Test;

import com.facebook.timetogetmarried.model.FacebookUser;
import com.facebook.timetogetmarried.model.Friends;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;

public class FriendsTest {
	

	private FacebookClient facebookClient;
	private Friends friends;
	
	private String readTokenFile() throws IOException
	{
		FileInputStream fileInputStream= new FileInputStream("token.token");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

		return bufferedReader.readLine();
	}
	
	@Before
	public void setup() throws IOException
	{
		facebookClient = new DefaultFacebookClient(readTokenFile());	
		friends = new Friends(facebookClient);
		
	}

	@Test
	public void shouldReturnMarriedFriends() throws IOException 
	{	
		
		for (FacebookUser friend : friends.married()) {
			assertEquals("Married", friend.getRelationshipStatus());
		
		}

	}

}
