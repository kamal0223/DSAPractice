package fullweek.onsite;

import org.junit.Test;

import junit.framework.Assert;

/*
Given a binary array nums and an integer k, return the maximum number of 
consecutive 1's in the array if you can flip at most k 0's.
 */
public class BinaryNumberFlip {

	@Test
	public void test1() {
		int[] input = {1,1,1,0,0,0,1,1,1,1,0};
		int k = 2;
		Assert.assertEquals(6, maxOnesByFlip(input,k));
	}
	
	@Test
	public void test2() {
		int[] input = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
		int k = 2;
		Assert.assertEquals(6, maxOnesByFlip(input,k));
	}
	
	@Test
	public void test3() {
		int[] input = {1,1,1,0,0,0,1,1,1,1,0};
		int k = 2;
		Assert.assertEquals(6, maxOnesByFlip(input,k));
	}
}
