package com.facebook.timetogetmarried.security;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import com.facebook.timetogetmarried.model.FacebookProperties;

public class FacebookAuth {
	
	private String code;
	private FacebookProperties facebookProperties;

	public FacebookAuth(String code, FacebookProperties facebookProperties) throws IOException 
	{
		this.code = code;
		this.facebookProperties = facebookProperties;
		
	}

	private List<NameValuePair> getParameters() 
	{
	
		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		parameters.add(new BasicNameValuePair("client_id", facebookProperties.getClient_id()));
		parameters.add(new BasicNameValuePair("client_secret",facebookProperties.getClient_secret()));
		parameters.add(new BasicNameValuePair("redirect_uri", facebookProperties.getRedirect_uri()));
		parameters.add(new BasicNameValuePair("code", code));
		
		return parameters;
	}
	
	public String requestAccessToken() throws ClientProtocolException, IOException
	{
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost("https://graph.facebook.com/oauth/access_token");

		UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(getParameters());
		post.setEntity(formEntity);

		HttpResponse response = client.execute(post);
		
		return extractToken(response);
		
		
	}

	private String extractToken(HttpResponse response) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent()));


		String message = "";
		String lineData;
		
		while ((lineData = reader.readLine()) != null) {
			message += lineData;
		}
		return getQueryVariable(message, "access_token");

	}
	
	private String getQueryVariable(String query, String variable) {
		  
		  String[] parameters = query.split("&");
		  
		  for (String parameter : parameters) {
			  String[] pair = parameter.split("=");
			  if(pair[0].equals(variable))
				  return pair[1];
		  }
			
		  return null;
		}


}
