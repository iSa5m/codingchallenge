package com.codingchallenge;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class NextNumberServiceTest {
	
	@Autowired
	private NextNumberService service;

	@Test
	public void test1() {
		
		assertEquals("Next number with same set of digits is 12354", service.findNextNumber("12345"));
	}
	
	@Test
	public void test2() {
		
		assertEquals("Next number with same set of digits is 140567", service.findNextNumber("107654"));
	}
	
	@Test
	public void test3() {
		
		assertEquals("This is the greatest number possible with same of digits", service.findNextNumber("54321"));
	}
	
	@Test
	public void test4() {
		
		assertEquals("Invalid Number", service.findNextNumber("abcde"));
	}

}
