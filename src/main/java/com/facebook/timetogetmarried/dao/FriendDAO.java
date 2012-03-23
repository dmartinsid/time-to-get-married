package com.facebook.timetogetmarried.dao;

import java.util.List;

import com.facebook.timetogetmarried.model.FacebookUser;
import com.restfb.types.modified.User;

public interface FriendDAO {
	
	public List<FacebookUser> married(User user);
	public List<FacebookUser> all(User user);


}
