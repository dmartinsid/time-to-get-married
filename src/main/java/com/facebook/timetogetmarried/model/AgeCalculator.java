package com.facebook.timetogetmarried.model;

import java.util.List;

import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.Years;

import com.restfb.types.modified.User.Education;

public class AgeCalculator {
	
	private boolean estimatedByHighSchool;
	private Years age;

	public AgeCalculator()
	{
		age = Years.years((0));
	}
	public Years byEducation(List<Education> educations, String birthday)
	{
		for (Education education : educations) {

			if (education.getType() != null && !estimatedByHighSchool) 
			{

				if (education.getType().equals("High School")) 
				{
					estimateAge(birthday, education, 17);

				} 
				else if (education.getType().equals("College")) 
				{
					estimateAge(birthday, education, 22);

				}
			}

		}
		
		return age;
	}
	
	private void estimateAge(String birthday, Education education, int finishAge) 
	{
		if (education.getYear() != null && education.getYear().getName() != null && birthday != null) 
		{
			Integer monthOfYear = Integer.valueOf(birthday.substring(0, 2));
			Integer dayOfMonth = Integer.valueOf(birthday.substring(3, 5));

			DateTime now = new DateTime();
			
			Integer year = (Integer.valueOf(education.getYear().getName())- finishAge);
			DateMidnight birthdate = new DateMidnight(year,	monthOfYear, dayOfMonth);
			
			age = Years.yearsBetween(birthdate, now);
			
			if(education.getType().equals("High School"))
				estimatedByHighSchool = true;
		}
	}

}
