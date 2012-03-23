package com.facebook.timetogetmarried;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.joda.time.Years;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import com.facebook.timetogetmarried.model.AgeCalculator;
import com.facebook.timetogetmarried.model.FacebookUser;
import com.restfb.types.NamedFacebookType;
import com.restfb.types.modified.User;
import com.restfb.types.modified.User.Education;

public class AgeCalculatorTest {
	

	private AgeCalculator ageCalculator;

	private @Mock Education highSchoolducation;
	private @Mock NamedFacebookType highSchoolYear;
	
	private @Mock Education collegeEducation;
	private @Mock NamedFacebookType collegeYear;
	
	private @Mock List educations;
	private @Mock Iterator iterador;
	
	
	@Before
	public void setup()
	{
		initMocks(this);
		ageCalculator = new AgeCalculator();
		highSchoolMocks();
		collegeMocks();	
		
	}
	
	private void highSchoolMocks()
	{
		when(highSchoolducation.getType()).thenReturn("High School");
		when(highSchoolYear.getName()).thenReturn("2004");
		when(highSchoolducation.getYear()).thenReturn(highSchoolYear);
		
	}
	
	private void collegeMocks()
	{
		when(collegeEducation.getType()).thenReturn("College");
		when(collegeYear.getName()).thenReturn("2012");
		when(collegeEducation.getYear()).thenReturn(collegeYear);
	}
	
	@Test
	public void shouldEstimateAgeByHighSchool() 
	{
		when(iterador.hasNext()).thenReturn(true, false);
		when(educations.iterator()).thenReturn(iterador);
		when(educations.iterator().next()).thenReturn(highSchoolducation);
	
		String birthdate = "06/20";
		assertEquals(Years.years(24), ageCalculator.byEducation(educations, birthdate));

	}
	
	@Test
	public void shouldEstimateAgeByHighSchoolWhenBirthdayIsNull() 
	{
		when(iterador.hasNext()).thenReturn(true, false);
		when(educations.iterator()).thenReturn(iterador);
		when(educations.iterator().next()).thenReturn(highSchoolducation);
	
		String birthdate = null;
		assertEquals(Years.years(25), ageCalculator.byEducation(educations, birthdate));

	}

	@Test
	public void shouldEstimateAgeByCollegeWhenBirthdayIsNull() 
	{

		when(iterador.hasNext()).thenReturn(true, false);
		when(educations.iterator()).thenReturn(iterador);
		when(educations.iterator().next()).thenReturn(collegeEducation);

		String birthdate = null;
		assertEquals(Years.years(22), ageCalculator.byEducation(educations, birthdate));
	}
	
	@Test
	public void shouldEstimateAgeByCollege() 
	{

		when(iterador.hasNext()).thenReturn(true, false);
		when(educations.iterator()).thenReturn(iterador);
		when(educations.iterator().next()).thenReturn(collegeEducation);


		String birthdate = "02/15";
		assertEquals(Years.years(22), ageCalculator.byEducation(educations, birthdate));
	}
	
	@Test
	public void shouldConsiderEstimageAgeByHighSchoolFirst()
	{
		when(iterador.hasNext()).thenReturn(true, true, false);
		when(educations.iterator()).thenReturn(iterador);
		when(educations.iterator().next()).thenReturn(collegeEducation, highSchoolducation);

		String birthdate = "06/20";
		assertEquals(Years.years(24), ageCalculator.byEducation(educations, birthdate));
		
	}

}
