package RetailMeNot;

import org.junit.Test;

import junit.framework.Assert;

public class StringWheelDistance {

	@Test
	public void test1() {
		String s = "BZA";
		Assert.assertEquals(4, findDis(s));
	}
	
	@Test
	public void test2() {
		String s = "NA";
		Assert.assertEquals(26, findDis(s));
	}

	private Object distanceWheel(String s) {
		//first element is A
		//iterate the string 
		// if charAt i - firstElement is negative
		//yes-> 
		int prevEle = 0, time = 0;
		for (int i = 0; i < s.length(); i++) {
			int diff = Math.abs(s.charAt(i)-'A'-prevEle);
			int circularDiff = Math.abs(26-diff);
			time += Math.min(diff, circularDiff);
			prevEle = s.charAt(i)-'A';
		}
		System.out.println(time);
		return time;
	}
	
	private int findDis(String s){
		int distance = 0;

		for (int i = 0; i < s.length(); i++) {
			int asciiDiff = 0;
			if (i == 0) 						// First time alone get distance from A
				asciiDiff = Math.abs((int) s.charAt(i) - 65);
			else 
				asciiDiff = Math.abs((int) s.charAt(i) - (int) s.charAt(i - 1));  // get distance from previous character
			int freq = 26 - asciiDiff;
			int min = Math.min(asciiDiff, freq);
			distance += min;
		}
		System.out.println(distance);
		return distance;
	}
}
