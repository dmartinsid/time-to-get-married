package com.facebook.timetogetmarried.model;

import java.util.List;

import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.Years;

import com.restfb.Facebook;
import com.restfb.FacebookClient;
import com.restfb.types.modified.User;
import com.restfb.types.modified.User.Education;

public class FacebookUser {

	@Facebook
	private User user;

	private boolean ageEstimated;
	private Years age;

	public FacebookUser(User user) {
		this.user = user;
	}
	
	public FacebookUser(FacebookClient facebookClient)
	{
		this.user = facebookClient.fetchObject("me", User.class);
	}
	
	

	private DateMidnight getBirthday() 
	{
		return user.getBirthdayAsDateMidnight();
	}

	public Integer getAge() {
		calculateAge(getBirthday());
		
		return age.getYears();
	}



	private void calculateAge(DateMidnight birthdate) {
		if (birthdate != null) {
			age = Years.yearsBetween(birthdate, new DateTime());
		} else {
			age = estimateAge();
		}
	}

	private Years estimateAge() {
		ageEstimated = true;
		List<Education> educations = user.getEducation();

		AgeCalculator ageCalculator = new AgeCalculator();
		return ageCalculator.byEducation(educations, user.getBirthday());
	}

	

	public String getRelationshipStatus() {
		return user.getRelationshipStatus();
	}
	
	public String getName()
	{
		return user.getName();
	}

	public boolean ageWasEstimated()
	{
		return ageEstimated;
	}
	
	public String getBirthdayDate()
	{
		return user.getBirthday();
	}
	
	public String toString()
	{
		return "name: " + user.getName() + "\n" + 
				"birthday: " + user.getBirthday() + "\n" + user.getBirthdayAsDate() +  "\n" + 
				"Relationship " + user.getRelationshipStatus() + "\n";
	}
	
}
