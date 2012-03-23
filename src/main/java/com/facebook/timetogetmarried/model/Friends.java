package com.facebook.timetogetmarried.model;

import java.text.NumberFormat;
import java.util.List;

import com.facebook.timetogetmarried.dao.FriendDAO;
import com.facebook.timetogetmarried.dao.FriendDAOImpl;
import com.restfb.FacebookClient;
import com.restfb.types.modified.User;

public class Friends {

	private User user;
	private List <FacebookUser> friends;
	private List<FacebookUser> married;
	private FriendDAO friendDAO;

	public Friends(FacebookClient facebookClient) {
		this.user = facebookClient.fetchObject("me", User.class);
		this.friendDAO = new FriendDAOImpl(facebookClient);
		this.friends = friendDAO.all(user);
		this.married = friendDAO.married(user);
	}

	public List<FacebookUser> married() {
		return married;
	}

	public List<FacebookUser> all() {
		return friends;
	}

	public String marriedPercentage() {
		Double percentage = ((double) married().size() / (double) friends.size());
		return NumberFormat.getPercentInstance().format(percentage);

	}
	

	
	public Double averageMarriedAge()
	{
		Double media = new Double(0);
		Integer countAgeNotVerified = 0;
		for(FacebookUser friend: married)
		{
			
			media = media + friend.getAge();
			if(friend.getAge() == 0)
				countAgeNotVerified++;
		}
		return media/(married.size()-countAgeNotVerified);
	}
}
