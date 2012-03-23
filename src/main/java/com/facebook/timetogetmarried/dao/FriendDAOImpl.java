package com.facebook.timetogetmarried.dao;

import java.util.ArrayList;
import java.util.List;

import com.facebook.timetogetmarried.model.FacebookUser;
import com.restfb.Connection;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.modified.User;


public class FriendDAOImpl implements FriendDAO {

	private FacebookClient facebookClient;
	
	public FriendDAOImpl(FacebookClient facebookClient) {
		this.facebookClient = facebookClient;
	}

	@Override
	public List<FacebookUser> married(User user) {
		String query = "SELECT uid, name, birthday_date, "
				+ "education, relationship_status FROM user WHERE (uid = "
				+ user.getId()
				+ "OR uid IN (SELECT uid2 FROM friend WHERE uid1 = "
				+ user.getId() + ")) " + "AND relationship_status='Married' ";

		List<User> users = facebookClient.executeQuery(query, User.class);
		
		return usersToFriends(users);
	}

	@Override
	public List<FacebookUser> all(User user) {

		Connection<User> users = facebookClient.fetchConnection("me/friends",
				User.class, Parameter.with("fields",
						"id,name,birthday,education,relationship_status"));

		return usersToFriends(users.getData());
	}

	private List<FacebookUser> usersToFriends(List<User> users) {
		List<FacebookUser> friends = new ArrayList<FacebookUser>();
		for (User friend : users) {
			friends.add(new FacebookUser(friend));
		}

		return friends;

	}

}
