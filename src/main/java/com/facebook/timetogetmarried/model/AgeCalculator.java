package com.facebook.timetogetmarried.model;

import java.util.List;

import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.Years;

import com.restfb.types.modified.User.Education;

public class AgeCalculator {
	
	private boolean estimatedByHighSchool;
	private Years age;
	
	private final Integer highSchoolFinishAge = 17;
	private final Integer collegeFinishAge = 22;

	public AgeCalculator()
	{
		age = Years.years((0));
	}
	public Years byEducation(List<Education> educations, String birthday)
	{
		for (Education education : educations) 
		{
			if(estimatedByHighSchool) 
				break;
			
			if (isValidEducation(education)) 
			{
				estimateAge(birthday, education);
				
			}

		}
		
		return age;
	}
	
	private Integer finishAge(Education education)
	{
		if (education.getType().equals("High School")) 
		{	
			estimatedByHighSchool = true;
			return highSchoolFinishAge;
		}
		else
			return collegeFinishAge;
	}
	
	private void estimateAge(String birthday, Education education) 
	{
		DateTime now = new DateTime();
		DateMidnight birthdate = birthdate(birthday, education);
		age = Years.yearsBetween(birthdate, now);
				
	
		
	}
	
	private DateMidnight birthdate(String birthday, Education education)
	{
		Integer monthOfYear;
		Integer dayOfMonth;
		if(birthday != null)
		{
			monthOfYear = Integer.valueOf(birthday.substring(0, 2));
			dayOfMonth = Integer.valueOf(birthday.substring(3, 5));
			
		}
		else
		{
			DateTime now = new DateTime();
			monthOfYear = now.getMonthOfYear();
			dayOfMonth = now.getDayOfMonth();
		}
		Integer year = birthYear(education);
		
		return new DateMidnight(year, monthOfYear, dayOfMonth);
	}
	
	private boolean isValidEducation(Education education)
	{
		if (education.getType() != null)
			if(education.getYear() != null)
				if(education.getYear().getName() != null)
					return true;
		
		return false;
		
	}
	
	private Integer birthYear(Education education)
	{
		return Integer.valueOf(education.getYear().getName()) - finishAge(education);
		
	}

}
