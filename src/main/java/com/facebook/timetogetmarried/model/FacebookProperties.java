package com.facebook.timetogetmarried.model;

import java.io.IOException;
import java.util.Properties;

import br.com.caelum.vraptor.ioc.Component;

@Component
public class FacebookProperties {
	
	private Properties properties;
	
	public FacebookProperties() throws IOException
	{
		properties = new Properties();
		properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("facebook.properties"));
		
	}
	
	public String getClient_id()
	{
		return properties.getProperty("client_id");
	}
	
	public String getClient_secret()
	{
		return properties.getProperty("client_secret");
	}
	
	public String getRedirect_uri()
	{
		return properties.getProperty("redirect_uri");
	}
	
	public String getScope()
	{
		return properties.getProperty("scope");
	}
	
	public String getState()
	{
		return properties.getProperty("state");
	}
	

}
